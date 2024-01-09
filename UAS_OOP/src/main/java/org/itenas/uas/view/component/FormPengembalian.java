/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.itenas.uas.view.component;

import java.awt.image.BufferedImage;
import net.coobird.thumbnailator.Thumbnails;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import org.itenas.uas.pojo.Buku;
import org.itenas.uas.pojo.Komik;
import org.itenas.uas.pojo.Member;
import org.itenas.uas.pojo.Sewa;
import org.itenas.uas.service.BukuService;
import org.itenas.uas.service.KomikService;
import org.itenas.uas.service.MemberService;
import org.itenas.uas.service.SewaService;
import org.itenas.uas.serviceimpl.BukuServiceImpl;
import org.itenas.uas.serviceimpl.MemberServiceImpl;
import org.itenas.uas.serviceimpl.TransaksiServiceImpl;
import static org.itenas.uas.view.component.FormTransaksiAdmin.listSewa;
import org.itenas.uas.service.TransaksiService;
import org.itenas.uas.serviceimpl.KomikServiceImpl;
import org.itenas.uas.serviceimpl.SewaServiceImpl;

/**
 *
 * @author Win10
 */
public class FormPengembalian extends javax.swing.JFrame {

    MemberService memberService;
    SewaService sewaService;
    TransaksiService transaksiService;
    Member member;
    Buku buku;
    Komik komik;
    Sewa sewa;
    int idSewa;
    static double dendaPerHari = 5000;
    
    public FormPengembalian() {
        initComponents();
        this.setLocationRelativeTo(null);
        tbl_sewa.fixTable(jScrollPane1);
        DefaultTableModel mode = (DefaultTableModel) tbl_sewa.getModel();
        lbl_hidden.setVisible(false);
    }

    private void emptyField(){
        txt_nama.setText("");
        txt_alamat.setText("");
        txt_email.setText("");
        txt_noTelp.setText("");
        DefaultTableModel model = (DefaultTableModel) tbl_sewa.getModel();
        model.setRowCount(0);
        txt_idBacaan.setText("");
        txt_judul.setText("");
        txt_pengarang.setText("");
        txt_tglSewa.setText("");
        txt_tglKembali.setText("");
        lbl_denda.setText("-");
        lbl_image.setIcon(null);
    }
    
    public void loadTabel(String idMember){
        transaksiService = new TransaksiServiceImpl();
        listSewa = new ArrayList<>();
        listSewa = transaksiService.cariPenyewaanMember(idMember);
        Object[][] objectSewa = new Object[listSewa.size()][8];
        
        int counter = 0;
        
        for (Sewa sewa : listSewa) {
            objectSewa[counter][0] = sewa.getMember().getId();
            objectSewa[counter][1] = sewa.getTglSewa();
            objectSewa[counter][2] = sewa.getTglKembali();
            objectSewa[counter][3] = sewa.getTotalHarga();
            objectSewa[counter][4] = sewa.getStatus();
            objectSewa[counter][5] = sewa.getBuku().getId();
            objectSewa[counter][6] = sewa.getKomik().getId();
            objectSewa[counter][7] = sewa.getId();
            counter++;
        }
        tbl_sewa.setModel(new javax.swing.table.DefaultTableModel(
            objectSewa,
            new String [] {
                "ID_Member", "Tgl_Sewa", "Tgl_Kembali", "Total_Harga", "Status", "ID_Buku", "ID_Komik", "ID_Sewa"
            }
        ));
    }
    
    private double hitungDenda(LocalDate dueDate) {
        // Menghitung selisih hari antara tanggal kembali dan tanggal sekarang
        long daysLate = ChronoUnit.DAYS.between(dueDate, LocalDate.now());

        // Menghitung total denda
        double totalFine = (double) (daysLate * dendaPerHari);

        return Math.max(totalFine, 0); // Memastikan denda tidak negatif
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btn_exit = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_sewa = new org.itenas.uas.view.component.swing.TableDark();
        txt_idMember = new javax.swing.JTextField();
        txt_nama = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_alamat = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        txt_noTelp = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_idBacaan = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_judul = new javax.swing.JTextField();
        txt_pengarang = new javax.swing.JTextField();
        btn_oke = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_tglSewa = new javax.swing.JTextField();
        txt_tglKembali = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lbl_denda = new javax.swing.JLabel();
        btn_pengembalian = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        lbl_hidden = new javax.swing.JLabel();
        btn_cancel = new javax.swing.JButton();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        lbl_image = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(245, 172, 44));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("FORM PENGEMBALIAN");

