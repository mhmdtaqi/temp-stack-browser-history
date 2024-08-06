package com.github.affandes.kuliah.pm;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<String> history = new Stack<>();
        String command;

        do {
            System.out.println("\n=== Menu Browser ===");
            System.out.println("1. View History");
            System.out.println("2. Browse (Kunjungi Website Baru)");
            System.out.println("3. Back (Kembali ke Situs Sebelumnya)");
            System.out.println("4. Exit");
            System.out.print("Pilih perintah (1-4): ");
            command = scanner.nextLine();

            switch (command) {
                case "1":
                    viewHistory(history);
                    break;
                case "2":
                    browseNewWebsite(history, scanner);
                    break;
                case "3":
                    back(history);
                    break;
                case "4":
                    System.out.println("Menutup browser...");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Coba lagi.");
            }
        } while (!command.equals("4"));

        scanner.close();
    }

    // Fungsi untuk menampilkan seluruh history dari yang terbaru
    private static void viewHistory(Stack<String> history) {
        if (history.isEmpty()) {
            System.out.println("History kosong.");
        } else {
            System.out.println("=== History Browser ===");
            for (int i = history.size() - 1; i >= 0; i--) {
                System.out.println(history.get(i));
            }
        }
    }

    // Fungsi untuk menambahkan website baru ke dalam history
    private static void browseNewWebsite(Stack<String> history, Scanner scanner) {
        System.out.print("Masukkan URL website yang ingin dikunjungi: ");
        String newWebsite = scanner.nextLine();
        history.push(newWebsite);
        System.out.println("Berhasil mengunjungi: " + newWebsite);
    }

    // Fungsi untuk kembali ke website sebelumnya
    private static void back(Stack<String> history) {
        if (history.isEmpty()) {
            System.out.println("Tidak ada situs untuk kembali.");
        } else {
            String lastWebsite = history.pop();
            if (history.isEmpty()) {
                System.out.println("Anda sekarang di halaman awal. Tidak ada history lagi.");
            } else {
                System.out.println("Kembali ke situs sebelumnya: " + history.peek());
            }
        }
    }
}
