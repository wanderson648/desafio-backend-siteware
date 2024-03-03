package com.wo.siteware.desafio.carrinho.application.api;

import com.wo.siteware.desafio.carrinho.application.service.CarrinhoService;
import com.wo.siteware.desafio.carrinho.domain.Carrinho;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Log4j2
public class CarrinhoController implements CarrinhoAPI {

    private final CarrinhoService carrinhoService;

    @Override
    public CarrinhoResponse criarCarrinho(CarrinhoRequest carrinhoRequest) {
        log.info("[inicia] CarrinhoRestController - criarCarrinho");
        CarrinhoResponse carrinho = carrinhoService.salvarCarrinho(carrinhoRequest);
        log.info("[finaliza] CarrinhoRestController - criarCarrinho");
        return carrinho;
    }

    @Override
    public void adicionarItemCarrinho(UUID idCarrinho, ItemCarrinhoRequest itemCarrinhoRequest) {
        carrinhoService.adicionarItemAoCarrinho(idCarrinho, itemCarrinhoRequest);
    }

    @Override
    public CarrinhoListResponse listarItensDoCarrinho(UUID idCarrinho) {
        return carrinhoService.listarItensDoCarrinho(idCarrinho);
    }
}

