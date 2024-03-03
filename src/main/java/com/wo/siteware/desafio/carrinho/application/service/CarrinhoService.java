package com.wo.siteware.desafio.carrinho.application.service;

import com.wo.siteware.desafio.carrinho.application.api.*;
import com.wo.siteware.desafio.carrinho.domain.Carrinho;

import java.util.List;
import java.util.UUID;

public interface CarrinhoService {
    CarrinhoResponse salvarCarrinho(CarrinhoRequest carrinhoRequest);

    void adicionarItemAoCarrinho(UUID idCarrinho, ItemCarrinhoRequest itemCarrinhoRequest);

    CarrinhoListResponse listarItensDoCarrinho(UUID idCarrinho);

    void alterarCarrinho(UUID idCarrinho, UUID idItemCarrinho, ItemEditaCarrinhoRequest itemEditaCarrinhoRequest);

    void removerItensDoCarrinho(UUID idCarrinho, UUID idItemCarrinho);
}
