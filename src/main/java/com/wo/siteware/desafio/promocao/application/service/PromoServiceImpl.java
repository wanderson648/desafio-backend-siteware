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
    public PromoResponse criaPromo(PromoRequest promoRequest) {;
        Promocao promocao = promoRepository.salvaPromo(new Promocao(promoRequest));
        return new PromoResponse(promocao.getIdPromo());
    }

    @Override
    public PromocaoProdutoDetalhado buscaPromoComId(UUID idPromo) {
        Promocao promocao = promoRepository.buscaPromoComId(idPromo);
        return new PromocaoProdutoDetalhado(promocao);
    }

    @Override
    public void deletaPromoPeloId(UUID idPromo) {
        promoRepository.deletaPromoPeloId(idPromo);
    }

    @Override
    public PromocaoEditRequest editaPromocao(UUID idPromo, PromocaoEditRequest promoEditRequest) {
        Promocao promocao = new Promocao();
        promocao.editaPromo(promoEditRequest);
        promoRepository.salvaPromo(promocao);
        return new PromocaoEditRequest(promocao.getNome(), promocao.getDescricao());
    }

    @Override
    public List<PromocaoListResponse> buscaPromocoes() {
        List<Promocao> promocoes = promoRepository.buscaPromocoes();
        return PromocaoListResponse.convert(promocoes);
    }
}
