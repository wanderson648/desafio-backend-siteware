package com.wo.siteware.desafio.produtos.domain;

import com.wo.siteware.desafio.produtos.application.api.ProdutoEditRequest;
import com.wo.siteware.desafio.produtos.application.api.ProdutoRequest;
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
    @Column(columnDefinition = "uuid", updatable = false, unique = true, nullable = false)
    private UUID idProduto;
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

    public void editaProduto(ProdutoEditRequest produtoEditRequest) {
        this.nome = produtoEditRequest.nome();
        this.preco = produtoEditRequest.preco();
        this.dataHoraUltimaAlteracao = LocalDate.now();
    }
}
