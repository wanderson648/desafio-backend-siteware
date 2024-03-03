package com.wo.siteware.desafio.cliente.application.api;

import com.wo.siteware.desafio.cliente.application.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ClienteController implements ClienteAPI {
    private final ClienteService clienteService;
    @Override
    public ClienteResponse criarCliente(ClienteRequest clienteRequest) {
        return clienteService.salvaCliente(clienteRequest);
    }

    @Override
    public List<ClienteListResponse> listarClientes() {
        return clienteService.listaTodosClientes();
    }
}
