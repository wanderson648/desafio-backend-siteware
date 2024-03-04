package com.wo.siteware.desafio.produto.application.api;

import com.wo.siteware.desafio.produto.domain.Produto;

import java.util.UUID;

public record ProdutoResponse(UUID produto) {
    public ProdutoResponse(Produto produto) {
        this(produto.getProdutoId());
    }
}
