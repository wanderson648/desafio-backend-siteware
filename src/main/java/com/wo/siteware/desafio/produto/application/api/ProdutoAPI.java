package com.wo.siteware.desafio.produto.application.api;

import com.wo.siteware.desafio.produto.domain.Produto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/produto")
public interface ProdutoAPI {
    @PostMapping("/promo")
    @ResponseStatus(code = HttpStatus.CREATED)
    Produto postProdutoPromo(@Valid @RequestBody ProdutoRequestPromo produto);

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    Produto postProduto(@Valid @RequestBody ProdutoRequest produto);
    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<ProdutoListResponse> buscaProdutos();


}
