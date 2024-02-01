package com.wo.siteware.desafio.promocao.application.api;

import com.wo.siteware.desafio.promocao.domain.Promocao;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public record PromocaoListResponse(UUID idPromo, String nome, String descricao) {
    public static List<PromocaoListResponse> convert(List<Promocao> promocoes) {
        return promocoes.stream().map(promo -> new PromocaoListResponse(
                promo.getIdPromo(),
                promo.getNome(),
                promo.getDescricao()
        )).collect(Collectors.toList());
    }
}
