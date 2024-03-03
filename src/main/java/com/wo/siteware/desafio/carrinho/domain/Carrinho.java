package com.wo.siteware.desafio.carrinho.domain;

import com.wo.siteware.desafio.carrinho.application.api.CarrinhoRequest;
import com.wo.siteware.desafio.produto.domain.Produto;
import com.wo.siteware.desafio.promocao.application.service.PromoService;
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

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idProduto")
    private Produto produto;

    private Integer quantidade;
    private BigDecimal total;

    @OneToMany(mappedBy = "carrinho", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemCarrinho> itens = new ArrayList<>();

    private LocalDate dataHoraCadastroNoCarrinho;
    private LocalDate dataHoraUltimaAlteracao;

    public Carrinho(CarrinhoRequest carrinhoRequest) {
        this.dataHoraCadastroNoCarrinho = LocalDate.now();
    }

    public void recalcularTotal() {
        this.total = calcularTotalDosItens(this.itens);
        this.dataHoraUltimaAlteracao = LocalDate.now();
    }
    public BigDecimal calcularTotalDosItens(List<ItemCarrinho> itensDoCarrinho) {
        return itensDoCarrinho.stream()
                .map(ItemCarrinho::getPrecoTotalLiquido)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }


    public void adicionarProdutoAoCarrinho(Produto produto, int quantidade, PromoService promoService) {
        Optional<ItemCarrinho> itemExistente = encontrarItemPeloIdProduto(produto.getProdutoId());

        if (itemExistente.isPresent()) {
            throw new RuntimeException("O produto ja foi adicionado ao carrinho!");
        }
        recalcularTotal();
    }

    private Optional<ItemCarrinho> encontrarItemPeloIdProduto(UUID idProduto) {
        return itens.stream().filter(item -> {
            Produto produto = item.getProduto();
            return produto != null && produto.getProdutoId().equals(idProduto);
        }).findFirst();
    }


}
