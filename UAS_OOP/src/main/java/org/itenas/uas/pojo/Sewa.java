/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itenas.uas.pojo;

import java.util.Date;

/**
 *
 * @author Kelompok 1
 */
public class Sewa {
    private Integer id;
    private String tglSewa;
    private String tglKembali;
    private double totalHarga;
    private double denda;
    private String status;
    private Buku buku;
    private Komik komik;
    private Member member;

    public Sewa() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getTglSewa() {
        return tglSewa;
    }

    public void setTglSewa(String tglSewa) {
        this.tglSewa = tglSewa;
    }

    public String getTglKembali() {
        return tglKembali;
    }

    public void setTglKembali(String tglKembali) {
        this.tglKembali = tglKembali;
    }

    public double getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(double totalHarga) {
        this.totalHarga = totalHarga;
    }

    public double getDenda() {
        return denda;
    }

    public void setDenda(double denda) {
        this.denda = denda;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Buku getBuku() {
        return buku;
    }

    public void setBuku(Buku buku) {
        this.buku = buku;
    }

    public Komik getKomik() {
        return komik;
    }

    public void setKomik(Komik komik) {
        this.komik = komik;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
    
    public String getKomikId() {
        if (komik != null && komik.getId() != null) {
            return komik.getId();
        } else {
            return "NULL";
        }
    }
    
    public String getBukuId() {
        if (buku != null && buku.getId() != null) {
            return buku.getId();
        } else {
            return "NULL";
        }
    }
}
