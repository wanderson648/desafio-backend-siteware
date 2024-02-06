package com.wo.siteware.desafio.carrinho.application.service;

import com.wo.siteware.desafio.carrinho.application.api.CarrinhoListResponse;
import com.wo.siteware.desafio.carrinho.application.api.CarrinhoRequest;
import com.wo.siteware.desafio.carrinho.domain.Carrinho;

import java.util.List;

public interface CarrinhoService {
    Carrinho adicionarItemCarrinho(CarrinhoRequest produtoCarrinho);
    List<CarrinhoListResponse> buscaItemsCarrinho();
}
