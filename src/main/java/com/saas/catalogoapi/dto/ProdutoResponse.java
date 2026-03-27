package com.saas.catalogoapi.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ProdutoResponse(
        Long id,
        String nome,
        String descricao,
        BigDecimal preco,
        Boolean ativo,
        LocalDateTime criadoEm
) {
}
