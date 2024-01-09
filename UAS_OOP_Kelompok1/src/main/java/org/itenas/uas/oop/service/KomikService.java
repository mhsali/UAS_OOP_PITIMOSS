/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itenas.uas.oop.service;

import java.util.List;
import org.itenas.uas.oop.pojo.Buku;
import org.itenas.uas.oop.pojo.Komik;
import org.itenas.uas.oop.repository.CrudRepository;

/**
 *
 * @author BillHafidz
 */
public interface KomikService extends CrudRepository<Komik, String> {
    List<Komik> findBacaanByPengarang(String pengarang);
    List<Komik> findBacaanByPenerbit(String penerbit);
}
