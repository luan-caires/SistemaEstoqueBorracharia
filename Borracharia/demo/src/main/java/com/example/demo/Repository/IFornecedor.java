package com.example.demo.Repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Fornecedor;
@Repository
public interface IFornecedor extends JpaRepository<Fornecedor, Long> {

}
