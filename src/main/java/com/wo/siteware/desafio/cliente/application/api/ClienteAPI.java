package com.wo.siteware.desafio.cliente.application.api;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/cliente")
public interface ClienteAPI {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    ClienteResponse criarCliente(@RequestBody @Valid ClienteRequest clienteRequest);

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<ClienteListResponse> listarClientes();
}
