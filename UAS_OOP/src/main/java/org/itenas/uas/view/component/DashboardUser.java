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
import org.itenas.uas.serviceimpl.BukuServiceImpl;
import org.itenas.uas.serviceimpl.KomikServiceImpl;
import org.itenas.uas.view.main.Main;

/**
 *
 * @author lin
 */
public class DashboardUser extends javax.swing.JFrame {

        BukuServiceImpl bukuService;
        KomikServiceImpl komikService;

    public boolean isEmpty(){
        
            return false;
        
    }
    
    private boolean userLoggedIn = false;
    
    private void updateButtonStatus() {
    boolean enableButtons = userLoggedIn;

    
    }
    
    
    public DashboardUser() {
        initComponents();
    }
    
    private void displaySearchedBuku(List<Buku> searchedBuku) {
    if (!searchedBuku.isEmpty()) {
        Object[][] objectBuku = new Object[searchedBuku.size()][7];

        int counter = 0;

        for (Buku buku : searchedBuku) {
            objectBuku[counter][0] = buku.getId();
            objectBuku[counter][1] = buku.getJudul();
            objectBuku[counter][2] = buku.getPengarang();
            objectBuku[counter][3] = buku.getPenerbit();
            objectBuku[counter][4] = buku.getTahunTerbit();
            objectBuku[counter][5] = buku.getHarga();
            objectBuku[counter][6] = buku.getStatus();

            counter++;
        }

        // Sesuaikan tabel_buku dengan nama komponen tabel yang Anda gunakan
        tabel_buku.setModel(new javax.swing.table.DefaultTableModel(
                objectBuku,
                new String[]{"ID", "Judul", "Pengarang", "Penerbit", "Tahun Terbit", "Harga", "Status"}
        ));
    } else {
        JOptionPane.showMessageDialog(null, "Data tidak ditemukan!");
    }
}

    private void displaySearchedKomik(List<Komik> searchedKomik) {
    if (!searchedKomik.isEmpty()) {
        Object[][] objectKomik = new Object[searchedKomik.size()][10];

        int counter = 0;

        for (Komik komik : searchedKomik) {
            objectKomik[counter][0] = komik.getId();
            objectKomik[counter][1] = komik.getJudul();
            objectKomik[counter][2] = komik.getPengarang();
            objectKomik[counter][3] = komik.getPenerbit();
            objectKomik[counter][4] = komik.getTahunTerbit();
            objectKomik[counter][5] = komik.getHarga();
            objectKomik[counter][6] = komik.getStatus();
            objectKomik[counter][7] = komik.getVolume();
            counter++;
        }

        // Sesuaikan tabel_buku dengan nama komponen tabel yang Anda gunakan
        tabel_buku.setModel(new javax.swing.table.DefaultTableModel(
                objectKomik,
                new String[]{"ID", "Judul", "Pengarang", "Penerbit", "Tahun Terbit", "Harga", "Status","Volume"}
        ));
    } else {
        JOptionPane.showMessageDialog(null, "Data tidak ditemukan!");
    }
}

    
        private void emptyField() {
        txtJudul.setText("");
        txtJudul.setText("");
        txtPenerbit.setText("");
    }
   
        
        
        
    private void loadDataKomik() {
        KomikServiceImpl komikService = new KomikServiceImpl();
    List<Komik> listKomik = komikService.findAll(); // 
    Object[][] objectKomik = new Object[listKomik.size()][10]; 

    int counter = 0;

    for (Komik komik : listKomik) {
        objectKomik[counter][0] = komik.getId();
        objectKomik[counter][1] = komik.getJudul();
        objectKomik[counter][2] = komik.getPengarang();
        objectKomik[counter][3] = komik.getPenerbit();
        objectKomik[counter][4] = komik.getTahunTerbit();
        objectKomik[counter][5] = komik.getHarga();
        objectKomik[counter][6] = komik.getStatus();
        objectKomik[counter][7] = komik.getVolume();

        
        counter++;
    }

    tabel_buku.setModel(new javax.swing.table.DefaultTableModel(
        objectKomik,
        new String[] {
            "ID", "Judul", "Pengarang", "Penerbit", "Tahun Terbit", "Harga", "Status", "Volume"
        }
    ));
}


    
    private void loadDataBuku() {
        BukuServiceImpl bukuService = new BukuServiceImpl();
        List<Buku> listBuku = bukuService.findAll();
        Object[][] objectBuku = new Object[listBuku.size()][10]; 

        int counter = 0;

        for (Buku buku : listBuku) {
            objectBuku[counter][0] = buku.getId();
            objectBuku[counter][1] = buku.getJudul();
            objectBuku[counter][2] = buku.getPengarang();
            objectBuku[counter][3] = buku.getPenerbit();
            objectBuku[counter][4] = buku.getTahunTerbit();
            objectBuku[counter][5] = buku.getHarga();
            objectBuku[counter][6] = buku.getStatus();

            counter++;
        }

        tabel_buku.setModel(new javax.swing.table.DefaultTableModel(
            objectBuku,
            new String[] {
                "ID", "Judul", "Pengarang", "Penerbit", "Tahun Terbit", "Harga", "Status"
            }
        ));
    }

