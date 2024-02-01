package com.wo.siteware.desafio.produto.domain;

import com.wo.siteware.desafio.produto.application.api.ProdutoEditRequest;
import com.wo.siteware.desafio.produto.application.api.ProdutoRequest;
import com.wo.siteware.desafio.produto.application.api.ProdutoRequestPromo;
import jakarta.persistence.Column;
import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

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
    private UUID idProduto;
    @Column(columnDefinition = "uuid", name = "idPromo", updatable = false, unique = true)
    private UUID idPromo;

    @NotBlank
    private String nome;
    @NotNull
    private Integer preco;

    private LocalDate dataHoraCadastro;
    private LocalDate dataHoraUltimaAlteracao;

    public Produto(ProdutoRequest produtoRequest) {
        this.nome = produtoRequest.nome();
        this.preco = produtoRequest.preco();
        this.dataHoraCadastro = LocalDate.now();
    }
    public Produto(UUID idPromo, ProdutoRequestPromo produto) {
        this.idPromo = idPromo;
        this.nome = produto.nome();
        this.preco = produto.preco();
        this.dataHoraCadastro = LocalDate.now();
    }

    public void atualizaProduto(ProdutoEditRequest produto) {
        this.preco = produto.preco();
        this.dataHoraUltimaAlteracao = LocalDate.now();
    }
}
