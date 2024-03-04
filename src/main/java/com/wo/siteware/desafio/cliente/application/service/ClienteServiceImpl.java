package com.wo.siteware.desafio.cliente.application.service;

import com.wo.siteware.desafio.cliente.application.api.ClienteListResponse;
import com.wo.siteware.desafio.cliente.application.api.ClienteRequest;
import com.wo.siteware.desafio.cliente.application.api.ClienteResponse;
import com.wo.siteware.desafio.cliente.application.repository.ClienteRepository;
import com.wo.siteware.desafio.cliente.domain.Cliente;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {
    private final ClienteRepository clienteRepository;

    @Override
    public ClienteResponse salvaCliente(ClienteRequest clienteRequest) {
        Cliente cliente = clienteRepository.salvaCliente(new Cliente(clienteRequest));
        return new ClienteResponse(cliente);
    }

    @Override
    public List<ClienteListResponse> listaTodosClientes() {
        List<Cliente> clientes = clienteRepository.buscaTodosClientes();
        return ClienteListResponse.converte(clientes);
    }
}
