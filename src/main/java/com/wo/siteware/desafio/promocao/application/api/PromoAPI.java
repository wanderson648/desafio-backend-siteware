package com.wo.siteware.desafio.promocao.application.api;

import com.wo.siteware.desafio.promocao.domain.Promocao;
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
    Promocao postPromo(@Valid @RequestBody PromoRequest promoRequest);

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<PromocaoListResponse> getPromocoes();

    @GetMapping("/{idPromo}")
    @ResponseStatus(code = HttpStatus.OK)
    Promocao getPromoComId(String idPromo);

//    @DeleteMapping(value = "/{idPromo}")
//    @ResponseStatus(code = HttpStatus.NO_CONTENT)
//    void deletaPromocao(@PathVariable UUID idPromo);
//
//    @PutMapping(value = "/{idPromo}")
//    @ResponseStatus(code = HttpStatus.OK)
//    PromocaoEditRequest editaPromo(@PathVariable UUID idPromo,
//                                   @Valid @RequestBody PromocaoEditRequest editaPromocaoRequest);

}
