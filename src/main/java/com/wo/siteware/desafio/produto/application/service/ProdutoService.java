package com.wo.siteware.desafio.produto.application.service;


import com.wo.siteware.desafio.produto.application.api.*;
import com.wo.siteware.desafio.produto.domain.Produto;

import java.util.List;


public interface ProdutoService {
    Produto criaProduto(ProdutoRequestPromo produtoRequest);
    List<ProdutoListResponse> buscaProdutos();
    Produto criaProdutoPromo(ProdutoRequest produto);
}
