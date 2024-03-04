package com.wo.siteware.desafio.promocao.domain;

import com.wo.siteware.desafio.promocao.application.service.PromoService;
import com.wo.siteware.desafio.promocao.application.service.PromoServiceImpl;
import lombok.Getter;

@Getter
public enum TipoPromocao {
    LEVE_DOIS_PAGUE_UM("Leve 2 e Pague 1", new PromoServiceImpl()),
    TRES_POR_DEZ("3 por R$10", new PromoServiceImpl()),
    SEM_PROMOCAO("Produto sem promocao", new PromoServiceImpl());

    TipoPromocao(String descricao, PromoService promoService) {
        this.descricao = descricao;
        this.promoService = promoService;
    }

    private final String descricao;
    private final PromoService promoService;
}
