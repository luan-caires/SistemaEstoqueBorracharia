package com.example.demo.Repository;

import java.time.LocalDate;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Venda;

@Repository
public interface IVendaRepository extends JpaRepository<Venda, Long>{


}
