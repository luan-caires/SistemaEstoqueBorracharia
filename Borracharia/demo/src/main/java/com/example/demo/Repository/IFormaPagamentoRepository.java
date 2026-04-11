package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.FormaPagamento;

@Repository
public interface IFormaPagamentoRepository extends JpaRepository<FormaPagamento, Long> {

}
