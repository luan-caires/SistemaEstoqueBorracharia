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
    public List<FormaPagamento> listar() {
        return formaPagamentoRepository.findAll();
    }

    @Override
    public void salvar(FormaPagamento formaPagamento) {
        
         formaPagamentoRepository.save(formaPagamento);
    }

    @Override
    public void excluir(Long id) {
        if(!formaPagamentoRepository.existsById(id)) {
            throw new IllegalArgumentException("A forma de pagamento com o id " + id + " não existe");
        }
        formaPagamentoRepository.deleteById(id);
    }

    @Override
    public FormaPagamento buscarPorId(Long id) {
         if(!formaPagamentoRepository.existsById(id)) {
             throw new IllegalArgumentException("A forma de pagamento com o id " + id + " não existe");
         }
         return formaPagamentoRepository.findById(id).orElse(null);
    }
}