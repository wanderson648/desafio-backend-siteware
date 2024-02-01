package com.wo.siteware.desafio.produto.application.api;

import lombok.Builder;

import java.util.UUID;

@Builder
public record ProdutoResponse(UUID idProduto) {
}
