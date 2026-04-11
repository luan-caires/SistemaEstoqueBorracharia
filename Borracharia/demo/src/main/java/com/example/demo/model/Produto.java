package com.example.demo.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long idProduto;

    @Column(nullable= false, length = 100)
        private String nomeProduto;
    @Column(nullable = true, length = 50, unique = true)
        private String marcaProduto;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
        private Categoria categoria;

    private BigDecimal valorCusto;
    
    private BigDecimal valorVenda;
    
    private BigDecimal subTotal;
    private Integer quantidadeEstoque;

    

}
