package com.wo.siteware.desafio.carrinho.application.repository;

import com.wo.siteware.desafio.carrinho.domain.Carrinho;

import java.util.List;
import java.util.UUID;

public interface CarrinhoRepository {
    Carrinho salvarCarrinho(Carrinho carrinho);
    Carrinho buscarCarrinhoPorId(UUID idCarrinho);
}
