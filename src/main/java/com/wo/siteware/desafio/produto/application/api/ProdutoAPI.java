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

    @PostMapping("/promo/{idPromo}")
    @ResponseStatus(code = HttpStatus.CREATED)
    ProdutoResponse postProdutoPromo(@PathVariable UUID idPromo,
            @Valid @RequestBody ProdutoRequestPromo produto);

    @GetMapping()
    @ResponseStatus(code = HttpStatus.OK)
    List<ProdutoListResponse> buscaProdutos();

    @GetMapping(value = "/{idProduto}")
    @ResponseStatus(code = HttpStatus.OK)
    ProdutoDetalhadoResponse buscaProdutoPeloId(@PathVariable UUID idProduto);

    @PatchMapping(value = "/{idProduto}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void atualizaProduto(@PathVariable UUID idProduto,
                         @RequestBody ProdutoEditRequest produto);

    @DeleteMapping(value = "/{idProduto}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deletaProduto(@PathVariable UUID idProduto);

}
