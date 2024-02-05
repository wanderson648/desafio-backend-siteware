package com.wo.siteware.desafio.carrinho.application.service;

import com.wo.siteware.desafio.carrinho.application.api.CarrinhoListResponse;
import com.wo.siteware.desafio.carrinho.application.api.CarrinhoRequest;
import com.wo.siteware.desafio.carrinho.application.api.CarrinhoResponse;
import com.wo.siteware.desafio.carrinho.application.repository.CarrinhoRepository;
import com.wo.siteware.desafio.carrinho.domain.Carrinho;
import com.wo.siteware.desafio.produto.application.service.ProdutoService;
import com.wo.siteware.desafio.produto.domain.Produto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarrinhoServiceImpl implements CarrinhoService {

    private final ProdutoService produtoService;
    private final CarrinhoRepository carrinhoRepository;
    @Override
    public CarrinhoResponse adicionarItemCarrinho(CarrinhoRequest produtoCarrinho) {
//        Produto produto = this.produtoService.buscaProdutoPeloId(produtoCarrinho.produtoId());
//        Carrinho carrinho = new Carrinho(produtoCarrinho);
//        carrinho.setProduto(produto);
//        return carrinhoRepository.salvaItemCarrinho(carrinho);
        return null;
    }

    @Override
    public List<CarrinhoListResponse> buscaItemsCarrinho() {
        List<Carrinho> carrinhos = carrinhoRepository.buscaItems();
        return CarrinhoListResponse.convert(carrinhos);
    }
}
