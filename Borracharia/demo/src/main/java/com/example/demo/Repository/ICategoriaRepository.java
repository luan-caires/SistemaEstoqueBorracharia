package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Categoria;

@Repository
public interface ICategoriaRepository extends JpaRepository<Categoria, Long> {

    boolean nomeCategoriaIgual(String nomeCategoria);
    Categoria buscarProdutosVinculados(Long idCategoria);

}
