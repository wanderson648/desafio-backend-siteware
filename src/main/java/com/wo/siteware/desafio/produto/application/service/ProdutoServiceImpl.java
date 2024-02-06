package com.wo.siteware.desafio.produto.application.service;

import com.wo.siteware.desafio.produto.application.api.*;
import com.wo.siteware.desafio.produto.application.repository.ProdutoRepository;
import com.wo.siteware.desafio.produto.domain.Produto;
import com.wo.siteware.desafio.promocao.application.service.PromoService;
import com.wo.siteware.desafio.promocao.domain.Promocao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoServiceImpl implements ProdutoService {

    private final PromoService promoService;
    private final ProdutoRepository produtoRepository;
    @Override
    public Produto criaProduto(ProdutoRequestPromo produtoRequest) {
        Promocao promocao = promoService.buscaPromoComId(produtoRequest.promocaoId());
        Produto novoProduto =  new Produto(produtoRequest);
        novoProduto.setPromoId(promocao);
        return produtoRepository.salva(novoProduto);
    }

    @Override
    public Produto criaProdutoPromo(ProdutoRequest prodRequest) {
        Produto produto = new Produto(prodRequest);
        produtoRepository.salva(produto);
        return produto;
    }

    @Override
    public Produto buscaProdutoPeloId(String produto) {
        return produtoRepository.buscaProdutoPorId(produto);
    }

    @Override
    public List<ProdutoListResponse> buscaProdutos() {
        List<Produto> produtos = produtoRepository.buscaProdutos();
        return ProdutoListResponse.convert(produtos);
    }



}
