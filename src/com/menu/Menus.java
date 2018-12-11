package com.menu;

import com.entities.Kelengkeng;
import com.impl.KelengkengImpl;
import com.interfaces.KelengkengInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Menus {
     KelengkengInt kelImpl = new KelengkengImpl();
     List<Kelengkeng> kelengkengs = new ArrayList<>();
     BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

     public void loginAdmin()throws IOException{
         System.out.println("------------------");
         System.out.print("Masukkan Username = ");
         String user = in.readLine();
         System.out.print("Masukkan Password = ");
         String pass = in.readLine();
         Kelengkeng kelengkeng = new Kelengkeng(user,pass);
         kelImpl.loginAdmin(kelengkeng);
//         if(user != kelengkeng.getUsernameDum() && pass!=kelengkeng.getPasswordDum()){
//             System.out.println("LOGIN GAGAL");
//             System.exit(0);
//         }
     }

    public void insert()throws IOException {
        System.out.print("Masukkan Jenis Kelengkeng = ");
        String jenis = in.readLine();
        System.out.print("Masukkan Harga Kelengkeng = ");
        double harga = Double.parseDouble(in.readLine());
        Kelengkeng kelengkeng = new Kelengkeng(jenis, harga);
        kelImpl.insert(kelengkeng);
    }

    public void search()throws IOException{
        System.out.print("Masukkan Jenis Kelengkeng yang dicari = ");
        String jenis1 = in.readLine();
        Kelengkeng kelengkeng1 = kelImpl.selectByName(jenis1);
        System.out.println(kelengkeng1.getId_kelengkeng()+", "+kelengkeng1.getJenis_kelengkeng()+", "+kelengkeng1.getHarga());
    }

    public void calculate() throws IOException{
        System.out.print("Jumlah Beli = ");
        int jum = Integer.parseInt(in.readLine());
        System.out.print("Masukkan Jenis Kelengkeng = ");
        String jenisS = in.readLine();
        System.out.print("Bayar = ");
        double bayar = Double.parseDouble(in.readLine());
        Kelengkeng kel = new Kelengkeng(jum,bayar,jenisS);
        kelImpl.calculate(kel);
    }
    public void update()throws IOException{
        System.out.print("Pilih no yang akan diubah = ");
        int up = Integer.parseInt(in.readLine());
        System.out.print("Masukkan Jenis yang Baru : ");
        String jenisUp = in.readLine();
        System.out.print("mauskkan Harga yang Baru : ");
        int hargaUp = Integer.parseInt(in.readLine());
        Kelengkeng kelengkengA = new Kelengkeng(jenisUp,hargaUp);
        kelImpl.update(kelengkengA, up);
    }

    public void delete()throws IOException {
        displayALL();
        System.out.print("Pilih no data yang akan dihapus : ");
        int del = Integer.parseInt(in.readLine());
        kelImpl.delete(del);
    }

    public void history(){
        //for (Kelengkeng kelengkengS : kelengkengs) {
            kelImpl.showHistory();
        //}
    }

    public void addAdmin()throws IOException{
        String user,pass;
        System.out.println("----------------------");
        System.out.print("Masukkan Username Baru = ");
        user = in.readLine();
        System.out.print("Masukkan Password Baru = ");
        pass = in.readLine();
        Kelengkeng kelengkeng = new Kelengkeng(user,pass);
        kelImpl.addAdmin(kelengkeng);
    }

    public void delAdmin()throws IOException{
        System.out.println("Masukkan id yang akan dihapus : ");
        int id = Integer.parseInt(in.readLine());
        kelImpl.delAdmin(id);
    }

    public void Menuadmin() throws IOException{
        while (true) {
            System.out.println("-----------------");
            System.out.println("1. Add Admin");
            System.out.println("2. Delete Admin");
            System.out.println("3. Kemenu Sebelumnya");
            System.out.println("Masukkan Pulihan : ");
            int input = Integer.parseInt(in.readLine());
            switch (input) {
                case 1:
                    addAdmin();
                    break;
                case 2:
                    delAdmin();
                    break;
                case 3:
                    MainMenu();
                    break;
            }
        }
    }

    public void MainMenu() throws IOException {
        while (true) {
            System.out.println(" ");
            System.out.println("----------------------------------------------");
            System.out.println("|                   Main Menu                |");
            System.out.println("----------------------------------------------");
            System.out.println("1. Penjualan");
            System.out.println("2. Utility");
            System.out.println("0. Keluar");
            System.out.print("Masukkan Pilihan :");
            int input = Integer.parseInt(in.readLine());
            switch (input) {
                case 1:
                    buy();
                    break;
                case 2:
                    util();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Out Of Range");
            }
        }
    }
            public void displayALL(){
       // for (Kelengkeng kelengkengS : kelengkengs) {
            //System.out.println(kelengkengS.getId_kelengkeng() + ", " + kelengkengS.getJenis_kelengkeng() + ", " + kelengkengS.getHarga());
            kelImpl.selectAll();
       // }

     }
    public void buy()throws IOException{
        while (true) {
            System.out.println(" ");
            System.out.println("--------------------------");
            System.out.println("1. Penjualan");
            System.out.println("2. Tampilkan History Penjualan");
            System.out.println("3. Menu Sebelumnya");
            System.out.print("Masukkan Pilihan = ");
            int input = Integer.parseInt(in.readLine());
            switch (input) {
                case 1:
                    calculate();
                    break;
                case 2:
                    history();
                    break;
                case 3:
                    MainMenu();
                    break;
            }
        }
    }
    public void util()throws IOException{
        while (true){
        System.out.println(" ");
        System.out.println("                  Utility");
        System.out.println("------------------------------------------");
        System.out.println("1. Masukkan Jenis dan Harga Kelengkeng baru");
        System.out.println("2. Cari Kelengkeng Berdasarkan Nama");
        System.out.println("3. Tampilkan Semua Kelengkeng");
        System.out.println("4. Ubah Info Kelengkeng");
        System.out.println("5. Hapus Jenis Kelengkeng");
        System.out.println("6. Admin");
        System.out.println("7. Menu Sebelumnya");
        System.out.print("Masukkan Pilihan = ");
        int input = Integer.parseInt(in.readLine());
        switch (input) {
            case 1:
                insert();
                break;
            case 2:
                search();
                break;
            case 3:
                displayALL();
                break;
            case 4:
                displayALL();
                update();
                break;
            case 5:
                displayALL();
                delete();
                break;
            case 6:
                Menuadmin();
                break;
            case 7:
                MainMenu();
                break;
            }
        }
    }
}
