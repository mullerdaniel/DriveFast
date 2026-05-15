package com.Weg.DriveFast.Dto.Create;

public record LocacaoCreateDTO(
        Long clienteId,
        Long veiculoId,
        Integer dias
) {
}