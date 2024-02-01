package com.wo.siteware.desafio.promocao.application.api;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/produto/promocao")
public interface PromoAPI {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    PromoResponse postPromo(@Valid @RequestBody PromoRequest promoRequest);

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<PromocaoListResponse> getPromocoes();

    @GetMapping(value = "/{idPromo}")
    @ResponseStatus(code = HttpStatus.OK)
    PromocaoProdutoDetalhado getPromoComId(@PathVariable UUID idPromocao);

    @DeleteMapping(value = "/{idPromo}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deletaPromocao(@PathVariable UUID idPromo);

    @PutMapping(value = "/{idPromo}")
    @ResponseStatus(code = HttpStatus.OK)
    PromocaoEditRequest editaPromo(@PathVariable UUID idPromo,
                                   @Valid @RequestBody PromocaoEditRequest editaPromocaoRequest);

}
