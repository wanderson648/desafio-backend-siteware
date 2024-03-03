package com.wo.siteware.desafio.carrinho.domain;

import com.wo.siteware.desafio.carrinho.application.api.CarrinhoRequest;
import com.wo.siteware.desafio.cliente.domain.Cliente;
import com.wo.siteware.desafio.produto.domain.Produto;
import com.wo.siteware.desafio.promocao.application.service.PromoService;
import com.wo.siteware.desafio.promocao.domain.TipoPromocao;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Carrinho {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", name = "idCarrinho", updatable = false, unique = true, nullable = false)
    private UUID idCarrinho;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    private BigDecimal total;

    @OneToMany(mappedBy = "carrinho", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemCarrinho> itens = new ArrayList<>();

    private LocalDate dataHoraCadastroNoCarrinho;
    private LocalDate dataHoraUltimaAlteracao;

    public Carrinho(CarrinhoRequest carrinhoRequest) {
        this.dataHoraCadastroNoCarrinho = LocalDate.now();
        verificaCliente(carrinhoRequest.idCliente());
    }

    public void verificaCliente(UUID idCliente){
        if (idCliente != null){
            this.cliente = new Cliente();
            cliente.setIdCliente(idCliente);
        }
    }

    public void recalculaTotal() {
        this.total = calculaTotalDosItens(this.itens);
        this.dataHoraUltimaAlteracao = LocalDate.now();
    }
    public BigDecimal calculaTotalDosItens(List<ItemCarrinho> itensDoCarrinho) {
        return itensDoCarrinho.stream()
                .map(ItemCarrinho::getPrecoTotalLiquido)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }


    public void adicionaProdutoAoCarrinho(Produto produto, int quantidade, PromoService promoService) {
        Optional<ItemCarrinho> itemExistente = encontraItemPeloIdProduto(produto.getProdutoId());

        if (itemExistente.isPresent()) {
            throw new RuntimeException("O produto ja foi adicionado ao carrinho!");
        } else {
            adicionaNovoItemCarrinho(produto, quantidade, promoService);
        }
        recalculaTotal();
    }

    private Optional<ItemCarrinho> encontraItemPeloIdProduto(UUID idProduto) {
        return itens.stream().filter(item -> {
            Produto produto = item.getProduto();
            return produto != null && produto.getProdutoId().equals(idProduto);
        }).findFirst();
    }

    private void adicionaNovoItemCarrinho(Produto produto, int quantidade, PromoService promoService) {
        PromoService promoStrategy =
                (promoService != null) ? promoService : produto.getPromocao().getPromoService();
        ItemCarrinho novoItem = criaNovoItemCarrinho(produto, quantidade, promoStrategy);
        novoItem.setCarrinho(this);
        itens.add(novoItem);
    }

    private ItemCarrinho criaNovoItemCarrinho(Produto produto, int quantidade, PromoService promoService) {
        TipoPromocao promocaoProduto = produto.getPromocao();
        BigDecimal precoComPromocao = (promoService != null)
                ? promoService.aplicarPromocao(quantidade, produto.getPreco(), produto)
                : produto.getPreco();
        BigDecimal precoBrutoSemPromocao = produto.getPreco().multiply(BigDecimal.valueOf(quantidade));

        return new ItemCarrinho(this, produto, promocaoProduto, quantidade, precoComPromocao, precoBrutoSemPromocao);
    }
    public void atualizarQuantidadeItemExistente(ItemCarrinho itemCarrinhoExistente, int novaQuantidade) {
        validaNovaQuantidade(novaQuantidade);

        itemCarrinhoExistente.setQuantidade(novaQuantidade);

        BigDecimal precoComPromocao = calculaPrecoComPromocao(itemCarrinhoExistente);
        BigDecimal precoBrutoSemPromocao = calculaPrecoBrutoSemPromocao(itemCarrinhoExistente);

        itemCarrinhoExistente.setPrecoTotalLiquido(precoComPromocao);
        itemCarrinhoExistente.setPrecoBruto(precoBrutoSemPromocao);
        recalculaTotal();
    }
    private BigDecimal calculaPrecoComPromocao(ItemCarrinho itemCarrinho) {
        PromoService promocaoStrategy = itemCarrinho.getPromocao().getPromoService();
        return promocaoStrategy.aplicarPromocao(
                itemCarrinho.getQuantidade(),
                itemCarrinho.getProduto().getPreco(),
                itemCarrinho.getProduto()
        );
    }

    private BigDecimal calculaPrecoBrutoSemPromocao(ItemCarrinho itemCarrinho) {
        return itemCarrinho.getProduto().getPreco()
                .multiply(BigDecimal.valueOf(itemCarrinho.getQuantidade()));
    }
    private void validaNovaQuantidade(int novaQuantidade) {
        if (novaQuantidade <= 0) {
            throw new RuntimeException("A quantidade deve ser maior que zero.");
        }
    }





}
