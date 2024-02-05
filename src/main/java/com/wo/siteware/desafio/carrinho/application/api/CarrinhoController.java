package com.wo.siteware.desafio.carrinho.application.api;

import com.wo.siteware.desafio.carrinho.application.service.CarrinhoService;
import com.wo.siteware.desafio.carrinho.domain.Carrinho;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CarrinhoController implements CarrinhoAPI {

    private final CarrinhoService carrinhoService;
    @Override
    public CarrinhoResponse postCarrinho(CarrinhoRequest produtoCarrinho) {
        return carrinhoService.adicionarItemCarrinho(produtoCarrinho);
    }

    @Override
    public List<CarrinhoListResponse> listaProdutosDoCarrinho() {
        return carrinhoService.buscaItemsCarrinho();
    }
}
