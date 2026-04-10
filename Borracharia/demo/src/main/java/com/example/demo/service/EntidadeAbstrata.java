package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = false)
public abstract class EntidadeAbstrata<T, ID> {
    
    public abstract void salvar(T entidade);
    
    public abstract void excluir(ID id);
    
    public abstract void editar(T entidade);
    
    public abstract List<T> listar();
    
    public abstract T buscarPorId(ID id);

}
