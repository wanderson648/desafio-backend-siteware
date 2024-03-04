package com.wo.siteware.desafio.carrinho.domain;

import com.wo.siteware.desafio.produto.domain.Produto;
import com.wo.siteware.desafio.promocao.domain.TipoPromocao;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class ItemCarrinho {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "uuid", name = "idItemCarrinho", updatable = false, unique = true, nullable = false)
    private UUID idItemCarrinho;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    private Integer quantidade;

    @Enumerated(EnumType.STRING)
    private TipoPromocao promocao;

    private BigDecimal precoTotalLiquido;
    private BigDecimal precoBruto;

    @ManyToOne
    @JoinColumn(name = "carrinho_id")
    private Carrinho carrinho;

    public ItemCarrinho(Carrinho carrinho, Produto produto, TipoPromocao tipoPromocao,
                        int quantidade, BigDecimal precoComPromocao, BigDecimal precoBrutoSemPromocao) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.precoTotalLiquido = precoComPromocao;
        this.precoBruto = precoBrutoSemPromocao;
        this.carrinho = carrinho;
        this.promocao = tipoPromocao;
    }


}
