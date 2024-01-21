package com.wo.siteware.desafio.produtos.application.api;

import com.wo.siteware.desafio.produtos.application.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class ProdutoController implements ProdutoAPI {

    private final ProdutoService produtoService;
    @Override
    public ProdutoResponse postProduto(ProdutoRequest produtoRequest) {
        return produtoService.criaProduto(produtoRequest);
    }
    @Override
    public List<ProdutoListResponse> getProdutos() {
        return produtoService.getProdutos();
    }

    @Override
    public void patchEditProduto(UUID idProduto, ProdutoEditRequest produtoEditRequest) {
        produtoService.patchEditProduto(idProduto, produtoEditRequest);
    }

    @Override
    public void deleteProduto(UUID idProduto) {
        produtoService.deleteProduto(idProduto);
    }
}
