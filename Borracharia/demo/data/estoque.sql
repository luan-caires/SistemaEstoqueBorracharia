drop database estoque;
create database estoque;
use estoque;

create table usuario (
    id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    senha VARCHAR(255) NOT NULL,
    perfil VARCHAR(50) NOT NULL
);

create table fornecedor (
    id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    cnpj VARCHAR(20),
    nome VARCHAR(100) NOT NULL,
    telefone VARCHAR(11)
);

create table categoria (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL
);

create table produto (
    id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    nome VARCHAR(100) NOT NULL,
    valor_custo DECIMAL(10,2),
    valor_venda DECIMAL(10,2) NOT NULL,
    quantidade_estoque INT NOT NULL DEFAULT 0,
    categoria_id INT,
    fornecedor_id INT,

    FOREIGN KEY (categoria_id) REFERENCES categoria(id),
    FOREIGN KEY (fornecedor_id) REFERENCES fornecedor(id)
);

create table entrada_produto (id INT AUTO_INCREMENT PRIMARY KEY,
    produto_id INT NOT NULL,
    fornecedor_id INT NOT NULL,
    usuario_id INT NOT NULL,
    quantidade_entrada INT NOT NULL,
    data DATETIME DEFAULT CURRENT_TIMESTAMP,

    FOREIGN KEY (produto_id) REFERENCES produto(id),
    FOREIGN KEY (fornecedor_id) REFERENCES fornecedor(id),
    FOREIGN KEY (usuario_id) REFERENCES usuario(id)
);
	
create table venda (
    id INT AUTO_INCREMENT PRIMARY KEY,
     valor_total DECIMAL(10,2) NOT NULL,
     valor_pago DECIMAL(10,2) NOT NULL,
     valor_troco DECIMAL(10,2) NOT NULL,
     desconto DECIMAL(10,2) NOT NULL,
    usuario_id INT NOT NULL,
    data DATETIME DEFAULT CURRENT_TIMESTAMP,
    forma_pagamento VARCHAR(50),

    FOREIGN KEY (usuario_id) REFERENCES usuario(id)
);

create table venda_produto(  
	id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    venda_id INT NOT NULL,
    produto_id INT NOT NULL,
    quantidade INT NOT NULL,
    valor_unitario DECIMAL(10,2) NOT NULL,
    subtotal DECIMAL(10,2) NOT NULL,

    FOREIGN KEY (venda_id) REFERENCES venda(id),
    FOREIGN KEY (produto_id) REFERENCES produto(id)
);

create table movimentacao_estoque(
id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    produto_id INT NOT NULL,
    usuario_id INT NOT NULL,
    tipo VARCHAR(20) NOT NULL,      /* ENTRADA / SAIDA*/
    origem VARCHAR(20) NOT NULL,    /* COMPRA / VENDA*/
    quantidade INT NOT NULL,
    data DATETIME DEFAULT CURRENT_TIMESTAMP,

    FOREIGN KEY (produto_id) REFERENCES produto(id),
    FOREIGN KEY (usuario_id) REFERENCES usuario(id)
);