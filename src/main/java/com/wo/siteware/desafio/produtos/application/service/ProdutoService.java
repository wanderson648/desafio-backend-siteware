package com.wo.siteware.desafio.produtos.application.service;


import com.wo.siteware.desafio.produtos.application.api.*;

import java.util.List;
import java.util.UUID;


public interface ProdutoService {
    ProdutoResponse criaProduto(ProdutoRequest produtoRequest);
    List<ProdutoListResponse> getProdutos();
    void patchEditProduto(UUID idProduto, ProdutoEditRequest produtoEditRequest);
    void deleteProduto(UUID idProduto);
}
