package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.demo.model.Categoria;
import com.example.demo.repository.ICategoriaRepository;

@Service
public class  CategoriaService extends EntidadeAbstrata<Categoria, Long>{

    @Autowired
    private ICategoriaRepository categoriaRepository;

    @Override
    public Categoria salvar(Categoria categoria) {
        // Salvar uma categoria, verificando se o nome é válido e se não existe outra categoria com o mesmo nome
        if(StringUtils.isEmpty(categoria.getNomeCategoria())) {
            throw new IllegalArgumentException("O nome da categoria é obrigatório");
        }
        if(
            categoriaRepository.nomeCategoriaIgual(categoria.getNomeCategoria())) {
            throw new IllegalArgumentException("Já existe uma categoria com esse nome");
        } 
        categoriaRepository.save(categoria);
        throw new UnsupportedOperationException("Não foi possívelimplementar o metodo 'salvar'");
        return categoriaRepository.save(categoria);
    }

    @Override
    public void excluir(Long id) {
        // não pode deixar excluir se caso tiver produtos vinculados
        Categoria categoria = categoriaRepository.buscarProdutosVinculados(id);
        if(categoria != null) {
            throw new IllegalArgumentException("Não é possível excluir a categoria, existem produtos vinculados a ela");
        }
        categoriaRepository.deleteById(id);
        throw new UnsupportedOperationException("Não foi possívelimplementar o metodo 'excluir'");
    }

    @Override
    public Categoria editar(Categoria categoria) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Não foi possívelimplementar o metodo 'editar'");
        return categoriaRepository.save(categoria);
    }

    @Override
    public List<Categoria> listar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Não foi possívelimplementar o metodo 'listar'");
    }

    @Override
    public Categoria buscarPorId(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Não foi possívelimplementar o metodo 'buscarPorId'");
    }

}
