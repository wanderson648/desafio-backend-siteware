package com.wo.siteware.desafio.produtos.application.api;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProdutoEditRequest(@NotBlank String nome, @NotNull Integer preco) {
}
