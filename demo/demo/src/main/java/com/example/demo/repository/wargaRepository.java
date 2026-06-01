package com.example.demo.repository;

import com.example.demo.model.warga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface wargaRepository extends JpaRepository<warga, Long> {
}