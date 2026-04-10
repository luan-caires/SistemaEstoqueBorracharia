package com.example.demo.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Venda;

@Repository
public interface IVendaRepository extends JpaRepository<Venda, Long>{
    
    Venda findByData(LocalDate data);

}
