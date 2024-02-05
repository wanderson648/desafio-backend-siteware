package com.wo.siteware.desafio.promocao.application.api;

import com.wo.siteware.desafio.promocao.application.service.PromoService;
import com.wo.siteware.desafio.promocao.domain.Promocao;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class PromoController implements PromoAPI {

    private final PromoService promocaoService;

    @Override
    public Promocao postPromo(PromoRequest promoRequest) {
        return promocaoService.criaPromo(promoRequest);
    }

    @Override
    public List<PromocaoListResponse> getPromocoes() {
        return promocaoService.getPromocoes();
    }

//    @Override
//    public List<PromocaoListResponse> getPromocoes() {
//        return promocaoService.buscaPromocoes();
//    }

    @Override
    public Promocao getPromoComId(String idPromocao) {
        return promocaoService.buscaPromoComId(idPromocao);
    }

//    @Override
//    public void deletaPromocao(UUID idPromo) {
//        promocaoService.deletaPromoPeloId(idPromo);
//    }
//
//    @Override
//    public PromocaoEditRequest editaPromo(UUID idPromo, PromocaoEditRequest produtoEditRequest) {
//        return promocaoService.editaPromocao(idPromo, produtoEditRequest);
//    }

}
