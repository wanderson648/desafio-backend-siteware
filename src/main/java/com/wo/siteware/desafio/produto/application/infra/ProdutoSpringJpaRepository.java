package com.wo.siteware.desafio.produto.application.infra;

import com.wo.siteware.desafio.produto.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProdutoSpringJpaRepository extends JpaRepository<Produto, UUID> {
}
