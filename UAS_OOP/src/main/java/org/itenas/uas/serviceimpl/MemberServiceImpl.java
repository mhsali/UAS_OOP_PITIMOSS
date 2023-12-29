/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itenas.uas.serviceimpl;

import org.itenas.uas.pojo.Akun;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.itenas.uas.pojo.Member;
import org.itenas.uas.service.MemberService;
import org.itenas.uas.utilities.ConnectionManager;

/**
 *
 * @author Billhafidz
 */
public class MemberServiceImpl implements MemberService{
    private ConnectionManager conMan;
    private Connection conn;
    Statement stmt;
    ResultSet rs;

    public Member login(String username, String password) {
        Member member = null;
        Akun akun = null;
        String sql = "SELECT m.id_member, m.nama_member, m.alamat, m.email, m.nomor_telepon, "
                + "ak.id_akun, ak.email, ak.username, ak.role "
                + "FROM member m, akun ak "
                + "WHERE m.id_akun = m.id_akun "
                + "AND ak.username = '"+username+"' "
                + "AND ak.password = '"+password+"'";
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                member = new Member();
                member.setId(rs.getString("id_member"));
                member.setNama(rs.getString("nama_member"));
                member.setAlamat(rs.getString("alamat"));
                member.setEmail(rs.getString("email"));
                member.setNomorTelp(rs.getString("nomor_telepon"));
                akun = new Akun();
                akun.setId(rs.getInt("id_akun"));
                akun.setEmail(rs.getString("email"));
                akun.setUsername(rs.getString("username"));
                akun.setRole(rs.getString("role"));
                member.setAkun(akun);
            }
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(MemberServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return member;
    }
    
    @Override
    public List<Member> findAll() {
        List<Member> listMember = new ArrayList<>();
        String sql = "SELECT * FROM member";
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            
            while (rs.next()) {                
                Member member = new Member();
                member.setId(rs.getString("id_member"));
                member.setNama(rs.getString("nama_member"));
                member.setAlamat(rs.getString("alamat"));
                member.setEmail(rs.getString("email"));
                member.setNomorTelp(rs.getString("nomor_telepon"));
                Akun akun = new Akun();
                akun.setId(rs.getInt("id_akun"));
                akun.setEmail(rs.getString("email"));
                akun.setUsername(rs.getString("username"));
                akun.setRole(rs.getString("role"));
                member.setAkun(akun);
                
                listMember.add(member);
            }
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(MemberServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        
        return listMember;
    }

    @Override
    public String create(Member object) {
        String result = "";
        String sql = "INSERT INTO member "
                + "VALUES('"+object.getId()+"', "
                + ""+object.getNama()+", "
                + "'"+object.getAlamat()+"', "
                + "'"+object.getEmail()+"', "
                + "'"+object.getNomorTelp()+"', "
                + "'"+object.getAkun().getEmail()+"'"
                + "'"+object.getAkun().getUsername()+"'"
                + "'"+object.getAkun().getPassword()+"'"
                + "'"+object.getAkun().getRole()+"'"
                + "')";
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(MemberServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return result;
    }

        @Override
    public String update(Member object) {
        String result = "";
        String sql = "UPDATE member SET id_member='"+object.getId()+"', "
                + "nama_member="+object.getNama()+", "
                + "alamat='"+object.getAlamat()+"', "
                + "email='"+object.getEmail()+"', "
                + "username='"+object.getAkun().getUsername()+"', "
                + "password='"+object.getAkun().getPassword()+"' "
                + "role='"+object.getAkun().getRole()+"' "
                + "WHERE id_member="+object.getId()+"";
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(MemberServiceImpl.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public Member findById(String id) {
        Member member = null;
        Akun akun = null;
        String sql = "SELECT * FROM member WHERE id_member="+id+"";
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                member = new Member();
                member.setId(rs.getString("id_member"));
                member.setNama(rs.getString("nama_member"));
                member.setAlamat(rs.getString("alamat"));
                member.setEmail(rs.getString("email"));
                member.setNomorTelp(rs.getString("nomor_telepon"));
                akun = new Akun();
                akun.setId(rs.getInt("id_akun"));
                akun.setEmail(rs.getString("email"));
                akun.setUsername(rs.getString("username"));
                akun.setRole(rs.getString("role"));
                member.setAkun(akun);
            }
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(MemberServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return member;
    }

    @Override
    public String delete(String id) {
        String result = "";
        String sql = "DELETE FROM member WHERE id_member="+id+"";
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(MemberServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
}
