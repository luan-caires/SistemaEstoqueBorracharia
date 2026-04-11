package com.example.demo.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Produto;
import com.example.demo.model.StatusVenda;
import com.example.demo.model.Usuario;
import com.example.demo.model.Venda;
import com.example.demo.model.VendaProduto;
import com.example.demo.model.Perfil;
import com.example.demo.repository.IVendaRepository;
import com.example.demo.repository.IProdutoRepository;

@Service
public class VendaService {

    @Autowired
    private IVendaRepository vendaRepository;

    @Autowired
    private IProdutoRepository produtoRepository;

    // ===============================
    // CRIAR VENDA
    // ===============================
    public Venda salvar(Venda venda) {
        return vendaRepository.save(venda);
    }

    // ===============================
    // BUSCAR POR ID
    // ===============================
    public Venda buscarPorId(Long id) {
        return vendaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Venda não encontrada"));
    }

    // ===============================
    // LISTAR TODAS
    // ===============================
    public List<Venda> listarTodas() {
        return vendaRepository.findAll();
    }

    // ===============================
    // DELETAR
    // ===============================
    public void deletar(Long id) {
        vendaRepository.deleteById(id);
    }

    // ===============================
    // FINALIZAR VENDA
    // ===============================
    public Venda finalizarVenda(Long vendaId, Usuario usuario) {

        validarPermissao(usuario);

        Venda venda = buscarPorId(vendaId);

        if (venda.getItens() == null || venda.getItens().isEmpty()) {
            throw new RuntimeException("Venda sem itens");
        }

        BigDecimal valorTotal = BigDecimal.ZERO;

        for (VendaProduto item : venda.getItens()) {

            Produto produto = produtoRepository.findById(item.getProduto().getId())
                    .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

            if (produto.getQuantidadeEstoque() < item.getQuantidade()) {
                throw new RuntimeException("Estoque insuficiente para o produto: " + produto.getNomeProduto());
            }

            // Atualiza estoque
            produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() - item.getQuantidade());
            produtoRepository.save(produto);

            // Calcula subtotal
            BigDecimal subtotal = produto.getValorVenda().multiply(BigDecimal.valueOf(item.getQuantidade()));
            
            item.setSubTotal(subtotal);
            valorTotal = valorTotal.add(subtotal);
        }

        venda.setValorTotal(valorTotal);
        venda.setStatusVenda(StatusVenda.CONCLUIDA);

        return vendaRepository.save(venda);
    }

    // ===============================
    // CANCELAR VENDA
    // ===============================
    public Venda cancelarVenda(Long vendaId) {

        Venda venda = buscarPorId(vendaId);

        if (venda.getStatusVenda() == StatusVenda.CONCLUIDA) {
            throw new RuntimeException("Não é possível cancelar uma venda já concluída");
        }

        venda.setStatusVenda(StatusVenda.CANCELADA);

        return vendaRepository.save(venda);
    }

    // ===============================
    // VALIDAÇÃO DE PERMISSÃO
    // ===============================
    private void validarPermissao(Usuario usuario) {

        if (usuario.getPerfil() != Perfil.ADMINISTRADOR &&
            usuario.getPerfil() != Perfil.VENDEDOR) {

            throw new RuntimeException("Usuário não tem permissão para realizar vendas");
        }
    }
}