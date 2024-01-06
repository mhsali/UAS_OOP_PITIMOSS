/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itenas.uas.serviceimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.itenas.uas.pojo.Buku;
import org.itenas.uas.service.BukuService;
import org.itenas.uas.utilities.ConnectionManager;

/**
 *
 * @author Kelompok 1
 */
public class BukuServiceImpl implements BukuService{
    private ConnectionManager conMan;
    private Connection conn;
    Statement stmt;
    ResultSet rs;

    @Override
    public List<Buku> findAll() {
        List<Buku> listBuku = new ArrayList<>();
        String sql = "SELECT * FROM buku";
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            
            while (rs.next()) {                
                Buku buku = new Buku();
                buku.setId(rs.getString("id_buku"));
                buku.setJudul(rs.getString("judul_buku"));
                buku.setPengarang(rs.getString("pengarang"));
                buku.setPenerbit(rs.getString("penerbit"));
                buku.setTahunTerbit(rs.getString("tahun_terbit"));
                buku.setHarga(rs.getDouble("harga_buku"));
                buku.setStatus(rs.getString("status"));
                
                listBuku.add(buku);
            }
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(BukuServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        
        return listBuku;
    }

    @Override
    public String create(Buku object) {
    conMan = new ConnectionManager();
    conn = conMan.connect();
    String result = "GAGAL untuk menambah buku!!...";

    try {
        String sql = "INSERT INTO buku (ID_Buku, judul_buku, pengarang, penerbit, tahun_terbit, harga_buku, status) VALUES ('"
                + object.getId() + "', '"
                + object.getJudul() + "', '" 
                + object.getPengarang() + "', '" 
                + object.getPenerbit() + "', '"
                + object.getTahunTerbit() + "', " 
                + object.getHarga() + ", '" 
                + object.getStatus() + "')";

        stmt = conn.createStatement();
        int rowsAffected = stmt.executeUpdate(sql);

        if (rowsAffected > 0) {
            result = "Buku Terbuat!!...";
        }
        conMan.disconnect();
    } catch (SQLException ex) {
        Logger.getLogger(BukuServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
    }

    return result;
}

    @Override
    public String update(Buku object) {
    conMan = new ConnectionManager();
    conn = conMan.connect();
    String result = "";

    try {
        String sql = "UPDATE buku SET ID_buku='" + object.getId() +"', "
            + "judul_buku='" + object.getJudul() 
            + "', pengarang='" + object.getPengarang()
            + "', penerbit='" + object.getPenerbit() 
            + "', tahun_terbit='" + object.getTahunTerbit() 
            + "', harga_buku=" + object.getHarga() 
            + ", status='" + object.getStatus() 
            + "' WHERE id_buku='" + object.getId() + "'; ";

        stmt = conn.createStatement();
        int rowsAffected = stmt.executeUpdate(sql);

        if (rowsAffected > 0) {
            result = "Buku Berhasil Di Update";
        }
        conMan.disconnect();
    } catch (SQLException ex) {
        Logger.getLogger(BukuServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
    }

    return result;
}
    @Override
    public Buku findById(String id) {
     conMan = new ConnectionManager();
    conn = conMan.connect();
    Buku buku = null;

    try {
        String sql = "SELECT * FROM buku WHERE id_buku='" + id + "'";

        stmt = conn.createStatement();
        rs = stmt.executeQuery(sql);

        if (rs.next()) {
            buku = new Buku();
            buku.setId(rs.getString("id_buku"));
            buku.setJudul(rs.getString("judul_buku"));
            buku.setPengarang(rs.getString("pengarang"));
            buku.setPenerbit(rs.getString("penerbit"));
            buku.setTahunTerbit(rs.getString("tahun_terbit"));
            buku.setHarga(rs.getDouble("harga_buku"));
            buku.setStatus(rs.getString("status"));
        }
        conMan.disconnect();
    } catch (SQLException ex) {
        Logger.getLogger(BukuServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
    }

    return buku;
}

    @Override
    public String delete(String id) {
         conMan = new ConnectionManager();
    conn = conMan.connect();
    String result = "Failed to delete book";

    try {
        String sql = "DELETE FROM buku WHERE id_buku='" + id + "'";

        stmt = conn.createStatement();
        int rowsAffected = stmt.executeUpdate(sql);

        if (rowsAffected > 0) {
            result = "Book deleted successfully";
        }
        conMan.disconnect();
    } catch (SQLException ex) {
        Logger.getLogger(BukuServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
    }

    return result;
}

    
}
