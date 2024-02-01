package com.wo.siteware.desafio.promocao.application.infra;

import com.wo.siteware.desafio.promocao.application.repository.PromoRepository;
import com.wo.siteware.desafio.promocao.domain.Promocao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class PromoRepositoryImpl implements PromoRepository {

    private final PromoSpringJpaRepository promoSpringJpaRepository;
    @Override
    public Promocao salvaPromo(Promocao promocao) {
        return promoSpringJpaRepository.save(promocao);
    }

    @Override
    public Promocao buscaPromoComId(UUID idPromo) {
        return promoSpringJpaRepository.findById(idPromo)
                .orElseThrow(() -> new RuntimeException("Promoção não existe"));
    }

    @Override
    public void deletaPromoPeloId(UUID idPromo) {
        promoSpringJpaRepository.findById(idPromo);
    }

    @Override
    public List<Promocao> buscaPromocoes() {
        return promoSpringJpaRepository.findAll();
    }
}
