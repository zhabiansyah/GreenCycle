// server.js
const express = require('express');
const cors = require('cors');
const app = express();
const PORT = 3000;

// Middleware
app.use(cors()); // Mengizinkan frontend mengakses backend ini
app.use(express.json()); // Membaca data JSON dari request

// Simulasi Database (Array)
let riwayatSetoran = [
    { id: 1, nama: "Asep Surasep", kategori: "Organik", berat: 5.2, tanggal: "2026-04-28" },
    { id: 2, nama: "Siti Aminah", kategori: "Anorganik", berat: 2.1, tanggal: "2026-04-28" }
];

// Endpoint 1: GET (Mengambil semua data)
app.get('/api/setoran', (req, res) => {
    res.json(riwayatSetoran);
});

// Endpoint 2: POST (Menambah data setoran baru)
app.post('/api/setoran', (req, res) => {
    const { nama, kategori, berat } = req.body;
    
    const setoranBaru = {
        id: riwayatSetoran.length + 1,
        nama: nama,
        kategori: kategori,
        berat: parseFloat(berat),
        tanggal: new Date().toISOString().split('T')[0]
    };

    riwayatSetoran.push(setoranBaru);
    res.status(201).json({ message: "Setoran berhasil dicatat!", data: setoranBaru });
});

// Menyalakan Server
app.listen(PORT, () => {
    console.log(`🚀 Backend GreenCycle (Node.js) berjalan di http://localhost:${PORT}`);
});