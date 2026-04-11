package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.FormaPagamento;
import com.example.demo.repository.IFormaPagamentoRepository;
import java.util.List;

@Service
public class FormaPagamentoService extends EntidadeAbstrata<FormaPagamento, Long>{
    @Autowired
    private IFormaPagamentoRepository formaPagamentoRepository;

    @Override
    public void salvar(FormaPagamento formaPagamento) {
        formaPagamentoRepository.save(formaPagamento);
    }

    public void excluir(Long id) {
        formaPagamentoRepository.deleteById(id);
    }

    
}
