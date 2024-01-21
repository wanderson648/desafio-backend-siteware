package com.wo.siteware.desafio.produtos.application.repository;

import com.wo.siteware.desafio.produtos.application.api.ProdutoDetalhadoResponse;
import com.wo.siteware.desafio.produtos.domain.Produto;

import java.util.List;
import java.util.UUID;

public interface ProdutoRepository {
    Produto salva(Produto produto);
    List<Produto> buscaTodosOsProdutos();
    Produto buscaProdutoPorId(UUID idProduto);
    void deleteProduto(Produto produto);
}
