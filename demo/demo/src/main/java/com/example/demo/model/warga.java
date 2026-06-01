package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "warga")
public class warga {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String namaWarga;
    private String alamat;

    // Konstruktor Kosong (Wajib untuk JPA)
    public warga() {}

    // Getter dan Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamaWarga() {
        return namaWarga;
    }

    public void setNamaWarga(String namaWarga) {
        this.namaWarga = namaWarga;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}