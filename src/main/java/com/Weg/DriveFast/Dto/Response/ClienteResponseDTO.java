package com.Weg.DriveFast.Dto.Response;

public record ClienteResponseDTO(
        Long id,
        String nome,
        String cnh,
        String email
) {
}