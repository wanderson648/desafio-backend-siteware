package com.wo.siteware.desafio.promocao.application.repository;

import com.wo.siteware.desafio.promocao.domain.Promocao;

import java.util.List;
import java.util.UUID;

public interface PromoRepository {
    Promocao salvaPromo(Promocao promocao);

    Promocao buscaPromoComId(UUID idPromo);

    void deletaPromoPeloId(UUID idPromo);

    List<Promocao> buscaPromocoes();
}
