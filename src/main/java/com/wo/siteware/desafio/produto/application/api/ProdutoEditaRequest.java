package com.wo.siteware.desafio.produto.application.api;

import com.wo.siteware.desafio.promocao.domain.TipoPromocao;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProdutoEditaRequest(@NotBlank String nome, @NotNull BigDecimal preco, TipoPromocao promocao) {
}
