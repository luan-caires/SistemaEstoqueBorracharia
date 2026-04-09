# SistemaEstoqueBorracharia
Um sistema para gerenciar um estoque de uma borracharia e logo depois fazer uma integração completa com o cliente, enviando notificações e recomendações

Para os Relacionamentos no Banco de Dados, utilizei o seguinte modelo mental:

Fornecedor 1 ─── N Produto
Categoria 1 ─── N Produto

Produto 1 ─── N EntradaProduto
Produto 1 ─── N VendaProduto

Venda 1 ─── N VendaProduto

Usuário 1 ─── N Venda
Usuário 1 ─── N Entrada
Usuário 1 ─── N Movimentação
---------------------------REPOSITORY---------------------------

vendarepository---- venda

vendaprodutorepository---- vendaproduto

perfilrepository---------- perfil

produtorepository--------- produto

usuariorepository---------usuario

categoriarepository------ categoria

movimentacaoestoquerepository ------ movimentacaoestoque

---------------------------------------SERVICE-------------------
No service, onde entra a lógica de serviço tentei fazer

VendaService -------->  Receber uma venda com itens
                        Validar dados
                        Calcular valores
                        Associar corretamente os itens 
                        Dar baixa no estoque
                        Salvar tudo no banco
