package com.wo.siteware.desafio.cliente.domain;

import com.wo.siteware.desafio.carrinho.domain.Carrinho;
import com.wo.siteware.desafio.cliente.application.api.ClienteRequest;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idCliente;
    @NotBlank
    private String nomeCompleto;
    @CPF
    private String cpf;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    List<Carrinho> carrinhos;
    public Cliente(ClienteRequest clienteRequest) {
        this.nomeCompleto = clienteRequest.nomeCompleto();
        this.cpf = clienteRequest.cpf();
    }
}
