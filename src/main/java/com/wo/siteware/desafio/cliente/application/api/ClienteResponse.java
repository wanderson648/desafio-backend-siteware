package com.wo.siteware.desafio.cliente.application.api;

import com.wo.siteware.desafio.cliente.domain.Cliente;

import java.util.UUID;

public record ClienteResponse(UUID idCliente) {
    public ClienteResponse(Cliente cliente) {
        this(cliente.getIdCliente());
    }
}