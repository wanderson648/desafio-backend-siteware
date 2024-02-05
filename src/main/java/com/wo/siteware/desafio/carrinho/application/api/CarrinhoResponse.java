package com.wo.siteware.desafio.carrinho.application.api;

import lombok.Builder;

import java.util.UUID;

@Builder
public record CarrinhoResponse(UUID idCarrinho) {
}
