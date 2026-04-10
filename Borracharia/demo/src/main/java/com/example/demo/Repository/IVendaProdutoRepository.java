package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.VendaProduto;

@Repository
public interface IVendaProdutoRepository extends JpaRepository<VendaProduto, Long>{

}
