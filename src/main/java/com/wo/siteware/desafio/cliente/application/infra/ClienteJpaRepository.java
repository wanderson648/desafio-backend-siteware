package com.wo.siteware.desafio.cliente.application.infra;

import com.wo.siteware.desafio.cliente.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClienteJpaRepository extends JpaRepository<Cliente, UUID> {
}
