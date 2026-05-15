package com.Weg.DriveFast.Mapper;

import com.Weg.DriveFast.Dto.Create.ClienteCreateDTO;
import com.Weg.DriveFast.Dto.Response.ClienteResponseDTO;
import com.Weg.DriveFast.Model.Cliente;

public class ClienteMapper {

    public static Cliente toEntity(ClienteCreateDTO dto) {

        Cliente cliente = new Cliente();

        cliente.setNome(dto.nome());
        cliente.setCnh(dto.cnh());
        cliente.setEmail(dto.email());

        return cliente;
    }

    public static ClienteResponseDTO toResponseDTO(Cliente cliente) {
        return new ClienteResponseDTO(
                cliente.getId(),
                cliente.getNome(),
                cliente.getCnh(),
                cliente.getEmail()
        );
    }
}