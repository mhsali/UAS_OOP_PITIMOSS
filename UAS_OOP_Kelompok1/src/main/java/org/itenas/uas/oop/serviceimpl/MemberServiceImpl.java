package org.itenas.uas.oop.serviceimpl;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.itenas.uas.oop.pojo.Akun;
import org.itenas.uas.oop.pojo.Member;
import org.itenas.uas.oop.service.MemberService;
import org.itenas.uas.oop.serviceimpl.BukuServiceImpl;
import org.itenas.uas.oop.utilities.ConnectionManager;

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
                + "nama_member = '"+object.getNama()+"', "
                + "alamat = '"+object.getAlamat()+"', "
                + "email = '"+object.getEmail()+"', "
                + "nomor_telepon = '"+object.getNomorTelp()+"' "
                + "WHERE id_member = '"+object.getId()+"'";
        
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
        Member member = null;
        Akun akun = null;
        String sql = "SELECT * FROM member WHERE id_member = '"+id+"'";
        
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

    @Override
    public List<Member> findBacaanByJudul(String judul) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}