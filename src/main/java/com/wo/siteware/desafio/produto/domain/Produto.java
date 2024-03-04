package com.wo.siteware.desafio.produto.domain;

import com.wo.siteware.desafio.produto.application.api.ProdutoEditaRequest;
import com.wo.siteware.desafio.produto.application.api.ProdutoRequest;
import com.wo.siteware.desafio.promocao.domain.TipoPromocao;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "uuid", name = "idProduto", updatable = false, unique = true, nullable = false)
    private UUID produtoId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 100)
    private TipoPromocao promocao;

    @NotBlank
    private String nome;
    @NotNull
    private BigDecimal preco;

    private LocalDate dataHoraCadastro;
    private LocalDate dataHoraUltimaAlteracao;

    public Produto(ProdutoRequest prodRequest) {
        this.nome = prodRequest.nome();
        this.preco = prodRequest.preco();
        this.promocao = prodRequest.promocao();
        this.dataHoraCadastro = LocalDate.now();
    }

    public void alterar(ProdutoEditaRequest produtoRequest) {
        this.nome = produtoRequest.nome();
        this.preco = produtoRequest.preco();
        this.promocao = produtoRequest.promocao();
    }
}
