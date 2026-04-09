package com.example.demo.Repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.MovimentacaoEstoque;

@Repository
public interface IMovimentacaoEstoque extends JpaRepository<MovimentacaoEstoque, Long> {

}
