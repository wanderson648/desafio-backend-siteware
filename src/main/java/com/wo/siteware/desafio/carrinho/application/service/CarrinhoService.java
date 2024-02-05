package com.wo.siteware.desafio.carrinho.application.service;

import com.wo.siteware.desafio.carrinho.application.api.CarrinhoListResponse;
import com.wo.siteware.desafio.carrinho.application.api.CarrinhoRequest;
import com.wo.siteware.desafio.carrinho.application.api.CarrinhoResponse;

import java.util.List;

public interface CarrinhoService {
    CarrinhoResponse adicionarItemCarrinho(CarrinhoRequest produtoCarrinho);

    List<CarrinhoListResponse> buscaItemsCarrinho();
}
