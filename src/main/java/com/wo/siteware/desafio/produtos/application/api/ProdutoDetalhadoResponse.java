package com.wo.siteware.desafio.produtos.application.api;

import java.util.UUID;

public record ProdutoDetalhadoResponse(UUID idProduto, String nome, double preco) {
}
