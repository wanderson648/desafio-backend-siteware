package com.wo.siteware.desafio.promocao.application.service;

import com.wo.siteware.desafio.produto.domain.Produto;

import java.math.BigDecimal;

public interface PromoService {
    BigDecimal aplicarPromocao(Integer quantidade, BigDecimal preco, Produto produto);
}
