/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itenas.uas.oop.repository;

import java.util.List;

/**
 *
 * @author Kelompok 1
 */
public interface CrudRepository<T, ID> {
    List<T> findAll();
    ID create(T object);
    ID update(T object);
    T findById(ID id);
    ID delete(ID id);
    List<T> findBacaanByJudul(String judul);
}
