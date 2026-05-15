package com.Weg.DriveFast.Dto.Response;

import java.math.BigDecimal;

public record LocacaoResponseDTO(
        Long id,
        Integer dias,
        BigDecimal valorTotal,
        String nomeCliente,
        String modeloVeiculo
) {
}