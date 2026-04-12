package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Perfil;
import com.example.demo.model.Usuario;
import com.example.demo.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UsuarioService extends EntidadeAbstrata<Usuario, Long>{
    
    @Autowired
    private IUsuarioRepository usuarioRepository;
    
    @Override
    public Usuario salvar(Usuario usuario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Não foi possívelimplementar o metodo 'salvar'");
        return usuarioRepository.save(usuario);
    }

    @Override
    public void excluir(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Não foi possívelimplementar o metodo 'excluir'");
    }

    @Override
    public Usuario editar(Usuario usuario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Não foi possívelimplementar o metodo 'editar'");
        return usuarioRepository.save(usuario);
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
    
    public void validarUsuario(Usuario usuario){
        if(usuario.getPerfil()!=Perfil.ADMINISTRADOR && usuario.getPerfil()!=Perfil.GERENTE){
            throw new IllegalArgumentException("O perfil do usuário deve ser ADMINISTRADOR ou GERENTE");
        }
        usuarioRepository.save(usuario);
    }


}
