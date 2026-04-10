package com.example.demo.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table (name = "venda")
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long idVenda;

    private LocalDateTime dataVenda;

    private Double valorTotal;
    
    private Double valorPago;
    
    private Double valorTroco;
    
    private Double desconto;
    
    private Integer quantidadeVendida;
    

    @Enumerated(EnumType.STRING)
    @Column(name = "forma_pagamento")
        private FormaPagamento formaPagamento;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
        private Usuario usuario;

    @OneToMany(mappedBy = "venda")
        private List<VendaProduto> itens;

    // Getters e Setters
    
}
