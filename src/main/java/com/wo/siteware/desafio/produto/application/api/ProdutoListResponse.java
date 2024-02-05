package com.wo.siteware.desafio.produto.application.api;

import com.wo.siteware.desafio.produto.domain.Produto;
import com.wo.siteware.desafio.promocao.domain.Promocao;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public record ProdutoListResponse(UUID idProduto, String nome, double preco, Promocao idPromo) {

    public static List<ProdutoListResponse> convert(List<Produto> produtos) {
        return produtos.stream().map(produto ->
                new ProdutoListResponse(
                        produto.getProdutoId(),
                        produto.getNome(),
                        produto.getPreco(),
                        produto.getPromoId())
        ).collect(Collectors.toList());
    }
}
