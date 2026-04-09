package com.example.demo.model;

@Entity
@Table(name = "movimentacao_estoque")
public class MovimentacaoEstoque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMovimentacao;

    private LocalDateTime dataMovimentacao;
    
    private int quantidade;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_movimentacao")
    private TipoMovimentacao tipoMovimentacao;

    @Enumerated(EnumType.STRING)
    @Column(name = "origem")
    private Origem origem;

    @ManyToOne
    @JoinColumn(name = "id_produto")
    private Produto produto;
    
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

}
