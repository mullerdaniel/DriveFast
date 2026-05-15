package com.Weg.DriveFast.Mapper;

import com.Weg.DriveFast.Dto.Create.ClienteCreateDTO;
import com.Weg.DriveFast.Dto.Response.ClienteResponseDTO;
import com.Weg.DriveFast.Model.Cliente;

public class ClienteMapper {

    public static Cliente toEntity(ClienteCreateDTO dto) {

        Cliente cliente = new Cliente();

        cliente.setNome(dto.getNome());
        cliente.setCnh(dto.getCnh());
        cliente.setEmail(dto.getEmail());

        return cliente;
    }

    public static ClienteResponseDTO toResponseDTO(Cliente cliente) {

        ClienteResponseDTO dto = new ClienteResponseDTO();

        dto.setId(cliente.getId());
        dto.setNome(cliente.getNome());
        dto.setCnh(cliente.getCnh());
        dto.setEmail(cliente.getEmail());

        return dto;
    }
}