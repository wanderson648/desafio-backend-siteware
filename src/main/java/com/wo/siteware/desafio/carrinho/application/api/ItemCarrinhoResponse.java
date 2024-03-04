package com.wo.siteware.desafio.carrinho.application.api;

import com.wo.siteware.desafio.carrinho.domain.ItemCarrinho;
import com.wo.siteware.desafio.promocao.domain.TipoPromocao;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public record ItemCarrinhoResponse(
        UUID idItemCarrinho,
        UUID idProduto,
        BigDecimal produtoPreco,
        String produtoNome,
        Integer quantidade,
        TipoPromocao promocao,
        BigDecimal subtotal
) {
    public ItemCarrinhoResponse(ItemCarrinho itemCarrinho) {
        this(itemCarrinho.getIdItemCarrinho(), itemCarrinho.getProduto().getProdutoId(), itemCarrinho.getProduto().getPreco(),
                itemCarrinho.getProduto().getNome(), itemCarrinho.getQuantidade(),
                itemCarrinho.getPromocao(), itemCarrinho.getPrecoTotalLiquido());
    }

    public static List<ItemCarrinhoResponse> convert(List<ItemCarrinho> itens) {
        return itens.stream()
                .map(ItemCarrinhoResponse::new)
                .collect(Collectors.toList());
    }
}
