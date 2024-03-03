package com.wo.siteware.desafio.produto.application.service;

import com.wo.siteware.desafio.produto.application.api.ProdutoEditaRequest;
import com.wo.siteware.desafio.produto.application.api.ProdutoListResponse;
import com.wo.siteware.desafio.produto.application.api.ProdutoRequest;
import com.wo.siteware.desafio.produto.application.api.ProdutoResponse;
import com.wo.siteware.desafio.produto.application.repository.ProdutoRepository;
import com.wo.siteware.desafio.produto.domain.Produto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Log4j2
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository produtoRepository;

    @Override
    public ProdutoResponse criaProduto(ProdutoRequest produtoRequest) {
        Produto produto = produtoRepository.salva(new Produto(produtoRequest));
        return new ProdutoResponse(produto);
    }

    @Override
    public List<ProdutoListResponse> buscaProdutos() {
        List<Produto> produtos = produtoRepository.buscaProdutos();
        return ProdutoListResponse.convert(produtos);
    }

    @Override
    public void deletaUmProdutoPorId(UUID idProduto) {
        Produto produto = produtoRepository.buscarUmProdutoPorId(idProduto);
        produtoRepository.deletarUmProduto(produto);
    }

    @Override
    public void alteraUmProduto(UUID idProduto, ProdutoEditaRequest produtoRequest) {
        Produto produto = produtoRepository.buscarUmProdutoPorId(idProduto);
        produto.alterar(produtoRequest);
        produtoRepository.salva(produto);
    }




}
