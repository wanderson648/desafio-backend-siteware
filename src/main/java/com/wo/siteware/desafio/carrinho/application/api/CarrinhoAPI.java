package com.wo.siteware.desafio.carrinho.application.api;

import com.wo.siteware.desafio.carrinho.domain.Carrinho;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/carrinho")
public interface CarrinhoAPI {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    Carrinho postCarrinho(@Valid @RequestBody CarrinhoRequest produtoCarrinho);

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<CarrinhoListResponse> listaProdutosDoCarrinho();

}
