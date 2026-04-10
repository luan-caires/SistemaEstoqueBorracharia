package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Venda;

@Repository
public interface IVendaRepository extends JpaRepository<Venda, Long>{
    
    List<Venda> buscaDataVenda(String data);

}
