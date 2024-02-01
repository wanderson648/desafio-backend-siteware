package com.wo.siteware.desafio.produto.application.repository;

import com.wo.siteware.desafio.produto.domain.Produto;

import java.util.List;
import java.util.UUID;

public interface ProdutoRepository {
    Produto salva(Produto produto);
    List<Produto> buscaProdutos();
    Produto buscaProdutoPorId(UUID idProduto);
    void deleteProduto(Produto produto);
}