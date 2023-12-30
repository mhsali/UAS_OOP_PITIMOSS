/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package org.itenas.uas.view.component;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.Timer;
import net.miginfocom.swing.MigLayout;
import org.itenas.uas.pojo.Admin;
import org.itenas.uas.pojo.Akun;
import org.itenas.uas.pojo.Member;
import org.itenas.uas.service.AkunService;
import org.itenas.uas.service.LoginService;
import org.itenas.uas.serviceimpl.AkunServiceImpl;
import org.itenas.uas.serviceimpl.LoginServiceImpl;
import org.itenas.uas.view.component.swing.Button;
import org.itenas.uas.view.component.swing.Label;
import org.itenas.uas.view.component.swing.MyPasswordField;
import org.itenas.uas.view.component.swing.MyTextField;
import org.itenas.uas.view.component.swing.ShowPasswordCheckBox;

/**
 *
 * @author Win10
 */
public class PanelLoginAndRegister extends javax.swing.JLayeredPane {

    public Member getMember() {
        return member;
    }

    public Admin getAdmin() {
        return admin;
    }

    public String getId() {
        return id;
    }
    
    private Akun akun;
    private Member member;
    private Admin admin;
    private String id;
    private AkunService akunService;
    private LoginService loginService;
    private Message.MessageType messageType;
    private Label txtLabel;
    private JLabel hiddenLabel;
    
    public PanelLoginAndRegister(ActionListener eventRegister, ActionListener eventLogin) {
        initComponents();
        initRegister(eventRegister);
        initLogin(eventLogin);
        login.setVisible(false);
        register.setVisible(true);
        txtLabel = new Label();
    }
    
    private void initRegister(ActionListener eventRegister){
        register.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]15[]10[]10[]10[]25[]push"));
        JLabel label = new JLabel("Buat Akun");
        label.setFont(new Font("sanserif", 1, 30));
        label.setForeground(new Color(245, 172, 44));
        register.add(label);
        
        MyTextField txtId = new MyTextField();
        txtId.setHint("ID");
        register.add(txtId, "w 60%, wrap");
        
        hiddenLabel = new JLabel("Data tidak ada!");
        hiddenLabel.setForeground(new Color(255, 0, 0));
        hiddenLabel.setVisible(false); // Disembunyikan awalnya
        register.add(hiddenLabel, "span, left, wrap");
        
