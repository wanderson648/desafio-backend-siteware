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
    public CarrinhoResponse criaCarrinho(CarrinhoRequest carrinhoRequest) {
        return carrinhoService.salvarCarrinho(carrinhoRequest);
    }

    @Override
    public void adicionaItemCarrinho(UUID idCarrinho, ItemCarrinhoRequest itemCarrinhoRequest) {
        carrinhoService.adicionarItemAoCarrinho(idCarrinho, itemCarrinhoRequest);
    }

    @Override
    public CarrinhoListResponse listaItensDoCarrinho(UUID idCarrinho) {
        return carrinhoService.listarItensDoCarrinho(idCarrinho);
    }

    @Override
    public void alteraItensDoCarrinho(UUID idCarrinho, UUID idItemCarrinho, ItemEditaCarrinhoRequest itemEditaCarrinhoRequest) {
        carrinhoService.alterarCarrinho(idCarrinho, idItemCarrinho, itemEditaCarrinhoRequest);
    }

    @Override
    public void removeItensDoCarrinho(UUID idCarrinho, UUID idItemCarrinho) {
        carrinhoService.removerItensDoCarrinho(idCarrinho, idItemCarrinho);
    }
}

