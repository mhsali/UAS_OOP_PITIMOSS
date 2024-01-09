/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itenas.uas.oop.serviceimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.itenas.uas.oop.pojo.Akun;
import org.itenas.uas.oop.service.LoginService;
import org.itenas.uas.oop.utilities.ConnectionManager;

/**
 *
 * @author Kelompok 1
 */
public class LoginServiceImpl implements LoginService{
    private ConnectionManager conMan;
    private Connection conn;
    Statement stmt;
    ResultSet rs;

    @Override
    public String pilihData(String usnm, String pass) {
        String result = "";
        Akun akun = null;
        String sql = "SELECT id_akun, email, "
                + "username, password, role FROM akun WHERE "
                + "username = '"+usnm+"' "
                + "AND password = '"+pass+"';";
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                akun = new Akun();
                akun.setId(rs.getInt("id_akun"));
                akun.setUsername(rs.getString("username"));
                akun.setPassword(rs.getString("password"));
                akun.setRole(rs.getString("role"));
                result = akun.getRole();
            }
            conMan.disconnect();
        } catch (SQLException ex) {
            System.out.println("Salah di pilih data!");
            //Logger.getLogger(DokterServiceImpl.class.getName())
                    //.log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
}
