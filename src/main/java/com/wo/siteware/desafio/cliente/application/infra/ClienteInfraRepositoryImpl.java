package com.wo.siteware.desafio.cliente.application.infra;

import com.wo.siteware.desafio.cliente.application.repository.ClienteRepository;
import com.wo.siteware.desafio.cliente.domain.Cliente;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ClienteInfraRepositoryImpl implements ClienteRepository {

    private final ClienteJpaRepository clienteJpaRepository;
    @Override
    public Cliente salvaCliente(Cliente cliente) {
        return clienteJpaRepository.save(cliente);
    }

    @Override
    public List<Cliente> buscaTodosClientes() {
        return clienteJpaRepository.findAll();
    }
}
