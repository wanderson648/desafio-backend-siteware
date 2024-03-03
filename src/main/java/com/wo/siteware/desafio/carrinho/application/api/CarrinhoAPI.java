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
    CarrinhoResponse criaCarrinho(@RequestBody @Valid CarrinhoRequest carrinhoRequest);

    @PostMapping(path = "/{idCarrinho}/item")
    @ResponseStatus(code = HttpStatus.CREATED)
    void adicionaItemCarrinho(@PathVariable UUID idCarrinho, @RequestBody @Valid ItemCarrinhoRequest itemCarrinhoRequest);

    @GetMapping(path = "/{idCarrinho}/item")
    @ResponseStatus(code = HttpStatus.OK)
    CarrinhoListResponse listaItensDoCarrinho(@PathVariable UUID idCarrinho);


    @PatchMapping(path = "/{idCarrinho}/item/{idItemCarrinho}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)

    void alteraItensDoCarrinho(@PathVariable UUID idCarrinho, @PathVariable UUID idItemCarrinho,
                               @RequestBody @Valid ItemEditaCarrinhoRequest itemEditaCarrinhoRequest);

    @DeleteMapping(path = "/{idCarrinho}/item/{idItemCarrinho}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void removeItensDoCarrinho(@PathVariable UUID idCarrinho, @PathVariable UUID idItemCarrinho);
}
