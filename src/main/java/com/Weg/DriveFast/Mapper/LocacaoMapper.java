package com.Weg.DriveFast.Mapper;

import com.Weg.DriveFast.Dto.Create.LocacaoCreateDTO;
import com.Weg.DriveFast.Dto.Response.ClienteResponseDTO;
import com.Weg.DriveFast.Dto.Response.LocacaoResponseDTO;
import com.Weg.DriveFast.Model.Locacao;

public class LocacaoMapper {

    public static Locacao toEntity(LocacaoCreateDTO dto) {

        Locacao locacao = new Locacao();

        locacao.setDias(dto.getDias());
        locacao.setValorTotal(dto.getValorTotal());
        locacao.setCliente(dto.getCliente());
        locacao.setVeiculo(dto.getVeiculo());

        return locacao;
    }

    public static LocacaoResponseDTO toResponseDTO(Locacao locacao) {

        LocacaoResponseDTO dto = new LocacaoResponseDTO();

        dto.setId(locacao.getId());
        dto.setDias(locacao.getDias());
        dto.setValorTotal(locacao.getValorTotal());
        dto.setCliente(locacao.getCliente());
        dto.setVeiculo(locacao.getVeiculo());

        return dto;
    }
}
