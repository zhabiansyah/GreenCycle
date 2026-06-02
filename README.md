# ♻️ Aplikasi Bank Sampah (Waste Bank Management System)

Aplikasi Bank Sampah adalah sistem manajemen berbasis web (Spring Boot & Vanilla JS) yang dirancang untuk mencatat setoran sampah warga, mengedukasi masyarakat tentang pemilahan sampah, dan mendorong partisipasi lingkungan melalui sistem gamifikasi (poin dan *reward*).

## ✨ Fitur Utama

* **Pencatatan Setoran:** Warga dapat menyetorkan sampah berdasarkan kategori (Organik, Anorganik, B3) dan berat (Kg).
* **Perhitungan Poin Cerdas:** Sistem secara dinamis menghitung poin yang didapat berdasarkan rumus masing-masing kategori sampah.
* **Sistem Achievement & Reward:** Fitur gamifikasi di mana warga akan mendapatkan bonus Rp 10.000 secara otomatis setiap berhasil mengumpulkan kelipatan 1.000 poin.
* **Leaderboard Interaktif:** Papan peringkat (Klasemen) *real-time* yang menampilkan warga dengan kontribusi poin tertinggi, lengkap dengan ikon medali.
* **Dasbor Edukasi:** Menyediakan informasi visual yang menarik mengenai jenis-jenis sampah dan cara memilahnya.

## 🛠️ Teknologi yang Digunakan

**Backend:**
* Java 17+
* Spring Boot (RESTful API)
* Spring Data JPA (Hibernate)
* Database MySQL / PostgreSQL

**Frontend:**
* HTML5, CSS3, Vanilla JavaScript
* Fetch API untuk integrasi Client-Server (Client-Side Rendering)

## 🏗️ Arsitektur & Konsep OOP

Proyek ini dibangun menggunakan **Layered Architecture (Controller-Service-Repository)** dan menerapkan pilar-pilar *Object-Oriented Programming* (OOP) tingkat lanjut:

1. **Polimorfisme:** Digunakan pada *Service Layer* (`hitungTotalPoin`). Sistem membedakan rumus perhitungan poin secara otomatis berdasarkan input kategori sampah (Organik, Anorganik, B3) menggunakan metode yang sama.
2. **DTO (Data Transfer Object) Pattern:** Menggunakan `SetoranRequestDTO` untuk membungkus data dari *frontend* sebelum diproses oleh *controller*, mencegah manipulasi data langsung ke entitas *database*.
3. **Enkapsulasi:** Melindungi data-data sensitif di dalam Entitas/Model menggunakan atribut `private` yang hanya bisa diakses melalui metode *Getter* dan *Setter*.

## 🚀 Cara Menjalankan Aplikasi Lokal

1. **Siapkan Database:**
   * Buat database baru di MySQL/phpMyAdmin (misalnya: `db_banksampah`).
   * Sesuaikan `application.properties` di Spring Boot dengan *username* dan *password* database Anda.
2. **Jalankan Backend:**
   * *Build* dan *Run* proyek Spring Boot menggunakan IDE (IntelliJ IDEA, Eclipse, atau VS Code). Aplikasi akan berjalan di `http://localhost:8080`.
3. **Buka Frontend:**
   * Buka file `index.html` menggunakan *Live Server* atau *browser* pilihan Anda.

---
*Dibuat dengan ❤️ untuk lingkungan yang lebih hijau.*
