package com.example.demo.utils;

public class PoinB3 extends KalkulatorPoinBase {

    public PoinB3() {
        super("B3");
    }

    @Override
    public Double hitungPoin(Double beratKg) {
        // Method Overriding: Logika khusus sampah B3 (paling mahal)
        return beratKg * 5000.0;
    }
}