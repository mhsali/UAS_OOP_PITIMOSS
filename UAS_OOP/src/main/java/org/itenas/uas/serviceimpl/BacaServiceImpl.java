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
import org.itenas.uas.pojo.Baca;
import org.itenas.uas.pojo.Buku;
import org.itenas.uas.pojo.Komik;
import org.itenas.uas.pojo.Member;
import org.itenas.uas.pojo.Sewa;
import org.itenas.uas.service.BacaService;
import org.itenas.uas.utilities.ConnectionManager;


public class BacaServiceImpl implements BacaService {
    private ConnectionManager conMan;
    private Connection conn;
    Statement stmt;
    ResultSet rs;

    @Override
    public List<Baca> findAll() {
        List<Baca> listBaca = new ArrayList<>();
        String sql = "SELECT * FROM baca";
        String handle, handle2;
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            
            while (rs.next()) {                
                Baca baca = new Baca();
                baca.setId(rs.getInt("id_baca"));
                baca.setTglTransaksi(rs.getString("tgl_transaksi"));
                baca.setTotalHarga(rs.getDouble("total_harga"));
                
                Buku buku = new Buku();
                handle = rs.getString("id_buku");
                buku.setId(handle != null ? handle : "-");
                baca.setBuku(buku);
                
                Komik komik = new Komik();
                handle2 = rs.getString("id_komik");
                komik.setId(handle2 != null ? handle2 : "-");
                baca.setKomik(komik);
                
                listBaca.add(baca);
            }
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(BacaServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        
        return listBaca;
    }

    @Override
    public Integer create(Baca object) {
    int result = 0;
    String sql = "INSERT INTO baca (tgl_transaksi, total_harga, "
            + "id_buku, id_komik) "
            + "VALUES (?, ?, ?, ?)";
    
    conMan = new ConnectionManager();
    conn = conMan.connect();
    
    try {
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, object.getTglTransaksi());
        pstmt.setDouble(2, object.getTotalHarga());

        // Handle null values for Buku and Komik IDs
        if (object.getBuku() != null && object.getBuku().getId() != null) {
            pstmt.setString(3, object.getBuku().getId());
        } else {
            pstmt.setNull(3, java.sql.Types.VARCHAR);
        }

        if (object.getKomik() != null && object.getKomik().getId() != null) {
            pstmt.setString(4, object.getKomik().getId());
        } else {
            pstmt.setNull(4, java.sql.Types.VARCHAR);
        }
        
        result = pstmt.executeUpdate();

        conMan.disconnect();
    } catch (SQLException ex) {
        Logger.getLogger(BacaServiceImpl.class.getName())
                .log(Level.SEVERE, null, ex);
    }
    return result;
    }

    @Override
    public Integer update(Baca object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Baca findById(Integer id) {
        Baca baca = null;
        String handle, handle2;
        String sql = "SELECT * FROM vaca WHERE id="+id+"";
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                baca.setId(rs.getInt("id_baca"));
                baca.setTglTransaksi(rs.getString("tgl_transaksi"));
                baca.setTotalHarga(rs.getDouble("total_harga"));
                
                Buku buku = new Buku();
                handle = rs.getString("id_buku");
                buku.setId(handle != null ? handle : "-");
                baca.setBuku(buku);
                
                Komik komik = new Komik();
                handle2 = rs.getString("id_komik");
                komik.setId(handle2 != null ? handle2 : "-");
                baca.setKomik(komik);
                            }
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(BacaServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return baca;
    }

    @Override
    public Integer delete(Integer id) {
        int result = 0;
        String sql = "DELETE FROM baca WHERE id="+id+"";
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            result = stmt.executeUpdate(sql);
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(BacaServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public List<Baca> findBacaanByJudul(String judul) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
