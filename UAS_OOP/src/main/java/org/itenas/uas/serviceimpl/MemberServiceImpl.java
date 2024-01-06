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
    conMan = new ConnectionManager();
    conn = conMan.connect();
    String result = "GAGAL untuk menambah buku!!...";
    
    try {
        String sql = "INSERT INTO member (id_member, nama_member, alamat, email, nomor_telepon) VALUES ('"
                + object.getId() + "', '"
                + object.getNama()+ "', '" 
                + object.getAlamat()+ "', '" 
                + object.getEmail()+ "', '"
                + object.getNomorTelp()+ "')";
        
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
    public String update(Member object) {    
        conMan = new ConnectionManager();
        conn = conMan.connect();
        String result = "";
        
    try {
        String sql = "UPDATE member SET id_member='"+object.getId()+"', "
                + "nama_member="+object.getNama()+", "
                + "alamat='"+object.getAlamat()+"', "
                + "email='"+object.getEmail()+"', "
                + "nomor_telepon='"+object.getNomorTelp()+"' "
                + "WHERE id_member="+object.getId()+"";
        
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
    public Member findById(String id) {
    conMan = new ConnectionManager();
    conn = conMan.connect();
    Member member = null;

    try {
        String sql = "SELECT * FROM member WHERE id_member='" + id + "'";

        stmt = conn.createStatement();
        rs = stmt.executeQuery(sql);

        if (rs.next()) {
            member = new Member();
            member.setId(rs.getString("id_member"));
            member.setNama(rs.getString("nama_member"));
            member.setAlamat(rs.getString("alamat"));
            member.setEmail(rs.getString("email"));
            member.setNomorTelp(rs.getString("nomor_telepon"));
        }
        conMan.disconnect();
    } catch (SQLException ex) {
        Logger.getLogger(MemberServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
    }

    return member;
}
    
    @Override
    public String delete(String id) {
    conMan = new ConnectionManager();
    conn = conMan.connect();
    String result = "Failed to delete member";

    try {
        String sql = "DELETE FROM member WHERE id_member='" + id + "'";

        stmt = conn.createStatement();
        int rowsAffected = stmt.executeUpdate(sql);

        if (rowsAffected > 0) {
            result = "Member deleted successfully";
        }
    conMan.disconnect();
    } catch (SQLException ex) {
        Logger.getLogger(MemberServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
    }

    return result;
}
    
}
