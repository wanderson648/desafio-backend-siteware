package com.wo.siteware.desafio.produto.domain;

import com.wo.siteware.desafio.produto.application.api.ProdutoEditRequest;
import com.wo.siteware.desafio.produto.application.api.ProdutoRequest;
import com.wo.siteware.desafio.produto.application.api.ProdutoRequestPromo;
import com.wo.siteware.desafio.promocao.domain.Promocao;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", name = "idProduto", updatable = false, unique = true, nullable = false)
    private UUID produtoId;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idPromo", updatable = false, unique = true)
    private Promocao promoId;

    @NotBlank
    private String nome;
    @NotNull
    private Integer preco;

    private LocalDate dataHoraCadastro;
    private LocalDate dataHoraUltimaAlteracao;

    public Produto(ProdutoRequestPromo produtoRequest) {
        this.nome = produtoRequest.nome();
        this.preco = produtoRequest.preco();
        this.dataHoraCadastro = LocalDate.now();
    }

    public Produto(ProdutoRequest prodRequest) {
        this.nome = prodRequest.nome();
        this.preco = prodRequest.preco();
        this.dataHoraCadastro = LocalDate.now();
    }

    public void atualizaProduto(ProdutoEditRequest produto) {
        this.preco = produto.preco();
        this.dataHoraUltimaAlteracao = LocalDate.now();
    }
}
