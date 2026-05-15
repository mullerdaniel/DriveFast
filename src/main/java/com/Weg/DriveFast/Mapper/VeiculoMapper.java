package com.Weg.DriveFast.Mapper;

import com.Weg.DriveFast.Dto.Create.VeiculoCreateDTO;
import com.Weg.DriveFast.Dto.Response.VeiculoResponseDTO;
import com.Weg.DriveFast.Dto.Update.VeiculoUpdateDTO;
import com.Weg.DriveFast.Model.Veiculo;

public class VeiculoMapper {

    public static Veiculo toEntity(VeiculoCreateDTO dto) {

        Veiculo veiculo = new Veiculo();

        veiculo.setMarca(dto.getMarca());
        veiculo.setModelo(dto.getModelo());
        veiculo.setPlaca(dto.getPlaca());
        veiculo.setValorDiaria(dto.getValorDiaria());
        veiculo.setDisponivel(dto.getDisponivel());

        return veiculo;
    }

    public static VeiculoResponseDTO toResponseDTO(Veiculo veiculo) {

        VeiculoResponseDTO dto = new VeiculoResponseDTO();

        dto.setId(veiculo.getId());
        dto.setMarca(veiculo.getMarca());
        dto.setPlaca(veiculo.getPlaca());
        dto.setPlaca(veiculo.getPlaca());
        dto.setValorDiaria(veiculo.getValorDiaria());
        dto.setDisponivel(veiculo.getDisponivel());

        return dto;
    }
}
