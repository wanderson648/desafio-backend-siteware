package com.wo.siteware.desafio.produtos.application.api;

import lombok.Builder;

import java.util.UUID;

@Builder
public record ProdutoResponse(UUID idProduto) {
}
