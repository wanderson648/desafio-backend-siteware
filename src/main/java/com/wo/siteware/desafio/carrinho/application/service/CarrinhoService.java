package com.wo.siteware.desafio.carrinho.application.service;

import com.wo.siteware.desafio.carrinho.application.api.CarrinhoListResponse;
import com.wo.siteware.desafio.carrinho.application.api.CarrinhoRequest;
import com.wo.siteware.desafio.carrinho.application.api.CarrinhoResponse;
import com.wo.siteware.desafio.carrinho.application.api.ItemCarrinhoRequest;
import com.wo.siteware.desafio.carrinho.domain.Carrinho;

import java.util.List;
import java.util.UUID;

public interface CarrinhoService {
    CarrinhoResponse salvarCarrinho(CarrinhoRequest carrinhoRequest);

    void adicionarItemAoCarrinho(UUID idCarrinho, ItemCarrinhoRequest itemCarrinhoRequest);

    CarrinhoListResponse listarItensDoCarrinho(UUID idCarrinho);
}
