package com.example.demo.service.impl;

import com.example.demo.service.SetoranService;
import com.example.demo.utils.*; // Import semua class dari folder utils
import org.springframework.stereotype.Service;

@Service
public class SetoranServiceImpl implements SetoranService {

    @Override
    public Double hitungTotalPoin(String kategori, Double berat) {
        // 1. Tipe data menggunakan Abstract Class (Induk)
        KalkulatorPoinBase kalkulator = null;

        // 2. Memasukkan objek Child Class sesuai kondisi (Instansiasi)
        if (kategori.equalsIgnoreCase("Organik")) {
            kalkulator = new PoinOrganik();
        } else if (kategori.equalsIgnoreCase("Anorganik")) {
            kalkulator = new PoinAnorganik();
        } else if (kategori.equalsIgnoreCase("B3")) {
            kalkulator = new PoinB3();
        }

        // 3. POLYMORPHISM TERJADI DI SINI
        if (kalkulator != null) {
            /* * Meskipun variabelnya bernama 'kalkulator' (tipe Induk), 
             * tapi rumus yang dijalankan akan berbeda-beda tergantung isi objeknya 
             * (Organik/Anorganik/B3). Kita tidak perlu if-else lagi untuk menghitungnya!
             */
            return kalkulator.hitungPoin(berat);
        }
        
        return 0.0; // Return nilai default jika kategori tidak ditemukan
    }
}