/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itenas.uas.view;

import java.util.Scanner;
import org.itenas.uas.pojo.Akun;
import org.itenas.uas.pojo.Member;
import org.itenas.uas.service.AkunService;
import org.itenas.uas.serviceimpl.AkunServiceImpl;

/**
 *
 * @author Kelompok 1
 */
public class RegisterView {
    public static void register() {
        Scanner s = new Scanner(System.in);
        AkunService akunService = new AkunServiceImpl();
        Member member = null;
        Akun akun;
        String username, password, id_member, email;
        boolean login = false;

        do {
            System.out.println("+-------------------------------------------+");
            System.out.println("|REGISTER                                |");
            System.out.println("+-------------------------------------------+");
            System.out.println("Masukkan ID: ");
            id_member = s.nextLine();
            System.out.println("| Username: ");
            username = s.nextLine();
            System.out.println("| Password: ");
            password = s.nextLine();
            System.out.println("Email: ");
            email = s.nextLine();
            System.out.println("+-------------------------------------------+");
            System.out.println();
            
            akun = new Akun();
            akun.setUsername(username);
            akun.setPassword(password);
            akun.setEmail(email);
            member = new Member();
            member.setId(id_member);
            member.setAkun(akun);
            
            int p;
            p = akunService.register(member);
            
            if (p != 1) {
                login = true;
                System.out.println("Register Berhasil!");
            } else {
                System.out.println("Data tidak ada");
            }
        } while (!login);
    }
}
