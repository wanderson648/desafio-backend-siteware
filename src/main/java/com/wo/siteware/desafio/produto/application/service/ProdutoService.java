package com.wo.siteware.desafio.produto.application.service;


import com.wo.siteware.desafio.produto.application.api.*;

import java.util.List;
import java.util.UUID;


public interface ProdutoService {
    List<ProdutoListResponse> buscaProdutos();
    ProdutoResponse criaProduto(ProdutoRequest produtoRequest);

    void deletaUmProdutoPorId(UUID idProduto);

    void alteraUmProduto(UUID idProduto, ProdutoEditaRequest produtoRequest);
}
