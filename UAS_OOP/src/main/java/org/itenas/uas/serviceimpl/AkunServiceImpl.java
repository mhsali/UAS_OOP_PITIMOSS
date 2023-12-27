/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itenas.uas.serviceimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.itenas.uas.pojo.Akun;
import org.itenas.uas.pojo.Member;
import org.itenas.uas.service.AkunService;
import org.itenas.uas.utilities.ConnectionManager;

/**
 *
 * @author Kelompok 1
 */
public class AkunServiceImpl implements AkunService{
    private ConnectionManager conMan;
    private Connection conn;
    Statement stmt;
    ResultSet rs;
    
    @Override
    public Member login(String username, String password) {
        Member member = null;
        Akun akun = null;
        String sql = "SELECT m.id_member, m.nama_member, a.id_akun, a.email, "
                + "a.username, a.password, a.role FROM member m, akun a "
                + "WHERE m.id_akun = a.id_akun "
                + "AND a.username = '"+username+"' "
                + "AND a.password = '"+password+"';";
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                member = new Member();
                member.setId(rs.getString("id_member"));
                member.setNama(rs.getString("nama_member"));
                akun = new Akun();
                akun.setId(rs.getInt("id_akun"));
                akun.setEmail(rs.getString("email"));
                akun.setUsername(rs.getString("username"));
                akun.setPassword(rs.getString("password"));
                akun.setRole(rs.getString("role"));
                member.setAkun(akun);
            }
            conMan.disconnect();
        } catch (SQLException ex) {
            System.out.println("Salah!");
            //Logger.getLogger(DokterServiceImpl.class.getName())
                    //.log(Level.SEVERE, null, ex);
        }
        return member;
    }

    @Override
    public Integer register(Member object) {
        int result = 0;
        boolean cek = false;

        try {
            cek = cekData(object.getId());
            if (cek != true) {
                result = 1;
                return result;
            }

            conMan = new ConnectionManager();
            conn = conMan.connect();
        
            String sql = "INSERT INTO akun (email, username, password, role) "
                    + "VALUES ('" + object.getAkun().getEmail() + "', "
                    + "'" + object.getAkun().getUsername() + "', "
                    + "'" + object.getAkun().getPassword() + "', "
                    + "'Member');";

            stmt = conn.createStatement();
            stmt.executeUpdate(sql);

        } catch (SQLException ex) {
            Logger.getLogger(AkunServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
        } finally {
            conMan.disconnect();
        }

        return result;
    }


    @Override
    public boolean cekData(String id) {
        Member member = null;
        String sql = "SELECT id_member, nama_member FROM member "
                + "WHERE id_member = '" +id+ "';";
        boolean flag = false;
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                member = new Member();
                member.setId(rs.getString("id_member"));
                member.setNama(rs.getString("nama_member"));;
                flag = true;
            }
            conMan.disconnect();
        } catch (SQLException ex) {
            System.out.println("Salah Query!");
        }
        return flag;
    }
}
