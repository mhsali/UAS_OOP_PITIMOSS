/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.itenas.uas.view.component;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.itenas.uas.pojo.Buku;
import org.itenas.uas.pojo.Komik;
import org.itenas.uas.pojo.Member;
import org.itenas.uas.pojo.Sewa;
import org.itenas.uas.service.SewaService;
import org.itenas.uas.serviceimpl.MemberServiceImpl;
import org.itenas.uas.serviceimpl.SewaServiceImpl;
import static org.itenas.uas.view.component.SewaBuku.listSewa;
import org.itenas.uas.view.main.Main;

/**
 *
 * @author Andre
 */
public class AdminDashboard extends javax.swing.JFrame {

    /**
     * Creates new form AdminDashboard
     */
    SewaService sewaService;
    public AdminDashboard() {
        initComponents();
        loadData();
    }
    
    public void loadData() {
        sewaService = new SewaServiceImpl();
        List<Sewa> listSewa = sewaService.findAll(); 
         Object[][] objectSewa = new Object[listSewa.size()][9];
        
        int counter = 0;

        for (Sewa sewa : listSewa) {
            objectSewa[counter][0] = sewa.getId();
            objectSewa[counter][1] = sewa.getTglSewa();
            objectSewa[counter][2] = sewa.getTglKembali();
            objectSewa[counter][3] = sewa.getTotalHarga();
            objectSewa[counter][4] = sewa.getDenda();
            objectSewa[counter][5] = sewa.getStatus();
            objectSewa[counter][6] = sewa.getBuku().getId();
            objectSewa[counter][7] = sewa.getKomik().getId();
            objectSewa[counter][8] = sewa.getMember().getId();
            counter++;
        }                                         
        table_transaksi.setModel(new javax.swing.table.DefaultTableModel(
                objectSewa,
                new String[]{
                        "ID Sewa", "Tgl Sewa", "Tgl Kembali", "Total Harga", "Denda", "Status", "ID Buku", "ID Komik", "ID Member"
                        
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

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        sewaBuku = new org.itenas.uas.view.component.swing.ButtonOutLine();
        sewaBuku1 = new org.itenas.uas.view.component.swing.ButtonOutLine();
        sewaBuku2 = new org.itenas.uas.view.component.swing.ButtonOutLine();
        sewaBuku4 = new org.itenas.uas.view.component.swing.ButtonOutLine();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_transaksi = new org.itenas.uas.view.component.swing.TableDark();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(55, 55, 55));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 203, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 71, Short.MAX_VALUE)
        );

        sewaBuku.setForeground(new java.awt.Color(255, 255, 255));
        sewaBuku.setText("Manage Buku");
        sewaBuku.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        sewaBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sewaBukuActionPerformed(evt);
            }
        });

        sewaBuku1.setForeground(new java.awt.Color(255, 255, 255));
        sewaBuku1.setText("Manage Komik");
        sewaBuku1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        sewaBuku1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sewaBuku1ActionPerformed(evt);
            }
        });

        sewaBuku2.setForeground(new java.awt.Color(255, 255, 255));
        sewaBuku2.setText("Manage Member");
        sewaBuku2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        sewaBuku2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sewaBuku2ActionPerformed(evt);
            }
        });

        sewaBuku4.setForeground(new java.awt.Color(255, 255, 255));
        sewaBuku4.setText("Logout");
        sewaBuku4.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        sewaBuku4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sewaBuku4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sewaBuku1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sewaBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sewaBuku2, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sewaBuku4, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(597, 597, 597)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(sewaBuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(sewaBuku1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(sewaBuku2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 346, Short.MAX_VALUE)
                .addComponent(sewaBuku4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 180, 620));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(187, 187, 187));

        jPanel7.setBackground(new java.awt.Color(245, 172, 44));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 230, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 140, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 230, 170));

        jPanel6.setBackground(new java.awt.Color(187, 187, 187));

        jPanel8.setBackground(new java.awt.Color(245, 172, 44));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 230, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 140, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 70, -1, -1));

        table_transaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Sewa", "Tgl Sewa", "Tgl Kembali", "Total Harga", "Denda", "Status", "ID Buku", "ID Komik", "ID Member"
            }
        ));
        table_transaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_transaksiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_transaksi);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 810, 280));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 830, 620));

        jPanel5.setBackground(new java.awt.Color(245, 172, 44));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Welcome Admin!!");
        jPanel5.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 20, -1, 37));

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 80));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void table_transaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_transaksiMouseClicked
        
    }//GEN-LAST:event_table_transaksiMouseClicked

    private void sewaBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sewaBukuActionPerformed
       BukuManagement BukuManajemen = new BukuManagement();
       BukuManajemen.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_sewaBukuActionPerformed

    private void sewaBuku1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sewaBuku1ActionPerformed
        KomikManagement komikManajemen = new KomikManagement();
       komikManajemen.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_sewaBuku1ActionPerformed

    private void sewaBuku2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sewaBuku2ActionPerformed
        MemberManagement memberManajemen = new MemberManagement();
       memberManajemen.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_sewaBuku2ActionPerformed

    private void sewaBuku4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sewaBuku4ActionPerformed
         int dialogButton = JOptionPane.YES_NO_OPTION;
        
        int dialogResult = JOptionPane.showConfirmDialog (null, "Apakah anda yakin ingin logout", "Warning", dialogButton);
        if(dialogResult == JOptionPane.YES_OPTION){
            Main login = new Main();
       login.setVisible(true);
       this.dispose();

        }
    }//GEN-LAST:event_sewaBuku4ActionPerformed

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
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private org.itenas.uas.view.component.swing.ButtonOutLine sewaBuku;
    private org.itenas.uas.view.component.swing.ButtonOutLine sewaBuku1;
    private org.itenas.uas.view.component.swing.ButtonOutLine sewaBuku2;
    private org.itenas.uas.view.component.swing.ButtonOutLine sewaBuku4;
    private org.itenas.uas.view.component.swing.TableDark table_transaksi;
    // End of variables declaration//GEN-END:variables
}
