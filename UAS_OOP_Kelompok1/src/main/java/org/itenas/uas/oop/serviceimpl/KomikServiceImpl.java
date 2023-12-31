/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itenas.uas.oop.serviceimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.itenas.uas.oop.pojo.Buku;
import org.itenas.uas.oop.pojo.Komik;
import org.itenas.uas.oop.utilities.ConnectionManager;
import org.itenas.uas.oop.service.KomikService;

/**
 *
 * @author BillHafidz
 */
public class KomikServiceImpl implements KomikService {
private ConnectionManager conMan;
    private Connection conn;
    Statement stmt;
    ResultSet rs;
    
    @Override
    public List<Komik> findAll() {
        List<Komik> listKomik = new ArrayList<>();
        String sql = "SELECT * FROM komik";
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            
            while (rs.next()) {                
                Komik komik = new Komik();
                komik.setId(rs.getString("id_komik"));
                komik.setJudul(rs.getString("judul_komik"));
                komik.setPengarang(rs.getString("pengarang"));
                komik.setPenerbit(rs.getString("penerbit"));
                komik.setTahunTerbit(rs.getString("tahun_terbit"));
                komik.setHarga(rs.getDouble("harga_komik"));
                komik.setStatus(rs.getString("status"));
                komik.setVolume(rs.getString("volume"));
                
                listKomik.add(komik);
            }
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(KomikServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        
        return listKomik;
    }

    @Override
    public String create(Komik object) {
        String result = "";
        String sql = "INSERT INTO komik (ID_Komik, judul_komik, pengarang, penerbit, tahun_terbit, harga_komik, status, volume) VALUES ('"
                + object.getId() + "', '"
                + object.getJudul() + "', '" 
                + object.getPengarang() + "', '" 
                + object.getPenerbit() + "', '"
                + object.getTahunTerbit() + "', " 
                + object.getHarga() + ", '"
                + object.getStatus()+ "', '"
                + object.getVolume()+ "')";
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(KomikServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public String update(Komik object) {
        String result = "";
        String sql = "UPDATE komik SET id_komik = '"+object.getId()+"', "
                + "judul_komik = '"+object.getJudul()+"', "
                + "pengarang = '"+object.getPengarang()+"', "
                + "penerbit = '"+object.getPenerbit()+"', "
                + "tahun_terbit = '"+object.getTahunTerbit()+"', "
                + "harga_komik = "+object.getHarga() + ", "
                + "status = '"+object.getStatus()+"', "
                + "volume = '"+object.getVolume()+"' "
                + "WHERE id_komik = '"+object.getId()+"';";
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(KomikServiceImpl.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public Komik findById(String id) {
        Komik komik = null;
        String sql = "SELECT * FROM komik WHERE id_komik = '"+id+"';";
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                komik = new Komik();
                komik.setId(rs.getString("id_komik"));
                komik.setJudul(rs.getString("judul_komik"));
                komik.setPengarang(rs.getString("pengarang"));
                komik.setPenerbit(rs.getString("penerbit"));
                komik.setTahunTerbit(rs.getString("tahun_terbit"));
                komik.setHarga(rs.getDouble("harga_komik"));
                komik.setStatus(rs.getString("status"));
                komik.setVolume(rs.getString("volume"));
            }
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(KomikServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return komik;
    }

    @Override
    public String delete(String id) {
        String result = "";
        String sql = "DELETE FROM komik WHERE id_komik = '"+id+"'";
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(KomikServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public List<Komik> findBacaanByJudul(String judul) {
        List<Komik> listKomik = new ArrayList<>();
        Komik komik = null;
        String sql = "SELECT * FROM KOMIK komik WHERE judul_komik LIKE '%" + judul + "%'";
        
        
   conMan = new ConnectionManager();
    conn = conMan.connect();
    Statement stmt = null;

    
    try
    {
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            komik = new Komik();
                komik.setId(rs.getString("id_komik"));
                komik.setJudul(rs.getString("judul_komik"));
                komik.setPengarang(rs.getString("pengarang"));
                komik.setPenerbit(rs.getString("penerbit"));
                komik.setTahunTerbit(rs.getString("tahun_terbit"));
                komik.setHarga(rs.getDouble("harga_komik"));
                komik.setStatus(rs.getString("status"));
                komik.setVolume(rs.getString("volume"));

                listKomik.add(komik);
        }
    } catch (SQLException ex) {
        Logger.getLogger(BukuServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        conMan.disconnect();
    }

    return listKomik;    
        }

    @Override
    public List<Komik> findBacaanByPengarang(String pengarang) {
    List<Komik> listKomik = new ArrayList<>();
    Komik komik = null;
    String sql = "SELECT * FROM KOMIK komik WHERE pengarang LIKE '%" + pengarang + "%'";
        
        
   conMan = new ConnectionManager();
    conn = conMan.connect();
    Statement stmt = null;

    
    try
    {
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            komik = new Komik();
                komik.setId(rs.getString("id_komik"));
                komik.setJudul(rs.getString("judul_komik"));
                komik.setPengarang(rs.getString("pengarang"));
                komik.setPenerbit(rs.getString("penerbit"));
                komik.setTahunTerbit(rs.getString("tahun_terbit"));
                komik.setHarga(rs.getDouble("harga_komik"));
                komik.setStatus(rs.getString("status"));
                komik.setVolume(rs.getString("volume"));

                listKomik.add(komik);
        }
    } catch (SQLException ex) {
        Logger.getLogger(BukuServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        conMan.disconnect();
    }

    return listKomik;       
    }

    @Override
    public List<Komik> findBacaanByPenerbit(String penerbit) {
    List<Komik> listKomik = new ArrayList<>();
    Komik komik = null;
    String sql = "SELECT * FROM KOMIK komik WHERE penerbit LIKE '%" + penerbit + "%'";
        
        
   conMan = new ConnectionManager();
    conn = conMan.connect();
    Statement stmt = null;

    
    try
    {
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            komik = new Komik();
                komik.setId(rs.getString("id_komik"));
                komik.setJudul(rs.getString("judul_komik"));
                komik.setPengarang(rs.getString("pengarang"));
                komik.setPenerbit(rs.getString("penerbit"));
                komik.setTahunTerbit(rs.getString("tahun_terbit"));
                komik.setHarga(rs.getDouble("harga_komik"));
                komik.setStatus(rs.getString("status"));
                komik.setVolume(rs.getString("volume"));

                listKomik.add(komik);
        }
    } catch (SQLException ex) {
        Logger.getLogger(BukuServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        conMan.disconnect();
    }

    return listKomik;       
        }
}