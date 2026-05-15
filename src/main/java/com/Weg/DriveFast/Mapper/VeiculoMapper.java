package com.Weg.DriveFast.Mapper;

import com.Weg.DriveFast.Dto.Create.VeiculoCreateDTO;
import com.Weg.DriveFast.Dto.Response.VeiculoResponseDTO;
import com.Weg.DriveFast.Model.Veiculo;

public class VeiculoMapper {

    public static Veiculo toEntity(VeiculoCreateDTO dto) {

        Veiculo veiculo = new Veiculo();

        veiculo.setMarca(dto.marca());
        veiculo.setModelo(dto.modelo());
        veiculo.setPlaca(dto.placa());
        veiculo.setValorDiaria(dto.valorDiaria());

        return veiculo;
    }

    public static VeiculoResponseDTO toResponseDTO(Veiculo veiculo) {

        return new VeiculoResponseDTO(
                veiculo.getId(),
                veiculo.getMarca(),
                veiculo.getModelo(),
                veiculo.getPlaca(),
                veiculo.getValorDiaria(),
                veiculo.getDisponivel()
        );
    }
}
