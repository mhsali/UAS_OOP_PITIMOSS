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
                buku.setHarga(rs.getDouble("harga"));
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String update(Buku object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Buku findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
