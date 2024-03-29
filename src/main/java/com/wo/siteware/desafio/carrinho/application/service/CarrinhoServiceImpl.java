package com.wo.siteware.desafio.carrinho.application.service;

import com.wo.siteware.desafio.carrinho.application.api.*;
import com.wo.siteware.desafio.carrinho.application.repository.CarrinhoRepository;
import com.wo.siteware.desafio.carrinho.application.repository.ItemCarrinhoRepository;
import com.wo.siteware.desafio.carrinho.domain.Carrinho;
import com.wo.siteware.desafio.carrinho.domain.ItemCarrinho;
import com.wo.siteware.desafio.produto.application.repository.ProdutoRepository;
import com.wo.siteware.desafio.promocao.application.service.PromoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CarrinhoServiceImpl implements CarrinhoService {

    private final PromoService promoService;
    private final ProdutoRepository produtoRepository;
    private final CarrinhoRepository carrinhoRepository;
    private final ItemCarrinhoRepository itemCarrinhoRepository;

    @Override
    public CarrinhoResponse salvarCarrinho(CarrinhoRequest carrinhoRequest) {
        var carrinho = new Carrinho(carrinhoRequest);
        carrinhoRepository.salvarCarrinho(carrinho);
        return new CarrinhoResponse(carrinho);
    }

    @Override
    public void adicionarItemAoCarrinho(UUID idCarrinho, ItemCarrinhoRequest itemCarrinhoRequest) {
        var produto = produtoRepository.buscarUmProdutoPorId(itemCarrinhoRequest.idProduto());
        var carrinho = carrinhoRepository.buscarCarrinhoPorId(idCarrinho);
        carrinho.adicionaProdutoAoCarrinho(produto, itemCarrinhoRequest.quantidade(), promoService);
        carrinhoRepository.salvarCarrinho(carrinho);
    }

    @Override
    public CarrinhoListResponse listarItensDoCarrinho(UUID idCarrinho) {
        Carrinho carrinho = carrinhoRepository.buscarCarrinhoPorId(idCarrinho);
        List<ItemCarrinho> itensDoCarrinho = itemCarrinhoRepository.acharCarrinho(carrinho);
        BigDecimal totalDoCarrinho = carrinho.calculaTotalDosItens(itensDoCarrinho);
        List<ItemCarrinhoResponse> listaItensDoCarrinho = ItemCarrinhoResponse.convert(itensDoCarrinho);
        return new CarrinhoListResponse(listaItensDoCarrinho, totalDoCarrinho);
    }

    @Override
    public void alterarCarrinho(UUID idCarrinho, UUID idItemCarrinho, ItemEditaCarrinhoRequest itemEditaCarrinhoRequest) {
        var carrinho = carrinhoRepository.buscarCarrinhoPorId(idCarrinho);
        var itemCarrinho = itemCarrinhoRepository.buscarItemCarrinhoPeloId(idItemCarrinho);
        carrinho.atualizarQuantidadeItemExistente(itemCarrinho, itemEditaCarrinhoRequest.quantidade());
        carrinhoRepository.salvarCarrinho(carrinho);
    }

    @Override
    public void removerItensDoCarrinho(UUID idCarrinho, UUID idItemCarrinho) {
        var carrinho = carrinhoRepository.buscarCarrinhoPorId(idCarrinho);
        var itemCarrinho = itemCarrinhoRepository.buscarItemCarrinhoPeloId(idItemCarrinho);
        carrinho.removeItemDoCarrinho(itemCarrinho);
        itemCarrinhoRepository.deletarItemCarrinho(itemCarrinho);
        carrinho.recalculaTotal();
    }
}