        btn_exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit.png"))); // NOI18N
        btn_exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_exitMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(341, 341, 341)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btn_exit)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_exit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(29, 29, 29))
        );

        bg.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 924, -1));

        tbl_sewa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Member", "Tgl Sewa", "Tgl Kembali", "Harga", "Status", "ID Buku", "ID Komik", "ID Sewa"
            }
        ));
        tbl_sewa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_sewaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_sewa);

        bg.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 351, 650, 206));

        txt_idMember.setBackground(new java.awt.Color(255, 255, 255));
        txt_idMember.setForeground(new java.awt.Color(0, 0, 0));
        txt_idMember.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(245, 172, 44)));
        txt_idMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idMemberActionPerformed(evt);
            }
        });
        bg.add(txt_idMember, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 153, 80, -1));

        txt_nama.setBackground(new java.awt.Color(255, 255, 255));
        txt_nama.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(245, 172, 44)));
        bg.add(txt_nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 153, 124, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user icon.png"))); // NOI18N
        bg.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 120, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(245, 172, 44));
        jLabel3.setText("ID Member");
        bg.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 112, -1, -1));

        txt_alamat.setBackground(new java.awt.Color(255, 255, 255));
        txt_alamat.setForeground(new java.awt.Color(0, 0, 0));
        txt_alamat.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(245, 172, 44)));
        bg.add(txt_alamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 183, 244, -1));

        txt_email.setBackground(new java.awt.Color(255, 255, 255));
        txt_email.setForeground(new java.awt.Color(0, 0, 0));
        txt_email.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(245, 172, 44)));
        bg.add(txt_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 212, 244, -1));

        txt_noTelp.setBackground(new java.awt.Color(255, 255, 255));
        txt_noTelp.setForeground(new java.awt.Color(0, 0, 0));
        txt_noTelp.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(245, 172, 44)));
        bg.add(txt_noTelp, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 241, 244, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(245, 172, 44));
        jLabel4.setText("Daftar Penyewaan");
        bg.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 322, -1, -1));

        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("*tekan Enter pada kolom ID Member setelah menginput untuk memunculkan data");
        bg.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 275, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(245, 172, 44));
        jLabel6.setText("ID Bacaan");
        bg.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(631, 125, -1, -1));

        txt_idBacaan.setEditable(false);
        txt_idBacaan.setBackground(new java.awt.Color(255, 255, 255));
        txt_idBacaan.setForeground(new java.awt.Color(0, 0, 0));
        txt_idBacaan.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(245, 172, 44)));
        bg.add(txt_idBacaan, new org.netbeans.lib.awtextra.AbsoluteConstraints(724, 125, 72, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(245, 172, 44));
        jLabel7.setText("Judul");
        bg.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(633, 175, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(245, 172, 44));
        jLabel8.setText("Pengarang");
        bg.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(633, 211, -1, -1));

        txt_judul.setEditable(false);
        txt_judul.setBackground(new java.awt.Color(255, 255, 255));
        txt_judul.setForeground(new java.awt.Color(0, 0, 0));
        txt_judul.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(245, 172, 44)));
        bg.add(txt_judul, new org.netbeans.lib.awtextra.AbsoluteConstraints(726, 175, 131, -1));

        txt_pengarang.setEditable(false);
        txt_pengarang.setBackground(new java.awt.Color(255, 255, 255));
        txt_pengarang.setForeground(new java.awt.Color(0, 0, 0));
        txt_pengarang.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(245, 172, 44)));
        bg.add(txt_pengarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(726, 211, 131, -1));

        btn_oke.setBackground(new java.awt.Color(102, 255, 153));
        btn_oke.setForeground(new java.awt.Color(255, 255, 255));
        btn_oke.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/success.png"))); // NOI18N
        btn_oke.setText("OK");
        btn_oke.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_okeMouseClicked(evt);
            }
        });
        bg.add(btn_oke, new org.netbeans.lib.awtextra.AbsoluteConstraints(837, 121, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(245, 172, 44));
        jLabel9.setText("Tanggal Sewa");
        bg.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(588, 256, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(245, 172, 44));
        jLabel10.setText("Tanggal Pengembalian");
        bg.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(727, 256, -1, -1));

        txt_tglSewa.setBackground(new java.awt.Color(255, 255, 255));
        txt_tglSewa.setForeground(new java.awt.Color(0, 0, 0));
        txt_tglSewa.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(245, 172, 44)));
        bg.add(txt_tglSewa, new org.netbeans.lib.awtextra.AbsoluteConstraints(576, 290, 120, -1));

        txt_tglKembali.setBackground(new java.awt.Color(255, 255, 255));
        txt_tglKembali.setForeground(new java.awt.Color(0, 0, 0));
        txt_tglKembali.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(245, 172, 44)));
        bg.add(txt_tglKembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 290, 140, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setText("Total Denda");
        bg.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(705, 351, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setText("Rp. ");
        bg.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(705, 391, -1, -1));

        lbl_denda.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_denda.setForeground(new java.awt.Color(102, 102, 102));
        lbl_denda.setText("-");
        bg.add(lbl_denda, new org.netbeans.lib.awtextra.AbsoluteConstraints(758, 391, -1, -1));

        btn_pengembalian.setBackground(new java.awt.Color(102, 255, 102));
        btn_pengembalian.setForeground(new java.awt.Color(255, 255, 255));
        btn_pengembalian.setText("OK");
        btn_pengembalian.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_pengembalianMouseClicked(evt);
            }
        });
        bg.add(btn_pengembalian, new org.netbeans.lib.awtextra.AbsoluteConstraints(705, 494, -1, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 102, 102));
        jLabel13.setText("Konfirmasi Pengembalian?");
        bg.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(705, 452, -1, -1));

        lbl_hidden.setForeground(new java.awt.Color(255, 51, 51));
        lbl_hidden.setText("Data Member tidak ada!");
        bg.add(lbl_hidden, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 115, -1, -1));

        btn_cancel.setBackground(new java.awt.Color(255, 0, 0));
        btn_cancel.setForeground(new java.awt.Color(255, 255, 255));
        btn_cancel.setText("CANCEL");
        btn_cancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_cancelMouseClicked(evt);
            }
        });
        bg.add(btn_cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(795, 494, -1, -1));

        jDesktopPane1.setBackground(new java.awt.Color(204, 204, 204));

        jDesktopPane1.setLayer(lbl_image, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_image, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                .addContainerGap())
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_image, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                .addContainerGap())
        );

        bg.add(jDesktopPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, 140));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_idMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idMemberActionPerformed
        String idMember = txt_idMember.getText();
        member = new Member();
        memberService = new MemberServiceImpl();
        
        member = memberService.findById(idMember);
        
        if(member != null){
            lbl_hidden.setVisible(false);
            txt_nama.setText(member.getNama());
            txt_alamat.setText(member.getAlamat());
            txt_email.setText(member.getEmail());
            txt_noTelp.setText(member.getNomorTelp());
            
            loadTabel(idMember);
            
            try {
                // Get the URL of the image
                URL imageURL = getClass().getResource("/images/"+idMember+".jpg");

                 BufferedImage originalImage = ImageIO.read(imageURL);

            // Resize the image to your desired dimensions (180x220 in this case)
            BufferedImage resizedImage = Thumbnails.of(originalImage)
                    .size(88, 128)
                    .asBufferedImage();

            // Create an ImageIcon from the resized image
            ImageIcon icon = new ImageIcon(resizedImage);

            // Set the ImageIcon to a label or wherever you want to display it
            lbl_image.setIcon(icon);

            // If you need to convert it to a byte array, you can do so
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(resizedImage, "png", baos);
            byte[] imageData = baos.toByteArray();
    
                // Now, 'imageData' contains the byte array representation of the image
            } catch (IOException e) {
                e.printStackTrace(); // Handle the exception appropriately
            }

        }else{
            lbl_hidden.setVisible(true);
            emptyField();
        }
        
    }//GEN-LAST:event_txt_idMemberActionPerformed

    private void btn_exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_exitMouseClicked
        dispose();
    }//GEN-LAST:event_btn_exitMouseClicked

    private void tbl_sewaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_sewaMouseClicked
        String idBacaan, cek;
        
        int row = tbl_sewa.getSelectedRow();
        cek = tbl_sewa.getValueAt(row, 5).toString();
        idSewa = Integer.parseInt(tbl_sewa.getValueAt(row, 7).toString());
        
        if(cek.equals("-")){
            idBacaan = tbl_sewa.getValueAt(row, 6).toString();
        } else{
            idBacaan = tbl_sewa.getValueAt(row, 5).toString();
        }
        
        txt_idBacaan.setText(idBacaan);
        txt_judul.setText("");
        txt_pengarang.setText("");
        txt_tglSewa.setText("");
        txt_tglKembali.setText("");
        lbl_denda.setText("-");
    }//GEN-LAST:event_tbl_sewaMouseClicked

    private void btn_okeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_okeMouseClicked
        String idBacaan = txt_idBacaan.getText();
        
        if(idBacaan.startsWith("B")){
            buku = new Buku();
            BukuService bukuService = new BukuServiceImpl();
            buku = bukuService.findById(idBacaan);
            
            sewa = new Sewa();
            sewaService = new SewaServiceImpl();
            sewa = sewaService.findById(idSewa);
            
            txt_judul.setText(buku.getJudul());
            txt_pengarang.setText(buku.getPengarang());
            txt_tglSewa.setText(sewa.getTglSewa());
            txt_tglKembali.setText(sewa.getTglKembali());
        }
        else if(idBacaan.startsWith("K")){
            komik = new Komik();
            KomikService komikService = new KomikServiceImpl();
            komik = komikService.findById(idBacaan);
            
            sewa = new Sewa();
            sewaService = new SewaServiceImpl();
            sewa = sewaService.findById(idSewa);
            
            txt_judul.setText(komik.getJudul());
            txt_pengarang.setText(komik.getPengarang());
            txt_tglSewa.setText(sewa.getTglSewa());
            txt_tglKembali.setText(sewa.getTglKembali());
        }
        
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String dateText = txt_tglKembali.getText();

        try {
            LocalDate dueDate = LocalDate.parse(dateText, dateFormatter);
            double totalDenda = hitungDenda(dueDate);
            lbl_denda.setText(totalDenda+"");
            // Use 'dueDate' as needed
        } catch (DateTimeParseException e) {
            // Handle the case where the input dateText is not in the expected format
            System.out.println("Invalid date format: " + e.getMessage());
        }

    }//GEN-LAST:event_btn_okeMouseClicked

    private void btn_cancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cancelMouseClicked
        emptyField();
    }//GEN-LAST:event_btn_cancelMouseClicked

    private void btn_pengembalianMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_pengembalianMouseClicked
        transaksiService = new TransaksiServiceImpl();
        sewaService = new SewaServiceImpl();
        sewa = new Sewa();
        sewa = sewaService.findById(idSewa);
        
        sewaService.delete(idSewa);
        if(txt_idBacaan.getText().startsWith("B")){
            transaksiService.updateStatusPeminjamanBuku(sewa);
        }
        else if(txt_idBacaan.getText().startsWith("K")){
            transaksiService.updateStatusPeminjamanKomik(sewa);
        }
        
        loadTabel(txt_idMember.getText());
        emptyField();
        
        MessageForm message = new MessageForm();
        message.gantiText("TRANSAKSI SELESAI", "Peminjaman selesai.", "Lanjutkan");
        message.setVisible(true);
    }//GEN-LAST:event_btn_pengembalianMouseClicked

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
            java.util.logging.Logger.getLogger(FormPengembalian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormPengembalian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormPengembalian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormPengembalian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormPengembalian().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JButton btn_cancel;
    private javax.swing.JLabel btn_exit;
    private javax.swing.JButton btn_oke;
    private javax.swing.JButton btn_pengembalian;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_denda;
    private javax.swing.JLabel lbl_hidden;
    private javax.swing.JLabel lbl_image;
    private org.itenas.uas.view.component.swing.TableDark tbl_sewa;
    private javax.swing.JTextField txt_alamat;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_idBacaan;
    private javax.swing.JTextField txt_idMember;
    private javax.swing.JTextField txt_judul;
    private javax.swing.JTextField txt_nama;
    private javax.swing.JTextField txt_noTelp;
    private javax.swing.JTextField txt_pengarang;
    private javax.swing.JTextField txt_tglKembali;
    private javax.swing.JTextField txt_tglSewa;
    // End of variables declaration//GEN-END:variables
}
