package com.wo.siteware.desafio.carrinho.application.api;

import com.wo.siteware.desafio.carrinho.domain.Carrinho;

import java.math.BigDecimal;
import java.util.List;

public record CarrinhoListResponse(List<ItemCarrinhoResponse> itens, BigDecimal total) {
    public CarrinhoListResponse(List<ItemCarrinhoResponse> itens, Carrinho carrinho) {
        this(itens, carrinho.getTotal());
    }
}