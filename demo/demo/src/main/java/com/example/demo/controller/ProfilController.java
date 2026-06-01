package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/profil")
public class ProfilController {

    @GetMapping("/info")
    public Map<String, String> getProfilInfo() {
        // Membuat data JSON sementara untuk dikirim ke Frontend
        Map<String, String> dataProfil = new HashMap<>();
        
        // Silakan ubah teks di bawah ini sesuai dengan nama kelompok Anda!
        dataProfil.put("namaKelompok", "Kelompok 4 (IFB-202)");
        dataProfil.put("deskripsi", "Aplikasi GreenCycle ini dikembangkan untuk memudahkan warga dalam mencatat dan memantau riwayat setoran sampah daur ulang secara digital dan transparan.");
        
        return dataProfil;
    }
}