/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.itenas.uas.view.component;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import org.itenas.uas.pojo.Member;
import org.itenas.uas.service.MemberService;
import org.itenas.uas.serviceimpl.MemberServiceImpl;

/**
 *
 * @author Win10
 */
public class CrudMember extends javax.swing.JFrame {

    MemberService memberService;
    
    public CrudMember() {
        initComponents();
        this.setLocationRelativeTo(null);
        tbl_member.fixTable(jScrollPane1);
        DefaultTableModel mode = (DefaultTableModel) tbl_member.getModel();
        for (int i = 1; i <= 20; i++) {
            mode.addRow(new Object[]{i, "Ra Ven", 10, "001 001 001", "PP"});
        }
        //loadData();

    }
    
    private void loadData() {
        memberService = new MemberServiceImpl();
        List<Member> listMember = new ArrayList<>();
        listMember = memberService.findAll();
        Object[][] objectMember = new Object[listMember.size()][5];
        
        int counter = 0;
        
        for (Member member : listMember) {
            objectMember[counter][0] = member.getId();
            objectMember[counter][1] = member.getNama();
            objectMember[counter][2] = member.getAlamat();
            objectMember[counter][3] = member.getEmail();
            objectMember[counter][4] = member.getNomorTelp();
            counter++;
        }
        tbl_member.setModel(new javax.swing.table.DefaultTableModel(
            objectMember,
            new String [] {
                "ID_Member", "Nama_Member", "Alamat", "Email", "Nomor_Telepon"
            }
        ));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Background = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        Judul = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txt_search = new org.itenas.uas.view.component.swing.MyTextField();
        btn_search = new org.itenas.uas.view.component.swing.Button();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_member = new org.itenas.uas.view.component.swing.TableDark();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setLocationByPlatform(true);
        setMaximumSize(new java.awt.Dimension(32767, 32767));
        setUndecorated(true);

        Background.setBackground(new java.awt.Color(255, 255, 255));
        Background.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Background.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                BackgroundMouseDragged(evt);
            }
        });
        Background.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BackgroundMousePressed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(245, 172, 44));
        jPanel1.setForeground(new java.awt.Color(241, 149, 33));

        Judul.setBackground(new java.awt.Color(255, 255, 255));
        Judul.setFont(new java.awt.Font("SansSerif", 1, 30)); // NOI18N
        Judul.setForeground(new java.awt.Color(255, 255, 255));
        Judul.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Judul.setText("Member List");
        Judul.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(365, 365, 365)
                .addComponent(Judul)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(Judul)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(245, 172, 44));
        jLabel1.setText("Masukkan ID Member:");

        btn_search.setBackground(new java.awt.Color(245, 172, 44));
        btn_search.setForeground(new java.awt.Color(255, 255, 255));
        btn_search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/success.png"))); // NOI18N
        btn_search.setText("Cari");
        btn_search.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        tbl_member.setBackground(new java.awt.Color(204, 204, 204));
        tbl_member.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID_Member", "Nama_Member", "Alamat", "Email", "Nomor_Telepon"
            }
        ));
        jScrollPane1.setViewportView(tbl_member);

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("ID_Member");

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Nama_Member");

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Alamat");

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Email");

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Nomor_Telepon");

        javax.swing.GroupLayout BackgroundLayout = new javax.swing.GroupLayout(Background);
        Background.setLayout(BackgroundLayout);
        BackgroundLayout.setHorizontalGroup(
            BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(BackgroundLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BackgroundLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_search, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(BackgroundLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 606, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(111, 111, 111)
                        .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))))
                .addContainerGap(172, Short.MAX_VALUE))
        );
        BackgroundLayout.setVerticalGroup(
            BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackgroundLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_search, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BackgroundLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(BackgroundLayout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Background, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Background, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BackgroundMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackgroundMousePressed
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_BackgroundMousePressed

    private void BackgroundMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackgroundMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x-xx,y-xy);
    }//GEN-LAST:event_BackgroundMouseDragged

    int xx,xy;
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CrudMember.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrudMember.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrudMember.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrudMember.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CrudMember().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Background;
    private javax.swing.JLabel Judul;
    private org.itenas.uas.view.component.swing.Button btn_search;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private org.itenas.uas.view.component.swing.TableDark tbl_member;
    private org.itenas.uas.view.component.swing.MyTextField txt_search;
    // End of variables declaration//GEN-END:variables
}
