package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Usuario;


@Service
public class UsuarioService extends EntidadeAbstrata<Usuario, Long>{

    @Override
    public void salvar(Usuario usuario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Não foi possívelimplementar o metodo 'salvar'");
    }

    @Override
    public void excluir(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Não foi possívelimplementar o metodo 'excluir'");
    }

    @Override
    public void editar(Usuario usuario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Não foi possívelimplementar o metodo 'editar'");
    }

    @Override
    public List<Usuario> listar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Não foi possívelimplementar o metodo 'listar'");
    }

    @Override
    public Usuario buscarPorId(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Não foi possívelimplementar o metodo 'buscarPorId'");
    }


}
