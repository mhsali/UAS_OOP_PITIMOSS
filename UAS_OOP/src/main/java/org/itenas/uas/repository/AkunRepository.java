/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itenas.uas.repository;

/**
 *
 * @author Win10
 */
public interface AkunRepository<T, ID> {
    T login(String username, String password);
    ID register(T object);
    boolean cekData(String id);
}
