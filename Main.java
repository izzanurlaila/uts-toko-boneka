/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author HP
 */

package tokobonekabaru;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // PBO: Membuat objek toko
        TokoBoneka toko = new TokoBoneka();

        boolean berjalan = true;

        while (berjalan) {

            System.out.println("\n================================");
            System.out.println("       TOKO BONEKA LUCU");
            System.out.println("================================");
            System.out.println("1. Teddy Bear");
            System.out.println("2. Kelinci");
            System.out.println("3. Jerapah");
            System.out.println("4. Hello Kitty");
            System.out.println("5. Doraemon");
            System.out.println("6. Stitch");
            System.out.println("7. Kuromi");
            System.out.println("8. Keropi");
            System.out.println("9. Panda");
            System.out.println("10. Kucing");
            System.out.println("11. Lihat semua stok");
            System.out.println("12. Keluar");

            System.out.print("Pilih menu: ");

            // PBO: Validasi input menu
            if (!input.hasNextInt()) {
                System.out.println("Input harus berupa angka!");
                input.next();
                continue;
            }

            int pilihan = input.nextInt();

            // PBO: Memproses pilihan produk
            if (pilihan >= 1 && pilihan <= 10) {

                Boneka boneka = toko.pilihBoneka(pilihan);

                System.out.println();
                boneka.tampilkanInfo();

                System.out.print("Jumlah beli: ");

                // Validasi jumlah pembelian
                if (!input.hasNextInt()) {
                    System.out.println("Jumlah harus berupa angka!");
                    input.next();
                    continue;
                }

                int jumlah = input.nextInt();

                int total = toko.hitungTotal(boneka, jumlah);

                if (total == -1) {
                    System.out.println(
                        "Jumlah tidak valid atau stok tidak cukup!"
                    );
                    continue;
                }

                System.out.println("Total harga: Rp" + total);
                System.out.print("Uang pembayaran: Rp");

                // Validasi uang pembayaran
                if (!input.hasNextInt()) {
                    System.out.println("Uang harus berupa angka!");
                    input.next();
                    continue;
                }

                int uang = input.nextInt();

                // PBO: Memanggil method transaksi toko
                toko.prosesPembelian(boneka, jumlah, uang);

            } else if (pilihan == 11) {

                // PBO: Menampilkan stok semua produk
                toko.tampilkanStok();

            } else if (pilihan == 12) {

                berjalan = false;
                System.out.println(
                    "Terima kasih sudah berkunjung!"
                );

            } else {

                System.out.println("Pilihan tidak tersedia!");
            }
        }

        input.close();
    }
}
