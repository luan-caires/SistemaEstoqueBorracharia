package com.example.demo.Repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Categoria;

@Repository
public interface ICategoriaRepository extends JpaRepository<Categoria, Long> {

}
