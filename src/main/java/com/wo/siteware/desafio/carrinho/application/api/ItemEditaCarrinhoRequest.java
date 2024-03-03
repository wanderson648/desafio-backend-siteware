package com.wo.siteware.desafio.carrinho.application.api;

import java.util.UUID;

public record ItemEditaCarrinhoRequest(UUID idProduto, Integer quantidade) {
}
