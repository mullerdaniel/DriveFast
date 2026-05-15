package com.Weg.DriveFast.Mapper;


import com.Weg.DriveFast.Dto.Response.LocacaoResponseDTO;
import com.Weg.DriveFast.Model.Locacao;

public class LocacaoMapper {

    public static LocacaoResponseDTO toResponseDTO(Locacao locacao) {

        return new LocacaoResponseDTO(
                locacao.getId(),
                locacao.getDias(),
                locacao.getValorTotal(),
                locacao.getCliente().getNome(),
                locacao.getVeiculo().getModelo()
        );
    }
}