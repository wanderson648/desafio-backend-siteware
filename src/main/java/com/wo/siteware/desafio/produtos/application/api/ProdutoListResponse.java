package com.wo.siteware.desafio.produtos.application.api;

import com.wo.siteware.desafio.produtos.domain.Produto;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public record ProdutoListResponse(UUID idProduto, String nome, double preco) {

    public static List<ProdutoListResponse> convert(List<Produto> produtos) {
        return produtos.stream().map(produto ->
                new ProdutoListResponse(
                        produto.getIdProduto(),
                        produto.getNome(),
                        produto.getPreco())
        ).collect(Collectors.toList());
    }
}
