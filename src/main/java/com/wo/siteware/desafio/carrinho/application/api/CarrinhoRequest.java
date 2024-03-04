package com.wo.siteware.desafio.carrinho.application.api;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.util.UUID;

@Builder
public record CarrinhoRequest(@NotNull UUID idCliente) {
}