package com.wo.siteware.desafio.carrinho.application.repository;

import com.wo.siteware.desafio.carrinho.domain.Carrinho;

import java.util.List;
import java.util.UUID;

public interface CarrinhoRepository {
    Carrinho buscarCarrinhoPorId(UUID idCarrinho);

    Carrinho salvarCarrinho(Carrinho carrinho);
}
