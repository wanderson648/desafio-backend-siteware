package com.wo.siteware.desafio.produto.application.infra;

import com.wo.siteware.desafio.produto.application.repository.ProdutoRepository;
import com.wo.siteware.desafio.produto.domain.Produto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class ProdutoRepositoryImpl implements ProdutoRepository {

    private final ProdutoSpringJpaRepository produtoSpringJpaRepository;
    @Override
    public Produto salva(Produto produto) {
        return produtoSpringJpaRepository.save(produto);
    }

    @Override
    public List<Produto> buscaProdutos() {
        return produtoSpringJpaRepository.findAll();
    }

}
