package com.Weg.DriveFast.Dto.Create;

import java.math.BigDecimal;

public record VeiculoCreateDTO(
        String marca,
        String modelo,
        String placa,
        BigDecimal valorDiaria
) {
}