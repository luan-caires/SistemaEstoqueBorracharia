package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Fornecedor;
@Repository
public interface IFornecedor extends JpaRepository<Fornecedor, Long> {

}
