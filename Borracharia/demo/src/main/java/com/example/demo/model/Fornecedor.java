package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "fornecedores")
@Data
public class Fornecedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFornecedor;
    @Column(nullable = false, length = 100)
    private String nomeFornecedor;
    @Column(nullable = true, length = 20)
    private String cnpjFornecedor;
    @Column(nullable = false, length = 11)
    private String telefoneFornecedor;

}
