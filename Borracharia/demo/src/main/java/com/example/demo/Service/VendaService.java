package com.example.demo.Service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Repository.IVendaRepository;
import com.example.demo.Repository.IProdutoRepository;
import com.example.demo.Repository.IUsuarioRepository;
import com.example.demo.model.Produto;

import com.example.demo.model.Venda;

@Service

@Transactional(readOnly = false)
public class VendaService {
    
    @Autowired
    private IVendaRepository vendaRepository;

    @Autowired
    private IProdutoRepository produtoRepository;
    
    @Autowired
    private IUsuarioRepository usuarioRepository;
  
    //salva uma venda por odem de venda 
    public void salvarVenda(Venda venda) {
        vendaRepository.save(venda);
    }
    //exclui uma venda por id
    public void excluirVenda(Long id) {
        vendaRepository.deleteById(id);
    }
    //lista todas as vendas
    @Transactional(readOnly = true)
    public List<Venda> listarVendas() {
        return vendaRepository.findAll();
    }
    //busca uma venda por id
    @Transactional(readOnly = true)
    public Venda buscarVendaPorId(Long id) {
        return vendaRepository.findById(id).orElse(null);
    }
    //busca uma venda por data
    @Transactional(readOnly = true)
    public Venda buscarVendaPorData(LocalDate data) {
        return vendaRepository.findByData(data);
    }
    //Calcula o valor total da venda
    public Double calcularValorTotalVenda(Venda venda) {
        Double valorTotal = 0.0;
        for (Produto produto : venda.getProdutos()) {
            valorTotal += (produto.getValorVenda() * produto.getQuantidadeVendida());

        }
        return valorTotal;
    }
}