    private void setupTableColumns(boolean isBuku) {
        DefaultTableModel model = (DefaultTableModel) tabel_buku.getModel();
        model.setColumnCount(0); // 

        if (isBuku) {
            model.addColumn("ID");
            model.addColumn("Judul");
            model.addColumn("Pengarang");
            model.addColumn("Penerbit");
            model.addColumn("Tahun Terbit");
            model.addColumn("Harga");
            model.addColumn("Status");
        } else {
            model.addColumn("ID");
            model.addColumn("Judul");
            model.addColumn("Pengarang");
            model.addColumn("Penerbit");
            model.addColumn("Tahun Terbit");
            model.addColumn("Harga");
            model.addColumn("Status");
            model.addColumn("Volume");

        }
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        radio_group = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        buttonOutLine1 = new org.itenas.uas.view.component.swing.ButtonOutLine();
        sewaBuku = new org.itenas.uas.view.component.swing.ButtonOutLine();
        bacaBuku = new org.itenas.uas.view.component.swing.ButtonOutLine();
        bacaKomik = new org.itenas.uas.view.component.swing.ButtonOutLine();
        buttonOutLine5 = new org.itenas.uas.view.component.swing.ButtonOutLine();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtPenerbit = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtJudul = new javax.swing.JTextField();
        radio_komik = new javax.swing.JRadioButton();
        radio_buku = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel_buku = new org.itenas.uas.view.component.swing.TableDark();
        cancel = new org.itenas.uas.view.component.swing.ButtonOutLine();
        sewaBuku2 = new org.itenas.uas.view.component.swing.ButtonOutLine();
        txtPengarang1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(245, 175, 72));

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logopitimoss.png"))); // NOI18N

