package com.wo.siteware.desafio.carrinho.application.api;

import com.wo.siteware.desafio.produto.domain.Produto;

public record CarrinhoRequest(Produto produtoId, int quantidade) {
}