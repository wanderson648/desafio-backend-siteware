package com.wo.siteware.desafio.produto.application.api;

import com.wo.siteware.desafio.produto.application.service.ProdutoService;
import com.wo.siteware.desafio.produto.domain.Produto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Log4j2
public class ProdutoController implements ProdutoAPI {

    private final ProdutoService produtoService;

    @Override
    public ProdutoResponse postProduto(ProdutoRequest produtoRequest) {
        log.info("[inicia] ProdutoRestController - postProduto");
        ProdutoResponse produto = produtoService.criaProduto(produtoRequest);
        log.info("[finaliza] ProdutoRestController - postProduto");
        return produto;
    }

    @Override
    public List<ProdutoListResponse> buscaProdutos() {
        return produtoService.buscaProdutos();
    }

}
