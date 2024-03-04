package com.wo.siteware.desafio.cliente.application.api;

import com.wo.siteware.desafio.cliente.domain.Cliente;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public record ClienteListResponse(UUID idCliente, String nome, String cpf) {
    public static List<ClienteListResponse> converte(List<Cliente> clientes) {
        return clientes.stream()
                .map(ClienteListResponse::new)
                .collect(Collectors.toList());
    }

    public ClienteListResponse(Cliente cliente) {
        this(cliente.getIdCliente(), cliente.getNomeCompleto(), cliente.getCpf());
    }
}