        buttonOutLine1.setText("Login");
        buttonOutLine1.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        buttonOutLine1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOutLine1ActionPerformed(evt);
            }
        });

        sewaBuku.setText("Sewa Buku");
        sewaBuku.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        sewaBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sewaBukuActionPerformed(evt);
            }
        });

        bacaBuku.setText("Baca Buku");
        bacaBuku.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        bacaBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bacaBukuActionPerformed(evt);
            }
        });

        bacaKomik.setText("Sewa Baca");
        bacaKomik.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        bacaKomik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bacaKomikActionPerformed(evt);
            }
        });

        buttonOutLine5.setText("Sewa Komik");
        buttonOutLine5.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        buttonOutLine5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOutLine5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bacaKomik, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonOutLine5, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bacaBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sewaBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(buttonOutLine1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(sewaBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(bacaBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(buttonOutLine5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(bacaKomik, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonOutLine1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78))
        );

        jPanel3.setBackground(new java.awt.Color(245, 144, 44));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Pengarang:");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 95, -1));

        txtPenerbit.setBackground(new java.awt.Color(245, 144, 44));
        txtPenerbit.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        txtPenerbit.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        jPanel3.add(txtPenerbit, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, 250, -1));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Penerbit:");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 95, -1));

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Judul Buku");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 95, -1));

        txtJudul.setBackground(new java.awt.Color(245, 144, 44));
        txtJudul.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        txtJudul.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        txtJudul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtJudulActionPerformed(evt);
            }
        });
        jPanel3.add(txtJudul, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, 250, -1));

        radio_group.add(radio_komik);
        radio_komik.setText("Komik");
        radio_komik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radio_komikActionPerformed(evt);
            }
        });
        jPanel3.add(radio_komik, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 140, -1, -1));

        radio_group.add(radio_buku);
        radio_buku.setText("Buku");
        radio_buku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radio_bukuActionPerformed(evt);
            }
        });
        jPanel3.add(radio_buku, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 140, -1, -1));

        jLabel9.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel9.setText("Judul Buku:");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 95, -1));

        tabel_buku.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Judul", "Pengarang", "Penerbit"
            }
        ));
        tabel_buku.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_bukuMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabel_buku);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 860, 520));

        cancel.setForeground(new java.awt.Color(255, 255, 255));
        cancel.setText("Cancel");
        cancel.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        jPanel3.add(cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 90, 120, -1));

        sewaBuku2.setForeground(new java.awt.Color(255, 255, 255));
        sewaBuku2.setText("Oke");
        sewaBuku2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        sewaBuku2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sewaBuku2ActionPerformed(evt);
            }
        });
        jPanel3.add(sewaBuku2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 30, 120, -1));

        txtPengarang1.setBackground(new java.awt.Color(245, 144, 44));
        txtPengarang1.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        txtPengarang1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        jPanel3.add(txtPengarang1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, 250, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 958, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(280, 280, 280))
        );

        setSize(new java.awt.Dimension(1114, 707));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void radio_komikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radio_komikActionPerformed
        loadDataKomik();
    setupTableColumns(false);

    }//GEN-LAST:event_radio_komikActionPerformed

    private void radio_bukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radio_bukuActionPerformed
        loadDataBuku();
        setupTableColumns(true);
    }//GEN-LAST:event_radio_bukuActionPerformed

    private void tabel_bukuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_bukuMouseClicked
       int row = tabel_buku.getSelectedRow();

