package com.example.demo.utils;

public abstract class KalkulatorPoinBase {
    
    protected String namaKategori;

    // Constructor
    public KalkulatorPoinBase(String namaKategori) {
        this.namaKategori = namaKategori;
    }

    // Concrete Method (Bisa langsung dipakai oleh Child Class)
    public String getInfoKalkulasi() {
        return "Mengkalkulasi poin/harga untuk kategori: " + this.namaKategori;
    }

    // ABSTRACT METHOD: Wajib di-override oleh child class sesuai rumus masing-masing
    public abstract Double hitungPoin(Double beratKg);
}