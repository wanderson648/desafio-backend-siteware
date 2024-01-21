package com.wo.siteware.desafio.produtos.application.infra;

import com.wo.siteware.desafio.produtos.application.repository.ProdutoRepository;
import com.wo.siteware.desafio.produtos.domain.Produto;
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
    public List<Produto> buscaTodosOsProdutos() {
        return produtoSpringJpaRepository.findAll();
    }

    @Override
    public Produto buscaProdutoPorId(UUID idProduto) {
        return produtoSpringJpaRepository.findById(idProduto)
                .orElseThrow(()-> new RuntimeException("Produto não encotrado"));
    }

    @Override
    public void deleteProduto(Produto produto) {
        produtoSpringJpaRepository.delete(produto);
    }
}
