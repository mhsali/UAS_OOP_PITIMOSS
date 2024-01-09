package org.itenas.uas.oop.view;

import org.itenas.uas.oop.pojo.Komik;
import org.itenas.uas.oop.service.BukuService;
import org.itenas.uas.oop.serviceimpl.BukuServiceImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.itenas.uas.oop.pojo.Buku;


public class ManageBukuViewDemo {
    static List<Buku> list = new ArrayList<>();
    static BukuService bukuService;
    static Scanner scanner;
    private static List<Buku> listBuku;
    private static Buku buku;
    private static Object updatedKomik;
    
    public static void main(String[] args) {
        viewManageDokter();
    }
    
    public static void viewManageDokter() {
        int menu = 0;
        boolean keluar = false;
        char pilihan;
        Scanner scanner;

        do {
            System.out.println("+--------------------------------------");
            System.out.println("|ADMIN DASHBOARD | BUKU MANAGEMENT");
            System.out.println("+--------------------------------------");
            System.out.println("1. Insert Buku");
            System.out.println("2. Update Buku");
            System.out.println("3. Delete Buku");
            System.out.println("4. Display All Buku");
            System.out.println("5. Find Buku by ID");
            System.out.println("+--------------------------------------");
            System.out.println("");
            System.out.println("Masukkan pilihan menu: ");
            scanner = new Scanner(System.in);
            menu = scanner.nextInt();
            switch (menu) {
                case 1:
                    char tampil;
                    buku = new Buku();
                    insertBuku(buku); 
                    System.out.println("Apakah ingin menampilkan data? y/Y: ");
                    tampil = scanner.next().charAt(0);
                    if (tampil == 'y' || tampil == 'Y') {
                        bukuService = new BukuServiceImpl();
                        listBuku = bukuService.findAll();
                        findAllBuku(listBuku);
                    }
                break;
                case 2:
                    String updatedId;
                    Buku updatedBuku = new Buku();
                    scanner.nextLine();
                    System.out.println("Masukkan ID: ");
                    updatedId = scanner.nextLine();
                    updatedBuku = findBuku(updatedId);
                    System.out.println("Data Buku yang akan diupdate: ");
                    if (updatedBuku != null) {
                        System.out.println("ID Buku: " + updatedBuku.getId());
                        System.out.println("Judul Buku: " + updatedBuku.getJudul());
                        System.out.println("Pengarang: " + updatedBuku.getPengarang());
                        System.out.println("Penerbit: " + updatedBuku.getPenerbit());
                        System.out.println("Tahun Terbit: " + updatedBuku.getTahunTerbit());
                        System.out.println("Harga Buku: " + updatedBuku.getHarga());
                        System.out.println("Status: " + updatedBuku.getStatus());
                    } else {
                        System.out.println("Data tidak ditemukan!");
                    }
                    System.out.println("");
                    System.out.println("Masukkan data baru: ");
                    editBuku(updatedBuku);
                break;
                case 3:
                    String deletedId;
                    Buku deletedBuku = new Buku();
                    scanner.nextLine();
                    char confirmation;
                    bukuService = new BukuServiceImpl();
                    
                    System.out.println("Masukkan ID Buku: ");
                    deletedId = scanner.nextLine();
                    deletedBuku = findBuku(deletedId);
                    System.out.println("Apakah Anda yakin untuk menghapus? y/n: ");
                    confirmation = scanner.next().charAt(0);
                    
                    if (confirmation == 'y' || confirmation == 'Y') {
                        if (deletedBuku != null) {
                            bukuService.delete(deletedId);
                            System.out.println("Data berhasil dihapus...!");
                            System.out.println("");
                        } else {
                            System.out.println("Data tidak ditemukan!");
                        }
                    }
                break;
                case 4:
                    bukuService = new BukuServiceImpl();
                    listBuku = bukuService.findAll();
                    findAllBuku(listBuku);
                break;
                case 5:
                    bukuService = new BukuServiceImpl();
                    String searchedJudul;
                    Buku searchedBuku = new Buku();
                    scanner.nextLine();
                    System.out.println("Masukkan Judul Buku: ");
                    searchedJudul = scanner.nextLine();
                    listBuku = bukuService.findBacaanByJudul(searchedJudul);

                    if (!listBuku.isEmpty()) {
                    findAllBuku(listBuku);
    } else {
        System.out.println("Data tidak ditemukan!");
    }
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

    private static void findAllBuku(List<Buku> listBuku) {
        for (Buku buku : listBuku) {
            System.out.println("-----------------------------------------------------------------");
            System.out.println("ID Buku\t: " + buku.getId());
            System.out.println("Judul Buku\t: " + buku.getJudul());
            System.out.println("Pengarang\t: " + buku.getPengarang());
            System.out.println("Penerbit\t: " + buku.getPenerbit());
            System.out.println("Tahun Terbit\t: " + buku.getTahunTerbit());
            System.out.println("Harga Buku\t: " + buku.getHarga());
            System.out.println("Status\t\t: " + buku.getStatus());
            System.out.println("-----------------------------------------------------------------");
            System.out.println("");
        }
    }

    private static void insertBuku(Buku buku) {
        scanner = new Scanner(System.in);
        bukuService = new BukuServiceImpl();
        String id, judul, pengarang, penerbit, tahunTerbit, status;
        double harga;
        
        System.out.println("ID Buku: ");
        id = scanner.nextLine();
        System.out.println("Judul Buku: ");
        judul = scanner.nextLine();
        System.out.println("Pengarang: ");
        pengarang = scanner.nextLine();
        System.out.println("Penerbit: ");
        penerbit = scanner.nextLine();
        System.out.println("Tahun Terbit: ");
        tahunTerbit = scanner.nextLine();
        System.out.println("Harga Buku: ");
        harga = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Status: ");
        status = scanner.nextLine();
        
        
        buku.setId(id);
        buku.setJudul(judul);
        buku.setPengarang(pengarang);
        buku.setPenerbit(penerbit);
        buku.setTahunTerbit(tahunTerbit);
        buku.setHarga(harga);
        buku.setStatus(status);
        
        
        bukuService.create(buku);
        System.out.println("Data berhasil disimpan...!");
        System.out.println("");
    }

    private static Buku findBuku(String updatedId) {
        buku = new Buku();
        bukuService = new BukuServiceImpl();
        buku = bukuService.findById(updatedId);
    
        return buku;
    }

     private static void editBuku(Buku buku) {
        scanner = new Scanner(System.in);
        bukuService = new BukuServiceImpl();
        buku = new Buku();
        String id, judul, pengarang, penerbit, tahunTerbit, status;
        double harga;
        
        System.out.println("ID Buku: ");
        id = scanner.nextLine();
        System.out.println("Judul Buku: ");
        judul = scanner.nextLine();
        System.out.println("Pengarang: ");
        pengarang = scanner.nextLine();
        System.out.println("Penerbit: ");
        penerbit = scanner.nextLine();
        System.out.println("Tahun Terbit: ");
        tahunTerbit = scanner.nextLine();
        System.out.println("Harga Buku: ");
        harga = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Status: ");
        status = scanner.nextLine();
        
        buku.setId(id);
        buku.setJudul(judul);
        buku.setPengarang(pengarang);
        buku.setPenerbit(penerbit);
        buku.setTahunTerbit(tahunTerbit);
        buku.setHarga(harga);
        buku.setStatus(status);
        
        bukuService.update(buku);
        System.out.println("Data berhasil diperbarui...!");
        System.out.println("");
    }

}