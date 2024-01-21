package com.wo.siteware.desafio.produtos.application.service;

import com.wo.siteware.desafio.produtos.application.api.*;
import com.wo.siteware.desafio.produtos.domain.Produto;
import com.wo.siteware.desafio.produtos.application.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository produtoRepository;
    @Override
    public ProdutoResponse criaProduto(ProdutoRequest produtoRequest) {
        Produto produto = produtoRepository.salva(new Produto(produtoRequest));
        return ProdutoResponse.builder().idProduto(produto.getIdProduto()).build();
    }

    @Override
    public List<ProdutoListResponse> getProdutos() {
        List<Produto> produtos = produtoRepository.buscaTodosOsProdutos();
        return ProdutoListResponse.convert(produtos);
    }

    @Override
    public void patchEditProduto(UUID idProduto, ProdutoEditRequest produtoEditRequest) {
        Produto produto = produtoRepository.buscaProdutoPorId(idProduto);
        produto.editaProduto(produtoEditRequest);
        produtoRepository.salva(produto);
    }

    @Override
    public void deleteProduto(UUID idProduto) {
        Produto produto = produtoRepository.buscaProdutoPorId(idProduto);
        produtoRepository.deleteProduto(produto);
    }

}
