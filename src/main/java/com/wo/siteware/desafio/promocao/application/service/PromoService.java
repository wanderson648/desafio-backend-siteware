package com.wo.siteware.desafio.promocao.application.service;

import com.wo.siteware.desafio.promocao.application.api.*;

import java.util.List;
import java.util.UUID;

public interface PromoService {
    PromoResponse criaPromo(PromoRequest promoRequest);
    PromocaoProdutoDetalhado buscaPromoComId(UUID idPromo);
    void deletaPromoPeloId(UUID idPromo);
    PromocaoEditRequest editaPromocao(UUID idPromo, PromocaoEditRequest produtoEditRequest);
    List<PromocaoListResponse> buscaPromocoes();
}
