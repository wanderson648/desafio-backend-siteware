package com.wo.siteware.desafio.produtos.application.api;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("v1/produto")
public interface ProdutoAPI {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    ProdutoResponse postProduto(@Valid @RequestBody ProdutoRequest produtoRequest);

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<ProdutoListResponse> getProdutos();

    @PatchMapping(value = "/{idProduto}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void patchEditProduto(@PathVariable UUID idProduto,
                      @Valid @RequestBody ProdutoEditRequest produtoEditRequest);

    @DeleteMapping(value = "/{idProduto}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deleteProduto(@PathVariable UUID idProduto);
}
