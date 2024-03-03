package com.wo.siteware.desafio.produto.application.api;

import com.wo.siteware.desafio.produto.domain.Produto;
import com.wo.siteware.desafio.promocao.domain.TipoPromocao;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public record ProdutoListResponse(UUID idProduto, String nome, BigDecimal preco, TipoPromocao promocao) {
    public static List<ProdutoListResponse> convert(List<Produto> produtos) {
        return produtos.stream()
                .map(ProdutoListResponse::new)
                .collect(Collectors.toList());
    }

    public ProdutoListResponse(Produto produto) {
        this(produto.getProdutoId(), produto.getNome(), produto.getPreco(), produto.getPromocao());
    }
}
