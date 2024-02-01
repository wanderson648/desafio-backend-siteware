package com.wo.siteware.desafio.promocao.application.infra;

import com.wo.siteware.desafio.promocao.domain.Promocao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PromoSpringJpaRepository extends JpaRepository<Promocao, UUID> {
}
