package com.wo.siteware.desafio.produto.application.api;

import com.wo.siteware.desafio.produto.domain.Produto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
public class ProdutoDetalhadoResponse {
    UUID idProduto;
    String nome;
    double preco;

    public ProdutoDetalhadoResponse(Produto produto) {
        this.idProduto = produto.getProdutoId();
        this.nome = produto.getNome();
        this.preco = produto.getPreco();
    }
}
