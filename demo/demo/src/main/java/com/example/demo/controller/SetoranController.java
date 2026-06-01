package com.example.demo.controller;

// Tambahan Import untuk Map dan ArrayList
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.SetoranRequestDTO;
import com.example.demo.model.setoran;
import com.example.demo.model.warga;
import com.example.demo.repository.SetoranRepository;
import com.example.demo.service.SetoranService;

@RestController
@RequestMapping("/api/setoran")
public class SetoranController {

    @Autowired
    private SetoranRepository setoranRepo;

    @Autowired
    private SetoranService setoranService;

    @GetMapping
    public List<setoran> getAllSetoran() {
        return setoranRepo.findAll();
    }

    // MENGGUNAKAN DTO + MENAMBAHKAN FITUR ACHIEVEMENT
    @PostMapping
    public ResponseEntity<Map<String, Object>> tambahSetoran(@RequestBody SetoranRequestDTO dto) {
        
        // 1. Cek Polimorfisme
        Double poinDidapat = setoranService.hitungTotalPoin(dto.getKategori(), dto.getBeratTotal());
        
        // 2. Logika Achievement (Poin >= 1000 dapat uang)
        String pesanAchievement = "Kumpulkan terus sampai 1000 poin ya!";
        double uangDidapat = 0.0;

        if (poinDidapat >= 1000) {
            int kelipatan = (int) (poinDidapat / 1000);
            uangDidapat = kelipatan * 10000.0;
            pesanAchievement = "🎉 ACHIEVEMENT UNLOCKED! Anda dapat Bonus Rp " + uangDidapat;
        }

        // Memunculkan hasil di layar Terminal / Console Spring Boot
        System.out.println("=====================================");
        System.out.println("TES POLIMORFISME BERHASIL!");
        System.out.println("Kategori Sampah : " + dto.getKategori());
        System.out.println("Berat Disetor   : " + dto.getBeratTotal() + " Kg");
        System.out.println("Total Poin      : " + poinDidapat);
        System.out.println("Status Reward   : " + pesanAchievement);
        System.out.println("=====================================");

        // 3. Simpan ke Database
        setoran dataBaru = new setoran();
        dataBaru.setKategori(dto.getKategori());
        dataBaru.setBeratTotal(dto.getBeratTotal());

        warga dataWarga = new warga();
        dataWarga.setNamaWarga(dto.getNamaWarga());
        dataWarga.setAlamat("-"); 

        dataBaru.setWarga(dataWarga);
        setoran dataTersimpan = setoranRepo.save(dataBaru);

        // 4. Bungkus data untuk dikirim ke Frontend HTML
        Map<String, Object> hasilResponse = new HashMap<>();
        hasilResponse.put("data", dataTersimpan);
        hasilResponse.put("poin", poinDidapat);
        hasilResponse.put("pesan", pesanAchievement);
        
        // --- PERBAIKAN DI SINI ---
        // Kita masukkan uangDidapat ke dalam response agar tidak "undefined" lagi di website
        hasilResponse.put("uangDidapat", uangDidapat); 

        return ResponseEntity.ok(hasilResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> hapusSetoran(@PathVariable Long id) {
        try {
            setoranRepo.deleteById(id); 
            return ResponseEntity.ok("Data berhasil dihapus");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Gagal menghapus data: " + e.getMessage());
        }
    }

    // ==========================================
    // TAMBAHAN FITUR LEADERBOARD / PERINGKAT WARGA
    // ==========================================
    @GetMapping("/leaderboard")
    public ResponseEntity<List<Map<String, Object>>> getLeaderboard() {
        List<setoran> semuaSetoran = setoranRepo.findAll();
        Map<String, Double> rekapPoin = new HashMap<>();

        // Hitung total poin per orang (Akumulasi)
        for (setoran s : semuaSetoran) {
            String nama = s.getWarga().getNamaWarga();
            Double poin = setoranService.hitungTotalPoin(s.getKategori(), s.getBeratTotal());
            rekapPoin.put(nama, rekapPoin.getOrDefault(nama, 0.0) + poin);
        }

        // Ubah wujudnya menjadi List agar mudah diurutkan
        List<Map<String, Object>> leaderboard = new ArrayList<>();
        for (Map.Entry<String, Double> entry : rekapPoin.entrySet()) {
            Map<String, Object> data = new HashMap<>();
            data.put("namaWarga", entry.getKey());
            data.put("totalPoin", entry.getValue());
            leaderboard.add(data);
        }

        // Urutkan dari Poin Terbesar ke Terkecil
        leaderboard.sort((a, b) -> Double.compare((Double) b.get("totalPoin"), (Double) a.get("totalPoin")));

        return ResponseEntity.ok(leaderboard);
    }
}