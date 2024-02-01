package com.wo.siteware.desafio.promocao.application.api;

import com.wo.siteware.desafio.promocao.domain.Promocao;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
public class PromocaoProdutoDetalhado {
    UUID idPromo;
    String nome;
    String descricao;

    public PromocaoProdutoDetalhado(Promocao promocao) {
        this.idPromo = promocao.getIdPromo();
        this.nome = promocao.getNome();
        this.descricao = promocao.getDescricao();
    }
}
