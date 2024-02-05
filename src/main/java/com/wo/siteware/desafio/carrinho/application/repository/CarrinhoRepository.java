package com.wo.siteware.desafio.carrinho.application.repository;

import com.wo.siteware.desafio.carrinho.domain.Carrinho;

import java.util.List;

public interface CarrinhoRepository {
    Carrinho salvaItemCarrinho(Carrinho carrinho);

    List<Carrinho> buscaItems();
}
