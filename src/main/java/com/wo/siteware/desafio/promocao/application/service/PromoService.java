package com.wo.siteware.desafio.promocao.application.service;

import com.wo.siteware.desafio.promocao.application.api.PromoRequest;
import com.wo.siteware.desafio.promocao.application.api.PromocaoListResponse;
import com.wo.siteware.desafio.promocao.domain.Promocao;

import java.util.List;

public interface PromoService {
    Promocao criaPromo(PromoRequest promoRequest);
    Promocao buscaPromoComId(String idPromo);
    List<PromocaoListResponse> getPromocoes();
//    void deletaPromoPeloId(UUID idPromo);
//    PromocaoEditRequest editaPromocao(UUID idPromo, PromocaoEditRequest produtoEditRequest);
//    List<PromocaoListResponse> buscaPromocoes();
}
