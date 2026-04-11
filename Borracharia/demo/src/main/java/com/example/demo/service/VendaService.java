package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Venda;
import com.example.demo.repository.IVendaRepository;
import com.example.demo.model.StatusVenda;
import com.example.demo.model.Produto;
import com.example.demo.repository.IProdutoRepository;
import com.example.demo.model.FormaPagamento;
import com.example.demo.model.VendaProduto;
import com.example.demo.model.Usuario;
import com.example.demo.repository.IUsuarioRepository;
import com.example.demo.model.Perfil;
import com.example.demo.repository.IPerfilRepository;
@Service
public class VendaService extends EntidadeAbstrata<Venda, Long> {
    @Autowired
    private IVendaRepository vendaRepository;
    @Autowired
    private IProdutoRepository produtoRepository;
    @Autowired  
    private IUsuarioRepository usuarioRepository;
    

    @Override
    public void salvar(Venda venda) {
        // Salvar uma venda, verificando se os campos obrigatórios estão preenchidos e se a venda é válida
        if(venda.getValorTotal() == null || venda.getValorTotal() <= 0) {
            throw new IllegalArgumentException("O valor total da venda é obrigatório e deve ser maior que zero");
        }
        if(venda.getDataVenda() == null) {
            throw new IllegalArgumentException("A data da venda é obrigatória");
        }
        vendaRepository.save(venda);
    }

    
    public void adicionarItemVenda(Venda venda) {
        if(venda.getItens() == null || venda.getItens().isEmpty()) {
            throw new IllegalArgumentException("A venda deve conter pelo menos um item");
        }
        // Lógica para calcular o valor total da venda com base nos itens
        double total = venda.getItens().stream()
            .mapToDouble(item -> item.getValorTotal())
            .sum();
            int quantidadeVendida = venda.getItens().stream()
            .mapToInt(item -> item.getQuantidade())
            .sum();
        venda.setValorTotal(total);
        venda.setQuantidadeVendida(quantidadeVendida);
        venda.getItens().forEach(item -> item.setVenda(venda));
    }

    @Override
    public void excluir(Long id) {
        // TODO Auto-generated method sttub
        throw new UnsupportedOperationException("Não foi possívelimplementar o metodo 'excluir'");
    }

    public void removerItemVenda(Venda venda) {
        if(venda.getItens() == null || venda.getItens().isEmpty()) {
            throw new IllegalArgumentException("A venda deve conter pelo menos um item para remover");
        }
        // Lógica para remover um item da venda e recalcular o valor total
        double total = venda.getItens().stream()
            .mapToDouble(item -> item.getValorTotal())
            .sum();
            int quantidadeVendida = venda.getItens().stream()
            .mapToInt(item -> item.getQuantidade())
            .sum();
        venda.setValorTotal(total);
        venda.setQuantidadeVendida(quantidadeVendida);
        venda.getItens().remove(venda);
    }


    @Override
    public void editar(Venda venda) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Não foi possívelimplementar o metodo 'editar'");
    }
    
    public void finalizarVenda(Venda venda) {
        if(venda.getStatusVenda() == null || venda.getStatusVenda().isEmpty()) {
            throw new IllegalArgumentException("O status da venda é obrigatório e deve ser uma string não vazia");

        }
        double valorTotal = venda.getItens().stream()
            .mapToDouble(item -> item.getSubTotal())
            .sum();
        
        venda.setValorTotal(valorTotal);

        int quantidadeVendida = venda.getItens().stream()
            .mapToInt(item -> item.getQuantidade())
            .sum();

        venda.setQuantidadeVendida(quantidadeVendida);
        venda.setValorTotal(valorTotal);
        venda.setStatusVenda(StatusVenda.CONCLUIDA.name());

        if(venda.getValorPago() < venda.getValorTotal()) {
            throw new IllegalArgumentException("O valor pago deve ser maior ou igual ao valor total da venda");
        }
        for (VendaProduto item : venda.getItens()) {

            Produto produto = item.getProduto();

            if (produto.getQuantidadeEstoque() < item.getQuantidade()) {
                throw new IllegalArgumentException("Estoque insuficiente para o produto: " + produto.getNome());
            }
        
        produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() - item.getQuantidade());
        produtoRepository.save(produto);
    }


        venda.setValorTroco(venda.getValorPago() - venda.getValorTotal());
        vendaRepository.save(venda);
        venda.setStatusVenda(StatusVenda.CONCLUIDA.name());
        vendaRepository.save(venda);
        
    }

    @Override
    public List<Venda> listar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Não foi possívelimplementar o metodo 'listar'");
    }
    
    public List<Venda> buscarPorData(String data) {
        if(data == null || data.isEmpty()) {
            throw new IllegalArgumentException("A data para busca é obrigatória e deve ser uma string não vazia");
        }
        return vendaRepository.buscaDataVenda(data);
    }

    @Override
    public Venda buscarPorId(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Não foi possívelimplementar o metodo 'buscarPorId'");
    }

    public void validarPermissaoVenda(Usuario usuario) {
        if(usuario.getPerfil() != Perfil.ADMINISTRADOR && usuario.getPerfil() != Perfil.GERENTE && usuario.getPerfil() != Perfil.VENDEDOR) {
            throw new IllegalArgumentException("O usuário deve ter perfil de ADMINISTRADOR ou GERENTE para realizar vendas");
        }
    }


}
