package com.wo.siteware.desafio.promocao.application.api;

import lombok.Builder;

import java.util.UUID;

@Builder
public record PromoResponse(UUID idPromo) {
}
