package com.example.demo;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.model.Perfil;
import com.example.demo.model.Produto;
import com.example.demo.model.StatusVenda;
import com.example.demo.model.Usuario;
import com.example.demo.model.Venda;
import com.example.demo.model.VendaProduto;
import com.example.demo.service.ProdutoService;
import com.example.demo.service.VendaService;

@SpringBootApplication
public class DemoApplication {

	private final VendaService vendaService;
    private final ProdutoService produtoService;
    DemoApplication(ProdutoService produtoService, VendaService vendaService) {
        this.produtoService = produtoService;
        this.vendaService = vendaService;
    }
    public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		//Faça testes com comandLineRunner
		
	}
	@Bean
	CommandLineRunner run(
			ProdutoService produtoService,
			VendaService vendaService) {

		return args -> {

			// ===============================
			// 1. CRIAR USUÁRIO
			// ===============================
			Usuario usuario = new Usuario();
			usuario.setNomeUsuario("Luan");
			usuario.setPerfil(Perfil.VENDEDOR);

			// ===============================
			// 2. CRIAR PRODUTOS
			// ===============================
			Produto p1 = new Produto();
			p1.setNomeProduto("Pneu Aro 15");
			p1.setValorCusto(new BigDecimal("300"));
			p1.setQuantidadeEstoque(10);

			Produto p2 = new Produto();
			p2.setNomeProduto("Pneu Aro 17");
			p2.setValorCusto(new BigDecimal("500"));
			p2.setQuantidadeEstoque(5);

			p1 = produtoService.salvar(p1);
			p2 = produtoService.salvar(p2);

			// ===============================
			// 3. CRIAR ITENS DA VENDA
			// ===============================
			VendaProduto item1 = new VendaProduto();
			item1.setProduto(p1);
			item1.setQuantidade(2);

			VendaProduto item2 = new VendaProduto();
			item2.setProduto(p2);
			item2.setQuantidade(1);

			// ===============================
			// 4. CRIAR VENDA
			// ===============================
			Venda venda = new Venda();
			venda.setItens(List.of(item1, item2));
			venda.setStatusVenda(StatusVenda.PENDENTE);

			venda = vendaService.salvar(venda);

			// ===============================
			// 5. FINALIZAR VENDA
			// ===============================
			venda = vendaService.finalizarVenda(venda.getIdVenda(), usuario);

			// ===============================
			// 6. RESULTADO
			// ===============================
			System.out.println("Venda finalizada!");
			System.out.println("Total: " + venda.getValorTotal());
			System.out.println("Status: " + venda.getStatusVenda());

			System.out.println("Estoque atualizado:");
			System.out.println("P1: " + produtoService.buscarPorId(p1.getIdProduto()).getQuantidadeEstoque());
			System.out.println("P2: " + produtoService.buscarPorId(p2.getIdProduto()).getQuantidadeEstoque());
		};
	}

}
