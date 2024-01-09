/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itenas.uas.oop.service;

import java.util.List;
import org.itenas.uas.oop.pojo.Buku;
import org.itenas.uas.oop.repository.CrudRepository;

/**
 *
 * @author Win10
 */
public interface BukuService extends CrudRepository<Buku, String> {
    List<Buku> findBacaanByPengarang(String pengarang);
    List<Buku> findBacaanByPenerbit(String penerbit);
}
