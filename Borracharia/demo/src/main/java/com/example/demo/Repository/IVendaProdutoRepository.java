package com.example.demo.Repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.VendaProduto;

@Repository
public interface IVendaProdutoRepository extends JpaRepository<VendaProduto, Long>{

}
