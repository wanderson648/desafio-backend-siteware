package com.wo.siteware.desafio.promocao.domain;

import com.wo.siteware.desafio.promocao.application.api.PromoRequest;
import com.wo.siteware.desafio.promocao.application.api.PromocaoEditRequest;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Promocao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", updatable = false, unique = true, nullable = false)
    private UUID idPromo;
    @NotBlank
    private String nome;
    @NotBlank
    private String descricao;

    LocalDate dataHoraCadastroPromocao;

    public Promocao(PromoRequest promoRequest) {
        this.nome = promoRequest.nome();
        this.descricao = promoRequest.descricao();
        this.dataHoraCadastroPromocao = LocalDate.now();
    }

    public void editaPromo(PromocaoEditRequest promoEditRequest) {
        this.nome = promoEditRequest.nome();
        this.descricao = promoEditRequest.descricao();
        this.dataHoraCadastroPromocao = LocalDate.now();
    }
}
