package com.wo.siteware.desafio.carrinho.application.infra;

import com.wo.siteware.desafio.carrinho.application.repository.CarrinhoRepository;
import com.wo.siteware.desafio.carrinho.domain.Carrinho;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class CarrinhoRepositoryImpl implements CarrinhoRepository {

    private final CarrinhoSpringJpaRepository carrinhoSpringJpaRepository;

    @Override
    public Carrinho salvarCarrinho(Carrinho carrinho) {
        return carrinhoSpringJpaRepository.save(carrinho);
    }

    @Override
    public Carrinho buscarCarrinhoPorId(UUID idCarrinho) {
        return carrinhoSpringJpaRepository.findById(idCarrinho)
                .orElseThrow(() -> new RuntimeException("Carrinho não encontrado!"));
    }
}
