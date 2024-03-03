package com.wo.siteware.desafio.cliente.application.service;

import com.wo.siteware.desafio.cliente.application.api.ClienteListResponse;
import com.wo.siteware.desafio.cliente.application.api.ClienteRequest;
import com.wo.siteware.desafio.cliente.application.api.ClienteResponse;

import java.util.List;

public interface ClienteService {
    ClienteResponse salvaCliente(ClienteRequest clienteRequest);

    List<ClienteListResponse> listaTodosClientes();
}
