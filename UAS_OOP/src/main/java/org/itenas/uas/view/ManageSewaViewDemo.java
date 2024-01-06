/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itenas.uas.view;

import org.itenas.uas.serviceimpl.KomikServiceImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.itenas.uas.pojo.Sewa;
import org.itenas.uas.service.SewaService;
import org.itenas.uas.serviceimpl.SewaServiceImpl;

/**
 *
 * @author BillHafidz
 */
public class ManageSewaViewDemo {
    static List<Sewa> listSewa = new ArrayList<>();
    static Sewa sewa;
    static SewaService sewaService;
    static Scanner scanner;
    
    public static void main(String[] args) {
        viewManageSewa();
    }
    
    public static void viewManageSewa() {
        int menu = 0;
        boolean keluar = false;
        char pilihan;
        Scanner scanner;

        do {
            System.out.println("+--------------------------------------");
            System.out.println("|ADMIN DASHBOARD | SEWA MANAGEMENT");
            System.out.println("+--------------------------------------");
            System.out.println("1. Insert SEWA");
            System.out.println("2. Update SEWA");
            System.out.println("3. Delete SEWA");
            System.out.println("4. Display All SEWA");
            System.out.println("5. Find SEWA by ID");
            System.out.println("+--------------------------------------");
            System.out.println("");
            System.out.println("Masukkan pilihan menu: ");
            scanner = new Scanner(System.in);
            menu = scanner.nextInt();
            switch (menu) {
                /*case 1:
                    char tampil;
                    komik = new Komik();
                    insertKomik(komik); 
                    System.out.println("Apakah ingin menampilkan data? y/Y: ");
                    tampil = scanner.next().charAt(0);
                    if (tampil == 'y' || tampil == 'Y') {
                        komikService = new KomikServiceImpl();
                        listKomik = komikService.findAll();
                        findAllKomik(listKomik);
                    }
                break;
                case 2:
                    String updatedId;
                    Komik updatedKomik = new Komik();
                    scanner.nextLine();
                    System.out.println("Masukkan ID: ");
                    updatedId = scanner.nextLine();
                    updatedKomik = findKomik(updatedId);
                    System.out.println("Data komik yang akan diupdate: ");
                    if (updatedKomik != null) {
                        System.out.println("ID Komik: " + updatedKomik.getId());
                        System.out.println("Judul Komik: " + updatedKomik.getJudul());
                        System.out.println("Pengarang: " + updatedKomik.getPengarang());
                        System.out.println("Penerbit: " + updatedKomik.getPenerbit());
                        System.out.println("Tahun Terbit: " + updatedKomik.getTahunTerbit());
                        System.out.println("Harga Komik: " + updatedKomik.getHarga());
                        System.out.println("Status: " + updatedKomik.getStatus());
                        System.out.println("Volume: " + updatedKomik.getVolume());
                    } else {
                        System.out.println("Data tidak ditemukan!");
                    }
                    System.out.println("");
                    System.out.println("Masukkan data baru: ");
                    editKomik(updatedId);
                break;
                case 3:
                    String deletedId;
                    Komik deletedKomik = new Komik();
                    char confirmation;
                    komikService = new KomikServiceImpl();
                    scanner.nextLine();
                    
                    System.out.println("Masukkan ID Komik: ");
                    deletedId = scanner.nextLine();
                    deletedKomik = findKomik(deletedId);
                    System.out.println("Apakah Anda yakin untuk menghapus? y/n: ");
                    confirmation = scanner.next().charAt(0);
                    
                    if (confirmation == 'y' || confirmation == 'Y') {
                        if (deletedKomik != null) {
                            komikService.delete(deletedId);
                            System.out.println("Data berhasil dihapus...!");
                            System.out.println("");
                        } else {
                            System.out.println("Data tidak ditemukan!");
                        }
                    }
                break;*/
                case 4:
                    sewaService = new SewaServiceImpl();
                    listSewa = sewaService.findAll();
                    findAllKomik(listSewa);
                break;/*
                case 5:
                    String searchedId;
                    scanner.nextLine();
                    System.out.println("Masukkan ID Sewa: ");
                    searchedId = scanner.nextLine();
                    SewaServiceImpl sewaService1 = new SewaServiceImpl();
                    listSewa = sewaService1.cariPenyewaanMember(searchedId);
                    findAllKomik(listSewa);
                break;*/
                default:
                    System.out.println("Pilihan yang Anda masukkan salah!");
                break;
            }
            System.out.println("");
            System.out.println("Apakah ingin melanjutkan? y/n: ");
            scanner = new Scanner(System.in);
            pilihan = scanner.next().charAt(0);
            if (pilihan == 'n' || pilihan == 'N') {
                keluar = true;
            }
            
        } while (!keluar);
        System.out.println("Kembali ke menu utama!");
    }

