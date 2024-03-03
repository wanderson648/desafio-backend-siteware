package com.wo.siteware.desafio.produto.application.api;

import com.wo.siteware.desafio.produto.application.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Log4j2
public class ProdutoController implements ProdutoAPI {

    private final ProdutoService produtoService;

    @Override
    public ProdutoResponse postProduto(ProdutoRequest produtoRequest) {
        return produtoService.criaProduto(produtoRequest);
    }

    @Override
    public List<ProdutoListResponse> buscaProdutos() {
        return produtoService.buscaProdutos();
    }

    @Override
    public void deletarUmProdutoPorId(UUID idProduto) {
        produtoService.deletaUmProdutoPorId(idProduto);
    }

    @Override
    public void alterarUmProduto(UUID idProduto, ProdutoEditaRequest produtoRequest) {
        produtoService.alteraUmProduto(idProduto, produtoRequest);
    }

}
