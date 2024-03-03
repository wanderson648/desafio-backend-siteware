package com.wo.siteware.desafio.carrinho.application.api;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wo.siteware.desafio.carrinho.domain.Carrinho;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public record CarrinhoResponse(UUID idCarrinho, @JsonIgnore List<ItemCarrinhoResponse>
        itens, LocalDate dataDaCriacao) {
    public CarrinhoResponse(Carrinho carrinho) {
        this(carrinho.getIdCarrinho(), ItemCarrinhoResponse.convert(carrinho.getItens()),
                carrinho.getDataHoraCadastroNoCarrinho());
    }
}
