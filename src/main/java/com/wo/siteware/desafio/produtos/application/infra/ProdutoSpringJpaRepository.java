package com.wo.siteware.desafio.produtos.application.infra;

import com.wo.siteware.desafio.produtos.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProdutoSpringJpaRepository extends JpaRepository<Produto, UUID> {
}