    private static void findAllKomik(List<Sewa> listSewa) {
        for (Sewa sewa : listSewa) {
            System.out.println("-----------------------------------------------------------------");
            System.out.println("ID Sewa\t: " + sewa.getId());
            System.out.println("Tgl_Sewa\t: " + sewa.getTglSewa());
            System.out.println("Tgl_Kembali\t: " + sewa.getTglKembali());
            System.out.println("Total_Harga\t: " + sewa.getTotalHarga());
            System.out.println("Denda\t: " + sewa.getDenda());
            System.out.println("Status\t\t: " + sewa.getStatus());
            System.out.println("ID_Buku\t\t: " + sewa.getBuku().getId());
            System.out.println("ID_komik\t\t: " + sewa.getKomik().getId());
            System.out.println("ID_Member\t\t: " + sewa.getMember().getId());
            System.out.println("-----------------------------------------------------------------");
            System.out.println("");
        }
    }
    /*
    private static void insertKomik(Komik komik) {
        scanner = new Scanner(System.in);
        komikService = new KomikServiceImpl();
        String id, judul, pengarang, penerbit, tahunTerbit, status, volume;
        double harga;
        
        System.out.println("ID Komik: ");
        id = scanner.nextLine();
        System.out.println("Judul Komik: ");
        judul = scanner.nextLine();
        System.out.println("Pengarang: ");
        pengarang = scanner.nextLine();
        System.out.println("Penerbit: ");
        penerbit = scanner.nextLine();
        System.out.println("Tahun Terbit: ");
        tahunTerbit = scanner.nextLine();
        System.out.println("Harga Komik: ");
        harga = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Status: ");
        status = scanner.nextLine();
        System.out.println("Volume: ");
        volume = scanner.nextLine();
        
        komik.setId(id);
        komik.setJudul(judul);
        komik.setPengarang(pengarang);
        komik.setPenerbit(penerbit);
        komik.setTahunTerbit(tahunTerbit);
        komik.setHarga(harga);
        komik.setStatus(status);
        komik.setVolume(volume);
        
        komikService.create(komik);
        System.out.println("Data berhasil disimpan...!");
        System.out.println("");
    }

    private static Komik findKomik(String updatedId) {
        komik = new Komik();
        komikService = new KomikServiceImpl();
        komik = komikService.findById(updatedId);
    
        return komik;
    }

    private static void editKomik(String id) {
        scanner = new Scanner(System.in);
        komikService = new KomikServiceImpl();
        komik = new Komik();
        String judul, pengarang, penerbit, tahunTerbit, status, volume;
        double harga;
        
        System.out.println("ID Komik: ");
        id = scanner.nextLine();
        System.out.println("Judul Komik: ");
        judul = scanner.nextLine();
        System.out.println("Pengarang: ");
        pengarang = scanner.nextLine();
        System.out.println("Penerbit: ");
        penerbit = scanner.nextLine();
        System.out.println("Tahun Terbit: ");
        tahunTerbit = scanner.nextLine();
        System.out.println("Harga Komik: ");
        harga = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Status: ");
        status = scanner.nextLine();
        System.out.println("Volume: ");
        volume = scanner.nextLine();
        
        komik.setId(id);
        komik.setJudul(judul);
        komik.setPengarang(pengarang);
        komik.setPenerbit(penerbit);
        komik.setTahunTerbit(tahunTerbit);
        komik.setHarga(harga);
        komik.setStatus(status);
        komik.setVolume(volume);
        
        komikService.update(komik);
        System.out.println("Data berhasil diperbarui...!");
        System.out.println("");
    }*/
}
