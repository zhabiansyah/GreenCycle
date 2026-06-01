package com.example.demo.utils;

public class PoinAnorganik extends KalkulatorPoinBase {

    public PoinAnorganik() {
        super("Anorganik");
    }

    @Override
    public Double hitungPoin(Double beratKg) {
        // Method Overriding: Logika khusus sampah anorganik (lebih mahal)
        return beratKg * 2500.0;
    }
}