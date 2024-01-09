/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itenas.uas.oop.view;

import java.util.Scanner;
import org.itenas.uas.oop.pojo.Member;
import org.itenas.uas.oop.service.AkunService;
import org.itenas.uas.oop.serviceimpl.AkunServiceImpl;

/**
 *
 * @author Kelompok 1
 */
public class LoginView {
     public static void login() {
        Scanner s = new Scanner(System.in);
        AkunService akunService = new AkunServiceImpl();
        Member member;
        String username, password;
        boolean login = false;

        do {
            System.out.println("+-------------------------------------------+");
            System.out.println("|LOGIN                                |");
            System.out.println("+-------------------------------------------+");
            System.out.println("| Username: ");
            username = s.nextLine();
            System.out.println("| Password: ");
            password = s.nextLine();
            System.out.println("+-------------------------------------------+");
            System.out.println();
            member = akunService.login(username, password);
            if (member != null) {
                login = true;
                System.out.println("Login berhasil...!");
                System.out.println("");
            } else {
                System.out.println("Username atau password yang Anda masukkan salah, coba lagi...!");
            }
        } while (!login);
    }
}
