package com.example.demo.utils;

public class PoinOrganik extends KalkulatorPoinBase {

    public PoinOrganik() {
        super("Organik");
    }

    @Override
    public Double hitungPoin(Double beratKg) {
        // Method Overriding: Logika khusus sampah organik
        return beratKg * 1000.0; 
    }
}