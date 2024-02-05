package com.wo.siteware.desafio.produto.application.api;

import com.wo.siteware.desafio.produto.application.service.ProdutoService;
import com.wo.siteware.desafio.produto.domain.Produto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProdutoController implements ProdutoAPI {

    private final ProdutoService produtoService;
    @Override
    public Produto postProdutoPromo(ProdutoRequestPromo produto) {
        return produtoService.criaProduto(produto);
    }

    @Override
    public Produto postProduto(ProdutoRequest produto) {
        return produtoService.criaProdutoPromo(produto);
    }

    @Override
    public List<ProdutoListResponse> buscaProdutos() {
        return produtoService.buscaProdutos();
    }

}
