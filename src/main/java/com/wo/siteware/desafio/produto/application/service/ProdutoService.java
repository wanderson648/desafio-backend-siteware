package com.wo.siteware.desafio.produto.application.service;


import com.wo.siteware.desafio.produto.application.api.*;

import java.util.List;
import java.util.UUID;


public interface ProdutoService {
    ProdutoResponse criaProduto(ProdutoRequest produtoRequest);
//    List<ProdutoListResponse> buscaProdutos();
    ProdutoResponse criaProdutoPromo(UUID idPromo, ProdutoRequestPromo produto);
    List<ProdutoListResponse> buscaProdutos();
    void deletaProduto(UUID idProduto);
    void atualizaProduto(UUID idProduto, ProdutoEditRequest produto);
    ProdutoDetalhadoResponse buscaProdutoPeloId(UUID idProduto);
}
