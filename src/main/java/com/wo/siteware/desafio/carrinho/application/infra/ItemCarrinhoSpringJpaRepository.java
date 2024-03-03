package com.wo.siteware.desafio.carrinho.application.infra;

import com.wo.siteware.desafio.carrinho.domain.Carrinho;
import com.wo.siteware.desafio.carrinho.domain.ItemCarrinho;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ItemCarrinhoSpringJpaRepository extends JpaRepository<ItemCarrinho, UUID> {
    List<ItemCarrinho> findByCarrinho(Carrinho carrinho);
}
