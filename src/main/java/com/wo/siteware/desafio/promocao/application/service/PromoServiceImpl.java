package com.wo.siteware.desafio.promocao.application.service;

import com.wo.siteware.desafio.promocao.application.api.*;
import com.wo.siteware.desafio.promocao.application.repository.PromoRepository;
import com.wo.siteware.desafio.promocao.domain.Promocao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PromoServiceImpl implements PromoService {

    private final PromoRepository promoRepository;

    @Override
    public Promocao criaPromo(PromoRequest promoRequest) {
        Promocao promocao = new Promocao(promoRequest);
        promoRepository.salvaPromo(promocao);
        return promocao;
    }

    @Override
    public Promocao buscaPromoComId(String idPromo) {
        Promocao promocao = promoRepository.buscaPromoComId(idPromo);
        return new Promocao(promocao);
    }

    @Override
    public List<PromocaoListResponse> getPromocoes() {
        List<Promocao> promocoes = promoRepository.getPromocoes();
        return PromocaoListResponse.convert(promocoes);
    }

}
