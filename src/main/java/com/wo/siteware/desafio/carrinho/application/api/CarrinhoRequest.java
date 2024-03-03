package com.wo.siteware.desafio.carrinho.application.api;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record CarrinhoRequest(@NotNull UUID idProduto) {
}