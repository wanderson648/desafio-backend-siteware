package com.wo.siteware.desafio.carrinho.application.infra;

import com.wo.siteware.desafio.carrinho.application.repository.ItemCarrinhoRepository;
import com.wo.siteware.desafio.carrinho.domain.Carrinho;
import com.wo.siteware.desafio.carrinho.domain.ItemCarrinho;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class ItemCarrinhoInfraRepository implements ItemCarrinhoRepository {

    private final ItemCarrinhoSpringJpaRepository itemCarrinhoSpringJpaRepository;
    @Override
    public List<ItemCarrinho> acharCarrinho(Carrinho carrinho) {
        return itemCarrinhoSpringJpaRepository.findByCarrinho(carrinho);
    }

    @Override
    public ItemCarrinho buscarItemCarrinhoPeloId(UUID idItemCarrinho) {
        return itemCarrinhoSpringJpaRepository.findById(idItemCarrinho)
                .orElseThrow(() -> new RuntimeException("Item Carrinho não encontrado!"));
    }

    @Override
    public void deletarItemCarrinho(ItemCarrinho itemCarrinho) {
        itemCarrinhoSpringJpaRepository.delete(itemCarrinho);
    }


}
