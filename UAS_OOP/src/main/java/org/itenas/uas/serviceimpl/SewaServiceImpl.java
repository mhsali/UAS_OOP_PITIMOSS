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
import org.itenas.uas.service.SewaService;
import org.itenas.uas.utilities.ConnectionManager;

/**
 *
 * @author Win10
 */
public class SewaServiceImpl implements SewaService{
    private ConnectionManager conMan;
    private Connection conn;
    Statement stmt;
    ResultSet rs;

    @Override
    public List<Sewa> findAll() {
        List<Sewa> listSewa = new ArrayList<>();
        String sql = "SELECT * FROM sewa";
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
public Integer create(Sewa object) {
    int result = 0;
    String sql = "INSERT INTO sewa(tgl_sewa, tgl_kembali, total_harga, "
            + "denda, status, id_buku, id_komik, id_member) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    
    conMan = new ConnectionManager();
    conn = conMan.connect();
    
    try {
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, object.getTglSewa());
        pstmt.setString(2, object.getTglKembali());
        pstmt.setDouble(3, object.getTotalHarga());
        pstmt.setDouble(4, object.getDenda());
        pstmt.setString(5, object.getStatus());

        // Handle null values for Buku and Komik IDs
        if (object.getBuku() != null && object.getBuku().getId() != null) {
            pstmt.setString(6, object.getBuku().getId());
        } else {
            pstmt.setNull(6, java.sql.Types.VARCHAR);
        }

        if (object.getKomik() != null && object.getKomik().getId() != null) {
            pstmt.setString(7, object.getKomik().getId());
        } else {
            pstmt.setNull(7, java.sql.Types.VARCHAR);
        }

        pstmt.setString(8, object.getMember().getId());

        result = pstmt.executeUpdate();

        conMan.disconnect();
    } catch (SQLException ex) {
        Logger.getLogger(SewaServiceImpl.class.getName())
                .log(Level.SEVERE, null, ex);
    }
    return result;
}


    @Override
    public Integer update(Sewa object) {
        int result = 0;
        String sql = "UPDATE sewa SET status = 'Dibayar'"
                + "WHERE id_member = '"+object.getMember().getId()+"'"
                + "AND tgl_sewa = '"+object.getTglSewa()+"'";
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(SewaServiceImpl.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public Sewa findById(Integer id) {
        Sewa sewa = null;
        String handle, handle2;
        String sql = "SELECT * FROM sewa WHERE id="+id+"";
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                sewa = new Sewa();
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
            }
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(SewaServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return sewa;
    }

    @Override
    public Integer delete(Integer id) {
        int result = 0;
        String sql = "DELETE FROM sewa WHERE id="+id+"";
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            result = stmt.executeUpdate(sql);
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(SewaServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public List<Sewa> findBacaanByJudul(String judul) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
