package com.wo.siteware.desafio.cliente.application.repository;

import com.wo.siteware.desafio.cliente.domain.Cliente;

import java.util.List;

public interface ClienteRepository {
    Cliente salvaCliente(Cliente cliente);

    List<Cliente> buscaTodosClientes();
}
