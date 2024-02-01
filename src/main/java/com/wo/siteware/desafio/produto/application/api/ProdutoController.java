package com.wo.siteware.desafio.produto.application.api;

import com.wo.siteware.desafio.produto.application.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class ProdutoController implements ProdutoAPI {

    private final ProdutoService produtoService;
    @Override
    public ProdutoResponse postProduto(ProdutoRequest produto) {
        return produtoService.criaProduto(produto);
    }

    @Override
    public ProdutoResponse postProdutoPromo(UUID idPromo, ProdutoRequestPromo produto) {
        return produtoService.criaProdutoPromo(idPromo, produto);
    }

    @Override
    public List<ProdutoListResponse> buscaProdutos() {
        return produtoService.buscaProdutos();
    }

    @Override
    public ProdutoDetalhadoResponse buscaProdutoPeloId(UUID idProduto) {
        return produtoService.buscaProdutoPeloId(idProduto);
    }

    @Override
    public void atualizaProduto(UUID idProduto, ProdutoEditRequest produto) {
        produtoService.atualizaProduto(idProduto, produto);
    }

    @Override
    public void deletaProduto(UUID idProduto) {
        produtoService.deletaProduto(idProduto);
    }

}
