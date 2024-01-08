/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itenas.uas.serviceimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.itenas.uas.pojo.Buku;
import org.itenas.uas.pojo.Komik;
import org.itenas.uas.pojo.Member;
import org.itenas.uas.pojo.Sewa;
import org.itenas.uas.pojo.Transaksi;
import org.itenas.uas.service.BukuService;
import org.itenas.uas.service.KomikService;
import org.itenas.uas.utilities.ConnectionManager;
import org.itenas.uas.service.TransaksiService;

/**
 *
 * @author Kelompok 1
 */
public class TransaksiServiceImpl implements TransaksiService{
    private ConnectionManager conMan;
    private Connection conn;
    Statement stmt;
    ResultSet rs;
    Buku buku;
    Komik komik;
    BukuService bukuService;
    KomikService komikService;

    @Override
    public List<Sewa> cariPenyewaanMember(String idMember) {
        List<Sewa> listSewa = new ArrayList<>();
        String sql = "SELECT * FROM sewa WHERE id_member = '"+idMember+"'";
        String handle, handle2;
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            
            while (rs.next()) {                
                Sewa sewa = new Sewa();
                sewa.setId(rs.getInt("id_sewa"));
                sewa.setTglSewa(rs.getString("tgl_sewa"));
                sewa.setTglKembali(rs.getString("tgl_kembali"));
                sewa.setTotalHarga(rs.getDouble("total_harga"));
                sewa.setDenda(rs.getDouble("denda"));
                sewa.setStatus(rs.getString("status"));
                
                Buku buku = new Buku();
                handle = rs.getString("id_buku");
                buku.setId(handle != null ? handle : "-");
                sewa.setBuku(buku);
                
                Komik komik = new Komik();
                handle2 = rs.getString("id_komik");
                komik.setId(handle2 != null ? handle2 : "-");
                sewa.setKomik(komik);
                
                Member member = new Member();
                member.setId(rs.getString("id_member"));
                sewa.setMember(member);
                
                listSewa.add(sewa);
            }
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(SewaServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        
        return listSewa;
    }

    @Override
    public void updateStatusPeminjamanBuku(Sewa object) {
        conMan = new ConnectionManager();
        conn = conMan.connect();
        String sql = "";
        
        try{
            bukuService = new BukuServiceImpl();
            buku = bukuService.findById(object.getBukuId());
            
            if(buku.getStatus().equals("Tersedia")){
                sql = "UPDATE buku SET status = 'Tidak Tersedia' "
                        +"WHERE id_buku = '" +object.getBukuId()+"'";
            }
            else if(buku.getStatus().equals("Tidak Tersedia")){
                sql = "UPDATE buku SET status = 'Tersedia' "
                        +"WHERE id_buku = '" +object.getBukuId()+"'";
            }
            
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            
        } catch(SQLException ex){
            Logger.getLogger(TransaksiServiceImpl.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updateStatusPeminjamanKomik(Sewa object) {
        conMan = new ConnectionManager();
        conn = conMan.connect();
        String sql = "";
        
        try{
            bukuService = new BukuServiceImpl();
            buku = bukuService.findById(object.getBukuId());
            
            if(buku.getStatus().equals("Tersedia")){
                sql = "UPDATE komik SET status = 'Tidak Tersedia' "
                        +"WHERE id_buku = '" +object.getBukuId()+"'";
            }
            else if(buku.getStatus().equals("Tidak Tersedia")){
                sql = "UPDATE komik SET status = 'Tersedia' "
                        +"WHERE id_buku = '" +object.getBukuId()+"'";
            }
            
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            
        } catch(SQLException ex){
            Logger.getLogger(TransaksiServiceImpl.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Sewa> konfirmasiTransaksi(String idMember, String tgl) {
        List<Sewa> listSewa = new ArrayList<>();
        String sql = "SELECT * FROM sewa WHERE id_member = '"+idMember+"'"
                + "AND tgl_sewa = '"+tgl+"'";
        String handle, handle2;
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            
            while (rs.next()) {                
                Sewa sewa = new Sewa();
                sewa.setId(rs.getInt("id_sewa"));
                sewa.setTglSewa(rs.getString("tgl_sewa"));
                sewa.setTglKembali(rs.getString("tgl_kembali"));
                sewa.setTotalHarga(rs.getDouble("total_harga"));
                sewa.setDenda(rs.getDouble("denda"));
                sewa.setStatus(rs.getString("status"));
                
                Buku buku = new Buku();
                handle = rs.getString("id_buku");
                buku.setId(handle != null ? handle : "-");
                sewa.setBuku(buku);
                
                Komik komik = new Komik();
                handle2 = rs.getString("id_komik");
                komik.setId(handle2 != null ? handle2 : "-");
                sewa.setKomik(komik);
                
                Member member = new Member();
                member.setId(rs.getString("id_member"));
                sewa.setMember(member);
                
                listSewa.add(sewa);
            }
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(SewaServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        
        return listSewa;
    }

    @Override
    public void buatTransaksi(Transaksi object) {
    conMan = new ConnectionManager();
    conn = conMan.connect();
    String sql = "INSERT INTO transaksi (tgl_transaksi, total_harga, jumlah, id_member) "
                + "VALUES (?, ?, ?, ?)";

    try {
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, object.getTglTransaksi());
        pstmt.setDouble(2, object.getTotalHarga());
        pstmt.setInt(3, object.getJumlah());

        // Handle null values ID Member
        if (object.getMember()!= null && object.getMember().getId() != null) {
            pstmt.setString(4, object.getMember().getId());
        } else {
            pstmt.setNull(4, java.sql.Types.VARCHAR);
        }

        pstmt.executeUpdate();

    conMan.disconnect();
    } catch (SQLException ex) {
        Logger.getLogger(BukuServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
    }

    }
    
}
