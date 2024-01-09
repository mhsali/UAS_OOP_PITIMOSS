/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itenas.uas.oop.serviceimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.itenas.uas.oop.pojo.Admin;
import org.itenas.uas.oop.pojo.Akun;
import org.itenas.uas.oop.service.AdminService;
import org.itenas.uas.oop.utilities.ConnectionManager;

/**
 *
 * @author Kelompok 1
 */
public class AdminServiceImpl implements AdminService{
    private ConnectionManager conMan;
    private Connection conn;
    Statement stmt;
    ResultSet rs;
   
    @Override
    public Admin login(String username, String password) {
        Admin admin = null;
        Akun akun = null;
        String sql = "SELECT a.id_admin, a.nama_depan, a.nama_belakang, "
                + "ak.id_akun, ak.email, ak.username, ak.role "
                + "FROM admin a, akun ak "
                + "WHERE a.id_akun = ak.id_akun "
                + "AND ak.username = '"+username+"' "
                + "AND ak.password = '"+password+"'";
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                admin = new Admin();
                admin.setId(rs.getString("id_admin"));
                admin.setNamaDepan(rs.getString("nama_depan"));
                admin.setNamaBelakang(rs.getString("nama_belakang"));
                akun = new Akun();
                akun.setId(rs.getInt("id_akun"));
                akun.setEmail(rs.getString("email"));
                akun.setUsername(rs.getString("username"));
                akun.setRole(rs.getString("role"));
                admin.setAkun(akun);
            }
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(AdminServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return admin;
    }

    @Override
    public boolean cekData(String id) {
        Admin admin = null;
        String sql = "SELECT id_admin, nama_depan FROM admin "
                + "WHERE id_admin = '" +id+ "';";
        boolean flag = false;
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                admin = new Admin();
                admin.setId(rs.getString("id_member"));
                admin.setNamaDepan(rs.getString("nama_depan"));;
                flag = true;
            }
            conMan.disconnect();
        } catch (SQLException ex) {
            System.out.println("Salah Query di cekData admin!");
        }
        return flag;
    }

    @Override
    public boolean cekUsername(String username) {
        Akun akun = null;
        String sql = "SELECT id_akun, username FROM akun "
                + "WHERE username = '" +username+ "';";
        boolean flag = false;
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                akun = new Akun();
                akun.setId(rs.getInt("id_akun"));
                akun.setUsername(rs.getString("username"));;
                flag = true;
            }
            conMan.disconnect();
        } catch (SQLException ex) {
            System.out.println("Salah Query di adminService");
        }
        return flag;
    }

    @Override
    public Integer register(Admin object) {
        int result = 0;

        try {
            
            conMan = new ConnectionManager();
            conn = conMan.connect();
        
            String sql = "INSERT INTO akun (email, username, password, role) "
                    + "VALUES ('" + object.getAkun().getEmail() + "', "
                    + "'" + object.getAkun().getUsername() + "', "
                    + "'" + object.getAkun().getPassword() + "', "
                    + "'Admin');";

            stmt = conn.createStatement();
            stmt.executeUpdate(sql);

        } catch (SQLException ex) {
            Logger.getLogger(AdminServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
        } finally {
            conMan.disconnect();
        }

        return result;
    }
    
}
