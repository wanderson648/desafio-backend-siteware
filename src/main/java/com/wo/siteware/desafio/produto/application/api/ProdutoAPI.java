package com.wo.siteware.desafio.produto.application.api;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/produto")
public interface ProdutoAPI {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    ProdutoResponse postProduto(@Valid @RequestBody ProdutoRequest produto);
    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<ProdutoListResponse> buscaProdutos();

    @DeleteMapping(path = "/{idProduto}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deletarUmProdutoPorId(@PathVariable UUID idProduto);

    @PatchMapping(path = "/{idProduto}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void alterarUmProduto(@PathVariable UUID idProduto, @RequestBody @Valid ProdutoEditaRequest produtoRequest);

}
