package com.example.demo.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Produto;


import io.micrometer.common.util.StringUtils;
@Service
public class ProdutoService extends EntidadeAbstrata<Produto, Long>{

    @Override
    public void salvar(Produto produto) {
        //Preciso salvar o produto, com um nome, valor maior que 0, e quantidade em estoque maior ou igual a 0
        if(StringUtils.isEmpty(produto.getNomeProduto())) {
            throw new IllegalArgumentException("O nome do produto é obrigatório");
        }
        if(produto.getValorCusto().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("O valor de custo do produto deve ser maior que zero");
        }
        if(produto.getQuantidadeEstoque() == null || produto.getQuantidadeEstoque() < 0) {
            throw new IllegalArgumentException("A quantidade em estoque do produto deve ser um valor não negativo");
        }
    }

    @Override
    public void excluir(Long id) {
        // Excluir um produto, verificando se o id é válido e se ele n está associado a nenhuma venda ou pedido
        if(id == null || id < 0) {
            throw new IllegalArgumentException("O id do produto é obrigatório para exclusão e deve ser um valor positivo");
        }
    }

    @Override
    public void editar(Produto produto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Não foi possível implementar o método 'editar'");
    }

    @Override
    public List<Produto> listar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Não foi possível implementar o método 'listar'");
    }

    @Override
    public Produto buscarPorId(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Não foi possível implementar o método 'buscarPorId'");
    }
    
    public void aumentarEstoque(Long id, int quantidade) {
        // Para aumentar o estoque de um produto, verificando se o id é válido e se a quantidade é positiva
        if(id == null || id <= 0) {
            throw new IllegalArgumentException("O id do produto é obrigatório para aumentar o estoque e deve ser um valor positivo");
        }
        if(quantidade <=0){
            throw new IllegalArgumentException("A quantidade para aumentar o estoque deve ser um valor positivo");
        }
    }
    public void diminuirEstoque(Long id, int quantidade) {
        // Para diminuir o estoque de um produto, verificando se o id é válido, se a quantidade é positiva e se o estoque atual é suficiente para a diminuição
        if(id == null || id <= 0) {
            throw new IllegalArgumentException("O id do produto é obrigatório para diminuir o estoque e deve ser um valor positivo");
        }
        if(quantidade <=0){
            throw new IllegalArgumentException("A quantidade para diminuir o estoque deve ser um valor positivo");
        }
    }
    public void atualizarEstoque(Long id, int novaQuantidade) {
        // Para atualizar o estoque de um produto, verificando se o id é válido e se a nova quantidade é não negativa
        if(id == null || id <= 0) {
            throw new IllegalArgumentException("O id do produto é obrigatório para atualizar o estoque e deve ser um valor positivo");
        }
        if(novaQuantidade < 0){
            throw new IllegalArgumentException("A nova quantidade para atualizar o estoque deve ser um valor não negativo");
        }
    }
    
}