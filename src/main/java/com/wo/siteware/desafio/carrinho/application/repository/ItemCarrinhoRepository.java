package com.wo.siteware.desafio.carrinho.application.repository;

import com.wo.siteware.desafio.carrinho.domain.Carrinho;
import com.wo.siteware.desafio.carrinho.domain.ItemCarrinho;

import java.util.List;

public interface ItemCarrinhoRepository {
    List<ItemCarrinho> acharCarrinho(Carrinho carrinho);
}
