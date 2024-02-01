package com.wo.siteware.desafio.produto.application.api;

import jakarta.validation.constraints.NotNull;

public record ProdutoEditRequest(@NotNull Integer preco) {
}
