package com.example.demo.repository;

import com.example.demo.model.setoran;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SetoranRepository extends JpaRepository<setoran, Long> {
}