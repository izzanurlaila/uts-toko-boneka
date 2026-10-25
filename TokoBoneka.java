/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author HP
 */

package tokobonekabaru;

import java.util.ArrayList;

public class TokoBoneka {

    // PBO: Menyimpan daftar objek boneka
    private ArrayList<Boneka> daftarBoneka = new ArrayList<>();

    // PBO: Constructor untuk membuat 10 produk boneka
    public TokoBoneka() {
        daftarBoneka.add(new Boneka("Teddy Bear", 75000, 10));
        daftarBoneka.add(new Boneka("Kelinci", 50000, 8));
        daftarBoneka.add(new Boneka("Jerapah", 65000, 12));
        daftarBoneka.add(new Boneka("Hello Kitty", 85000, 7));
        daftarBoneka.add(new Boneka("Doraemon", 60000, 10));
        daftarBoneka.add(new Boneka("Stitch", 90000, 5));
        daftarBoneka.add(new Boneka("Kuromi", 70000, 9));
        daftarBoneka.add(new Boneka("Keropi", 75000, 6));
        daftarBoneka.add(new Boneka("Panda", 55000, 11));
        daftarBoneka.add(new Boneka("Kucing", 45000, 15));
    }

    // PBO: Memilih boneka berdasarkan nomor menu
    public Boneka pilihBoneka(int pilihan) {
        if (pilihan >= 1 && pilihan <= daftarBoneka.size()) {
            return daftarBoneka.get(pilihan - 1);
        }
        return null;
    }

    // PBO: Menampilkan semua stok boneka
    public void tampilkanStok() {
        System.out.println("\n=== DAFTAR STOK BONEKA ===");

        for (int i = 0; i < daftarBoneka.size(); i++) {
            System.out.println("\nNomor produk: " + (i + 1));
            daftarBoneka.get(i).tampilkanInfo();
        }
    }

    // PBO: Menghitung total harga
    public int hitungTotal(Boneka boneka, int jumlah) {
        if (boneka == null) {
            return -1;
        }

        if (jumlah <= 0 || jumlah > boneka.getStok()) {
            return -1;
        }

        return boneka.getHarga() * jumlah;
    }

    // PBO: Memproses transaksi pembelian
    public boolean prosesPembelian(Boneka boneka, int jumlah, int uang) {
        int total = hitungTotal(boneka, jumlah);

        if (total == -1) {
            System.out.println("Jumlah tidak valid atau stok tidak cukup!");
            return false;
        }

        if (uang < total) {
            System.out.println("Uang pembayaran tidak cukup!");
            return false;
        }

        // PBO: Stok berkurang setelah pembayaran valid
        boneka.kurangiStok(jumlah);

        int kembalian = uang - total;

        System.out.println("\n=== STRUK PEMBELIAN ===");
        System.out.println("Nama boneka : " + boneka.getNama());
        System.out.println("Jumlah      : " + jumlah);
        System.out.println("Total harga : Rp" + total);
        System.out.println("Uang bayar  : Rp" + uang);
        System.out.println("Kembalian   : Rp" + kembalian);
        System.out.println("Sisa stok   : " + boneka.getStok());
        System.out.println("=======================");

        return true;
    }
}