        txtId.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                id = txtId.getText();
                cekData(id);
                if (txtId.getText().isEmpty()) {
                    hiddenLabel.setVisible(false);
                }
            }
        });

        
        MyTextField txtUser = new MyTextField();
        txtUser.setPrefixIcon(new ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\org\\itenas\\uas\\images\\user.png"));
        txtUser.setHint("Username");
        register.add(txtUser, "w 60%");
        
        MyTextField txtEmail = new MyTextField();
        txtEmail.setPrefixIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\org\\itenas\\uas\\images\\mail.png"));
        txtEmail.setHint("Email");
        register.add(txtEmail, "w 60%");
        
        MyPasswordField txtPass = new MyPasswordField();
        txtPass.setPrefixIcon(new ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\org\\itenas\\uas\\images\\pass.png"));
        txtPass.setHint("Password");
        register.add(txtPass, "w 60%");
        
        ShowPasswordCheckBox registerPassShow = new ShowPasswordCheckBox();
        register.add(registerPassShow, "pos 475 342 n n");
        showPassword(registerPassShow, txtPass);
        
        Button cmd = new Button();
        cmd.setBackground(new Color(245, 172, 44));
        cmd.setForeground(new Color(255, 255, 255));
        cmd.setText("BUAT AKUN");
        register.add(cmd, "w 40%, h 40");
        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String userName = txtUser.getText().trim();
                String email = txtEmail.getText().trim();
                String password = String.valueOf(txtPass.getPassword());
                
                akun = new Akun();
                akun.setEmail(email);
                akun.setUsername(userName);
                akun.setPassword(password);
                
                if(id != null && akun != null){
                    register(id);
                } else{
                    showMessage(Message.MessageType.ERROR, "Semua Kolom Harus diisi!", "register");
                }
            }
        });
    }
    private void initLogin(ActionListener eventLogin){
        login.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]20[]25[]push"));
        JLabel label = new JLabel("Masuk");
        label.setFont(new Font("sansserif", 1, 30));
        label.setForeground(new Color(245, 172, 44));
        login.add(label);
        
        MyTextField txtEmail = new MyTextField();
        txtEmail.setPrefixIcon(new ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\org\\itenas\\uas\\images\\user.png"));
        txtEmail.setHint("Username");
        login.add(txtEmail, "w 55%");
        
        MyPasswordField txtPass = new MyPasswordField();
        txtPass.setPrefixIcon(new ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\org\\itenas\\uas\\images\\pass.png"));
        txtPass.setHint("Password");
        login.add(txtPass, "w 55%");;

        ShowPasswordCheckBox loginPassShow = new ShowPasswordCheckBox();
        login.add(loginPassShow, "pos 470 272 n n");
        showPassword(loginPassShow, txtPass);
        
        Button cmd = new Button();
        cmd.setBackground(new Color(245, 172, 44));
        cmd.setForeground(new Color(255, 255, 255));
        cmd.setText("MASUK");
        login.add(cmd, "w 40%, h 40");
        cmd.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = txtEmail.getText().trim();
                String password = String.valueOf(txtPass.getPassword());
                
                akun = new Akun();
                akun.setUsername(username);
                akun.setPassword(password);
                
                if(!username.isEmpty() && !password.isEmpty()){
                    login(username, password);
                } else{
                    showMessage(Message.MessageType.ERROR, "Semua Kolom Harus diisi!", "login");
                }
            }
            
        });
    }
    
    private void register(String id){
        if(id != null && id.startsWith("M")){
            member = new Member();
            member.setId(id);
            member.setAkun(akun);
                    
            akunService = new AkunServiceImpl();
            if(!akunService.cekUsername(akun.getUsername())){
                if(!akun.getUsername().isEmpty() && 
                      !akun.getEmail().isEmpty() && !akun.getPassword().isEmpty()){
                    akunService.register(member);
                    showMessage(Message.MessageType.SUCCESS, "Register Berhasil", "register");
                } else{
                    hiddenLabel.setVisible(true);
                    hiddenLabel.setText("Semua kolom harus diisi!");
                }
            } else{
                showMessage(Message.MessageType.ERROR, "Error Register", "register");
            }
        } 
        else if(id.startsWith("A")){
            admin = new Admin();
            admin.setId(id);
        }
    }
    
    private void login(String username, String Password){
        String result;
        loginService = new LoginServiceImpl();
        result = loginService.pilihData(username, Password);
        
        if(result.equals("Member")){
            member = new Member();
            akunService = new AkunServiceImpl();
            member = akunService.login(username, Password);
            
            if(member != null){
                showMessage(Message.MessageType.SUCCESS, "Login Berhasil!", "login");
            } else{
                showMessage(Message.MessageType.ERROR, "Login Gagal", "login");
            }
        }
        else if(result.equals("Admin")){
            
        } else{
            showMessage(Message.MessageType.ERROR, "Login Gagal", "login");
        }
    }
    
    private void cekData(String id){
        if(id.startsWith("M")){
            akunService = new AkunServiceImpl();
            if(!akunService.cekData(id)){
                hiddenLabel.setVisible(true);
            } else{
                hiddenLabel.setVisible(false);   
            }
        }
        else if(id.startsWith("A")){
            
        }
    }
    
    public void showRegister(boolean show) {
        if (show) {
            register.setVisible(true);
            login.setVisible(false);
        } else {
            register.setVisible(false);
            login.setVisible(true);
        }
    }
    
    public void showMessage(Message.MessageType messageType, String message, String action) {
        txtLabel.setHint(message);

        if(action.equals("login")) {
          txtLabel.showMessage(messageType, message);
          login.add(txtLabel, "pos 0.5al 30, w 40%", 0);
          login.revalidate();
          login.repaint();
        
        } else if (action.equals("register")) {
          txtLabel.showMessage(messageType, message);
          register.add(txtLabel, "pos 0.5al 30, w 40%", 0);
          register.revalidate();
          register.repaint();
            
        }
        // Set visibilitas pop-up
        txtLabel.setVisible(true);

        Timer hideTimer = new Timer(1500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtLabel.setVisible(false);
                txtLabel.getParent().remove(txtLabel);
                revalidate();
                repaint();
            }
        });
        
        hideTimer.setRepeats(false);  // Hanya dijalankan sekali
        hideTimer.start();
        revalidate();
        repaint();
    }

    public void showPassword(JCheckBox show, JPasswordField pass){
        show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (show.isSelected()) {
                    pass.setEchoChar((char)0);
                } else {
                    pass.setEchoChar('*');
                }
            }
        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        login = new javax.swing.JPanel();
        register = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.CardLayout());

        login.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout loginLayout = new javax.swing.GroupLayout(login);
        login.setLayout(loginLayout);
        loginLayout.setHorizontalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 380, Short.MAX_VALUE)
        );
        loginLayout.setVerticalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        add(login, "card3");

        register.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout registerLayout = new javax.swing.GroupLayout(register);
        register.setLayout(registerLayout);
        registerLayout.setHorizontalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 380, Short.MAX_VALUE)
        );
        registerLayout.setVerticalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        add(register, "card2");
    }// </editor-fold>//GEN-END:initComponents

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel login;
    private javax.swing.JPanel register;
    // End of variables declaration//GEN-END:variables
}
