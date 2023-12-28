/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package org.itenas.uas.view.component;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;
import org.itenas.uas.pojo.Admin;
import org.itenas.uas.pojo.Akun;
import org.itenas.uas.pojo.Member;
import org.itenas.uas.service.AkunService;
import org.itenas.uas.serviceimpl.AkunServiceImpl;
import org.itenas.uas.view.component.swing.Button;
import org.itenas.uas.view.component.swing.MyPasswordField;
import org.itenas.uas.view.component.swing.MyTextField;

/**
 *
 * @author Win10
 */
public class PanelLoginAndRegister extends javax.swing.JLayeredPane {
    
    private Akun akun;
    private Member member;
    private Admin admin;
    AkunService akunService = new AkunServiceImpl();
    
    public PanelLoginAndRegister() {
        initComponents();
        initRegister();;
        initLogin();
        login.setVisible(false);
        register.setVisible(true);
    }
    
    private void initRegister(){
        register.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]25[]10[]10[]25[]push"));
        JLabel label = new JLabel("Buat Akun");
        label.setFont(new Font("sanserif", 1, 30));
        label.setForeground(new Color(245, 172, 44));
        register.add(label);
        MyTextField txtId = new MyTextField();
        txtId.setHint("ID");
        register.add(txtId, "w 60%, wrap");
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
        Button cmd = new Button();
        cmd.setBackground(new Color(245, 172, 44));
        cmd.setForeground(new Color(255, 255, 255));
        cmd.setText("BUAT AKUN");
        register.add(cmd, "w 40%, h 40");
        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String id = txtId.getText();
                String userName = txtUser.getText().trim();
                String email = txtEmail.getText().trim();
                String password = String.valueOf(txtPass.getPassword());
                
                akun = new Akun();
                akun.setEmail(email);
                akun.setUsername(userName);
                akun.setPassword(password);
                
                if(id.startsWith("M")){
                    member = new Member();
                    member.setId(id);
                    member.setAkun(akun);
                    akunService.register(member);
                    
                } 
                else if(id.startsWith("A")){
                    admin = new Admin();
                    admin.setId(id);
                }
            }
        });
    }
    private void initLogin(){
        login.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]20[]25[]push"));
        JLabel label = new JLabel("Masuk");
        label.setFont(new Font("sansserif", 1, 30));
        label.setForeground(new Color(245, 172, 44));
        login.add(label);
        MyTextField txtEmail = new MyTextField();
        txtEmail.setPrefixIcon(new ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\org\\itenas\\uas\\images\\mail.png"));
        txtEmail.setHint("Email");
        login.add(txtEmail, "w 60%");
        MyPasswordField txtPass = new MyPasswordField();
        txtPass.setPrefixIcon(new ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\org\\itenas\\uas\\images\\pass.png"));
        txtPass.setHint("Password");
        login.add(txtPass, "w 60%");
        Button cmd = new Button();
        cmd.setBackground(new Color(245, 172, 44));
        cmd.setForeground(new Color(255, 255, 255));
        cmd.setText("MASUK");
        login.add(cmd, "w 40%, h 40");
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
