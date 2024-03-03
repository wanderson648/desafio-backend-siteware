package com.wo.siteware.desafio.carrinho.application.api;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/v1/carrinho")
public interface CarrinhoAPI {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    CarrinhoResponse criarCarrinho(@RequestBody @Valid CarrinhoRequest carrinhoRequest);

    @PostMapping(path = "/{idCarrinho}/item")
    @ResponseStatus(code = HttpStatus.CREATED)
    void adicionarItemCarrinho(@PathVariable UUID idCarrinho, @RequestBody @Valid ItemCarrinhoRequest itemCarrinhoRequest);

    @GetMapping(path = "/{idCarrinho}/item")
    @ResponseStatus(code = HttpStatus.OK)
    CarrinhoListResponse listarItensDoCarrinho(@PathVariable UUID idCarrinho);

}
