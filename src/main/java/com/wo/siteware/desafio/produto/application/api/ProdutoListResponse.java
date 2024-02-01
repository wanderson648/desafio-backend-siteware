package com.wo.siteware.desafio.produto.application.api;

import com.wo.siteware.desafio.produto.domain.Produto;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public record ProdutoListResponse(UUID idProduto, String nome, double preco, UUID idPromo) {

    public static List<ProdutoListResponse> convert(List<Produto> produtos) {
        return produtos.stream().map(produto ->
                new ProdutoListResponse(
                        produto.getIdProduto(),
                        produto.getNome(),
                        produto.getPreco(),
                        produto.getIdPromo())
        ).collect(Collectors.toList());
    }
}
