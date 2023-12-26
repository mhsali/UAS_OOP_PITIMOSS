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
import org.itenas.uas.pojo.Member;
import org.itenas.uas.service.MemberService;
import org.itenas.uas.utilities.ConnectionManager;

/**
 *
 * @author Win10
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
        String result = "";
        String sql = "INSERT INTO member "
                + "VALUES('"+object.getId()+"', "
                + ""+object.getNama()+", "
                + "'"+object.getAlamat()+"', "
                + "'"+object.getEmail()+"', "
                + "'"+object.getNomorTelp()+"'"
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Member findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
