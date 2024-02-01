package com.wo.siteware.desafio.produto.application.api;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record ProdutoRequestPromo(@NotBlank String nome, @NotNull Integer preco, UUID idPromo) {
}
