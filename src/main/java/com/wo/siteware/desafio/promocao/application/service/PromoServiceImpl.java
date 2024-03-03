package com.wo.siteware.desafio.promocao.application.service;

import com.wo.siteware.desafio.produto.domain.Produto;
import com.wo.siteware.desafio.promocao.domain.TipoPromocao;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class PromoServiceImpl implements PromoService {

    @Override
    public BigDecimal aplicarPromocao(Integer quantidade, BigDecimal preco, Produto produto) {
        TipoPromocao tipoPromocao = produto.getPromocao();

        if (tipoPromocao == TipoPromocao.LEVE_DOIS_PAGUE_UM) {
            return calcularLeveDoisPagueUm(quantidade, preco);
        } else if (tipoPromocao == TipoPromocao.TRES_POR_DEZ) {
            return calcularTresPorDez(quantidade, preco);
        } else return calcularSemPromocao(quantidade, preco);
    }

    private static BigDecimal calcularLeveDoisPagueUm(Integer quantidade, BigDecimal preco) {
        if (quantidade == 2) {
            int conjuntosDeDois = quantidade / 2;
            int resto = 0;
            return BigDecimal.valueOf((conjuntosDeDois + resto) * preco.doubleValue());
        }
        return calcularSemPromocao(quantidade, preco);
    }

    private static BigDecimal calcularTresPorDez(Integer quantidade, BigDecimal preco) {
        if (quantidade == 3) {
            int conjuntosDeTres = quantidade / 3;
            int resto = 0;
            return BigDecimal.valueOf(conjuntosDeTres * 10L)
                    .add(BigDecimal.valueOf(resto).multiply(preco));
        }
        return calcularSemPromocao(quantidade, preco);
    }

    private static BigDecimal calcularSemPromocao(Integer quantidade, BigDecimal preco) {
        return preco.multiply(BigDecimal.valueOf(quantidade));
    }
}
