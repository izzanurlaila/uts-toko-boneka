/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author HP
 */
package tokobonekabaru;

public class Boneka {

    // PBO: Attribute untuk menyimpan data boneka
    private String nama;
    private int harga;
    private int stok;

    // PBO: Constructor untuk membuat objek boneka
    public Boneka(String nama, int harga, int stok) {
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    // PBO: Method untuk menampilkan informasi boneka
    public void tampilkanInfo() {
        System.out.println("Nama  : " + nama);
        System.out.println("Harga : Rp" + harga);
        System.out.println("Stok  : " + stok);
    }

    // PBO: Getter untuk mengambil data
    public String getNama() {
        return nama;
    }

    public int getHarga() {
        return harga;
    }

    public int getStok() {
        return stok;
    }

    // PBO: Method untuk mengurangi stok
    public void kurangiStok(int jumlah) {
        if (jumlah > 0 && jumlah <= stok) {
            stok = stok - jumlah;
        }
    }
}
