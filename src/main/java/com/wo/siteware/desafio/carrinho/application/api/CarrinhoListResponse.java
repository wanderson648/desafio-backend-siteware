package com.wo.siteware.desafio.carrinho.application.api;

import com.wo.siteware.desafio.carrinho.domain.Carrinho;

import java.util.List;
import java.util.stream.Collectors;

public record CarrinhoListResponse(String item, int quantidade, double preco, String promocao, double total) {
    public static List<CarrinhoListResponse> convert(List<Carrinho> carrinhos) {
        return carrinhos.stream().map(car -> new CarrinhoListResponse(
                car.getProduto().getNome(),
                car.getQuantidade(),
                car.getProduto().getPreco(),
                car.getProduto().getPromoId().getDescricao(),
                car.getTotal()
        )).collect(Collectors.toList());
    }
}
