package com.wo.siteware.desafio.carrinho.domain;

import com.wo.siteware.desafio.carrinho.application.api.CarrinhoRequest;
import com.wo.siteware.desafio.produto.domain.Produto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Carrinho {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", name = "idCarrinho", updatable = false, unique = true, nullable = false)
    private UUID idCarrinho;
    @NotNull

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idProduto")
    private Produto produto;

    private int quantidade;
    private double total;

//    List<Produto> produtos = new ArrayList<>();

    private LocalDate dataHoraCadastroNoCarrinho;
    private LocalDate dataHoraUltimaAlteracao;

    public Carrinho(CarrinhoRequest produtoCarrinho) {
        this.quantidade = produtoCarrinho.quantidade();
        this.dataHoraCadastroNoCarrinho = LocalDate.now();
    }

}
