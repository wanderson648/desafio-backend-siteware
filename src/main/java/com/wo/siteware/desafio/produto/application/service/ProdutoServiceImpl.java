package com.wo.siteware.desafio.produto.application.service;

import com.wo.siteware.desafio.produto.application.api.*;
import com.wo.siteware.desafio.produto.application.repository.ProdutoRepository;
import com.wo.siteware.desafio.produto.domain.Produto;
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
        return new ProdutoResponse(produto.getIdProduto());
    }
    @Override
    public ProdutoResponse criaProdutoPromo(UUID idPromo, ProdutoRequestPromo produto) {
        Produto produtoPromo = produtoRepository.salva(new Produto(idPromo, produto));
        return new ProdutoResponse(produtoPromo.getIdProduto());
    }
    @Override
    public List<ProdutoListResponse> buscaProdutos() {
        List<Produto> produtos = produtoRepository.buscaProdutos();
        return ProdutoListResponse.convert(produtos);
    }

    @Override
    public void deletaProduto(UUID idProduto) {
        Produto produto = produtoRepository.buscaProdutoPorId(idProduto);
        produtoRepository.deleteProduto(produto);
    }

    @Override
    public void atualizaProduto(UUID idProduto, ProdutoEditRequest produto) {
        Produto novoProduto = produtoRepository.buscaProdutoPorId(idProduto);
        novoProduto.atualizaProduto(produto);
        produtoRepository.salva(novoProduto);
    }

    @Override
    public ProdutoDetalhadoResponse buscaProdutoPeloId(UUID idProduto) {
        Produto produto = produtoRepository.buscaProdutoPorId(idProduto);
        return new ProdutoDetalhadoResponse(produto);
    }


}
