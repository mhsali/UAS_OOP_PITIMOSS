/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itenas.uas.oop.view;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Kelompok 1
 */
public class LandingPageView {
    public static void main(String[] args) {
        landingPage();
    }
    public static void landingPage(){
        int menu = 0;
        boolean keluar = false;
        char pilihan;
        Scanner scanner;

        do {
            System.out.println("+--------------------------------------");
            System.out.println("\t|PITIMOSS|");
            System.out.println("+--------------------------------------");
            System.out.println("Selamat datang, silakan melakukan login terlebih dahulu");
            System.out.println("[1] Register");
            System.out.println("[2] Login");
            System.out.println("[3] Exit");
            System.out.println("---------------------------------------");
            System.out.println("");
            System.out.println("Masukkan pilihan menu: ");
            scanner = new Scanner(System.in);
            
            try {
                menu = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Pilihan harus dalam Angka: " +e);
            }
            
            switch (menu) {
                case 1:
                    RegisterView.register();
                break;
                case 2:
                    LoginView.login();
                break;
                case 3:
                    System.out.println("Keluar aplikasi...!");
                    System.exit(0);
                break;
                default:
                    System.out.println("Pilihan yang Anda masukkan salah!");
                break;
            }
            System.out.println("");
            System.out.println("Apakah ingin melanjutkan? [y/n]: ");
            scanner = new Scanner(System.in);
            pilihan = scanner.next().charAt(0);
            if (pilihan == 'n' || pilihan == 'N') {
                keluar = true;
            }
            
        } while (!keluar);
        System.out.println("Terima kasih sudah menggunakan aplikasi.");
        System.exit(0);
    }
    
}
