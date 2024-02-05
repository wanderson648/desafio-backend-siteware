package com.wo.siteware.desafio.carrinho.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wo.siteware.desafio.carrinho.application.api.CarrinhoRequest;
import com.wo.siteware.desafio.produto.domain.Produto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

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

    @ManyToOne
    @JoinColumn(name = "idProduto")
    private Produto produto;

    private int quantidade;

    private LocalDate dataHoraCadastroNoCarrinho;
    private LocalDate dataHoraUltimaAlteracao;

    public Carrinho(CarrinhoRequest produtoCarrinho) {
        this.produto = produtoCarrinho.produtoId();
        this.quantidade = produtoCarrinho.quantidade();
        this.dataHoraCadastroNoCarrinho = LocalDate.now();
    }
}
