package com.example.demo.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "setoran")
public class setoran { // <-- Perbaikan: S menggunakan huruf besar

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String kategori; // Organik, Anorganik, atau B3
    private Double beratTotal;

    // Relationship: Satu warga bisa punya banyak setoran
    // CascadeType.ALL agar saat simpan Setoran, data Warga otomatis ikut tersimpan
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "warga_id")
    private warga warga; // <-- Pastikan Warga menggunakan W besar

    // Konstruktor Kosong (Wajib untuk JPA)
    public setoran() {} // <-- Perbaikan: S menggunakan huruf besar

    // Getter dan Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public Double getBeratTotal() {
        return beratTotal;
    }

    public void setBeratTotal(Double beratTotal) {
        this.beratTotal = beratTotal;
    }

    // Perbaikan: Return type dan Parameter menggunakan huruf W besar
    public warga getWarga() {
        return warga;
    }

    public void setWarga(warga warga) {
        this.warga = warga;
    }

    @CreationTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime tanggalSetoran;

    // TAMBAHKAN GETTER & SETTER NYA:
    public LocalDateTime getTanggalSetoran() {
        return tanggalSetoran;
    }

    public void setTanggalSetoran(LocalDateTime tanggalSetoran) {
        this.tanggalSetoran = tanggalSetoran;
    }
}