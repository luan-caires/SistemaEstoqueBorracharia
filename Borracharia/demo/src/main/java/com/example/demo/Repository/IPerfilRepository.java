package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Perfil;

@Repository
public interface IPerfilRepository extends JpaRepository<Perfil, Long> {

}
