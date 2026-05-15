package com.Weg.DriveFast.Service;

import com.Weg.DriveFast.Dto.Create.VeiculoCreateDTO;
import com.Weg.DriveFast.Dto.Response.VeiculoResponseDTO;
import com.Weg.DriveFast.Dto.Update.VeiculoUpdateDTO;
import com.Weg.DriveFast.Mapper.VeiculoMapper;
import com.Weg.DriveFast.Model.Veiculo;
import com.Weg.DriveFast.Repository.VeiculoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeiculoService {

    private final VeiculoRepository veiculoRepository;

    public VeiculoService(VeiculoRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }


    // SALVAR VEICULO
    public VeiculoResponseDTO salvar(VeiculoCreateDTO dto) {
        Veiculo veiculo = VeiculoMapper.toEntity(dto);

        return VeiculoMapper.toResponseDTO(
                veiculoRepository.save(veiculo)
        );
    }


    // LISTAR VEICULOS
    public List<VeiculoResponseDTO> listar() {

        return veiculoRepository.findAll().stream().map(VeiculoMapper::toResponseDTO).toList();
    }


    // BUSCAR VEICULOS POR ID
    public VeiculoResponseDTO buscarPorId(Long id) {

        return VeiculoMapper.toResponseDTO(veiculoRepository.findById(id).get());
    }


    // ATUALIZAR VEICULO
    public VeiculoResponseDTO atualizar (Long id, VeiculoUpdateDTO dto) {

        Veiculo veiculo = veiculoRepository.findById(id).get();

        veiculo.setValorDiaria(dto.getValorDiaria());

        return VeiculoMapper.toResponseDTO(
                veiculoRepository.save(veiculo)
        );
    }


    public List<VeiculoResponseDTO> listarDisponiveis() {

        return veiculoRepository.findByDisponivel(true)
                .stream()
                .map(VeiculoMapper::toResponseDTO)
                .toList();
    }


    // DELETAR VEICULO
    public void deletar(Long id) {
        veiculoRepository.deleteById(id);
    }



}

