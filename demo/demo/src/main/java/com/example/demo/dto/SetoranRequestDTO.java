package com.example.demo.dto;

public class SetoranRequestDTO {
    private String namaWarga;
    private String kategori;
    private Double beratTotal; // Pakai beratTotal agar cocok dengan Frontend

    // Getter & Setter Nama Warga
    public String getNamaWarga() { return namaWarga; }
    public void setNamaWarga(String namaWarga) { this.namaWarga = namaWarga; }

    // Getter & Setter Kategori
    public String getKategori() { return kategori; }
    public void setKategori(String kategori) { this.kategori = kategori; }

    // Getter & Setter Berat Total (WAJIB ADA)
    public Double getBeratTotal() { return beratTotal; }
    public void setBeratTotal(Double beratTotal) { this.beratTotal = beratTotal; }
}