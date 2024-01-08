/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itenas.uas.service;

import java.util.List;
import org.itenas.uas.pojo.Sewa;
import org.itenas.uas.pojo.Transaksi;

/**
 *
 * @author Win10
 */
public interface TransaksiService {
    public List<Sewa> cariPenyewaanMember(String idMember);
    public void updateStatusPeminjamanBuku(Sewa object);
    public void updateStatusPeminjamanKomik(Sewa object);
    public List<Sewa> konfirmasiTransaksi(String idMember, String tgl);
    public void buatTransaksi(Transaksi object);
}