// Mendapatkan data dari setiap sel di baris terpilih
String id = tabel_buku.getValueAt(row, 0).toString();
String judul = tabel_buku.getValueAt(row, 1).toString();
String pengarang = tabel_buku.getValueAt(row, 2).toString();
String penerbit = tabel_buku.getValueAt(row, 3).toString();
String tahunTerbit = tabel_buku.getValueAt(row, 4).toString();
String harga = tabel_buku.getValueAt(row, 5).toString();
String status = tabel_buku.getValueAt(row, 6).toString();

 txtJudul.setText(judul);
 txtJudul.setText(pengarang);
 txtPenerbit.setText(penerbit);
    }//GEN-LAST:event_tabel_bukuMouseClicked

    private void buttonOutLine1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOutLine1ActionPerformed
        Main main = new Main();
        main.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_buttonOutLine1ActionPerformed

    private void sewaBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sewaBukuActionPerformed
   updateButtonStatus(); 

        
        if (userLoggedIn) {
             JOptionPane.showMessageDialog(null, "gacors");
        } else {
            JOptionPane.showMessageDialog(null, "Anda harus login untuk melakukan tindakan ini!");
        }
    }//GEN-LAST:event_sewaBukuActionPerformed

    private void bacaBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bacaBukuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bacaBukuActionPerformed

    private void bacaKomikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bacaKomikActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bacaKomikActionPerformed

    private void buttonOutLine5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOutLine5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonOutLine5ActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
    emptyField();
    }//GEN-LAST:event_cancelActionPerformed

    private void sewaBuku2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sewaBuku2ActionPerformed
        bukuService = new BukuServiceImpl();
        komikService = new KomikServiceImpl();

        if (radio_buku.isSelected() && !txtJudul.getText().isEmpty()) {
            String judul = txtJudul.getText();
            List<Buku> searchedJudulBuku = bukuService.findBacaanByJudul(judul);

            if (!searchedJudulBuku.isEmpty()) {
                displaySearchedBuku(searchedJudulBuku);
            } else {
                JOptionPane.showMessageDialog(null, "Data buku tidak ditemukan!");
            }
        } else if (radio_komik.isSelected() && !txtJudul.getText().isEmpty()) {
            String judul = txtJudul.getText();
            List<Komik> searchedJudulKomik = komikService.findBacaanByJudul(judul);

            if (!searchedJudulKomik.isEmpty()) {
                displaySearchedKomik(searchedJudulKomik);
            } else {
                JOptionPane.showMessageDialog(null, "Data komik tidak ditemukan!");
            }
        } else if (radio_buku.isSelected() && !txtPenerbit.getText().isEmpty()) {
            String penerbit = txtPenerbit.getText();
            List<Buku> searchedPenerbitBuku = bukuService.findBacaanByPenerbit(penerbit);

            if (!searchedPenerbitBuku.isEmpty()) {
                displaySearchedBuku(searchedPenerbitBuku);
            } else {
                JOptionPane.showMessageDialog(null, "Data buku tidak ditemukan!");
            }
        } else if (radio_komik.isSelected() && !txtPenerbit.getText().isEmpty()) {
            String penerbit = txtPenerbit.getText();
            List<Komik> searchedPenerbitKomik = komikService.findBacaanByPenerbit(penerbit);

            if (!searchedPenerbitKomik.isEmpty()) {
                displaySearchedKomik(searchedPenerbitKomik);
            } else {
                JOptionPane.showMessageDialog(null, "Data komik tidak ditemukan!");
            }
        } else if (radio_buku.isSelected() && !txtPengarang1.getText().isEmpty()) {
            String pengarang = txtPengarang1.getText();
            List<Buku> searchedByPengarang = bukuService.findBacaanByPengarang(pengarang);

            if (!searchedByPengarang.isEmpty()) {
                displaySearchedBuku(searchedByPengarang);
            } else {
                JOptionPane.showMessageDialog(null, "Data buku tidak ditemukan!");
            }
        } else if (radio_komik.isSelected() && !txtPengarang1.getText().isEmpty()) {
            String pengarang = txtPengarang1.getText();
            List<Komik> searchedByPengarangKomik = komikService.findBacaanByPengarang(pengarang);

            if (!searchedByPengarangKomik.isEmpty()) {
                displaySearchedKomik(searchedByPengarangKomik);
            } else {
                JOptionPane.showMessageDialog(null, "Data komik tidak ditemukan!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Silakan pilih jenis pencarian dan isi data yang sesuai.");
        }
    }//GEN-LAST:event_sewaBuku2ActionPerformed

    private void txtJudulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtJudulActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtJudulActionPerformed
 
    
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
            java.util.logging.Logger.getLogger(DashboardUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DashboardUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DashboardUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DashboardUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DashboardUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.itenas.uas.view.component.swing.ButtonOutLine bacaBuku;
    private org.itenas.uas.view.component.swing.ButtonOutLine bacaKomik;
    private org.itenas.uas.view.component.swing.ButtonOutLine buttonOutLine1;
    private org.itenas.uas.view.component.swing.ButtonOutLine buttonOutLine5;
    private org.itenas.uas.view.component.swing.ButtonOutLine cancel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel logo;
    private javax.swing.JRadioButton radio_buku;
    private javax.swing.ButtonGroup radio_group;
    private javax.swing.JRadioButton radio_komik;
    private org.itenas.uas.view.component.swing.ButtonOutLine sewaBuku;
    private org.itenas.uas.view.component.swing.ButtonOutLine sewaBuku2;
    private org.itenas.uas.view.component.swing.TableDark tabel_buku;
    private javax.swing.JTextField txtJudul;
    private javax.swing.JTextField txtPenerbit;
    private javax.swing.JTextField txtPengarang1;
    // End of variables declaration//GEN-END:variables

}
