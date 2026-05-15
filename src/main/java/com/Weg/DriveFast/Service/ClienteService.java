package com.Weg.DriveFast.Service;

import com.Weg.DriveFast.Dto.Create.ClienteCreateDTO;
import com.Weg.DriveFast.Dto.Response.ClienteResponseDTO;
import com.Weg.DriveFast.Dto.Update.ClienteUpdateDTO;
import com.Weg.DriveFast.Mapper.ClienteMapper;
import com.Weg.DriveFast.Model.Cliente;
import com.Weg.DriveFast.Projection.ClienteGastoProjection;
import com.Weg.DriveFast.Repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }


    // SALVAR CLIENTE
    public ClienteResponseDTO salvar(ClienteCreateDTO dto) {
        Cliente cliente = ClienteMapper.toEntity(dto);

        return ClienteMapper.toResponseDTO(
                clienteRepository.save(cliente)
        );
    }


    // LISTAR CLIENTES
    public List<ClienteResponseDTO> listar() {

        return clienteRepository.findAll().stream().map(ClienteMapper::toResponseDTO).toList();
    }


    // BUSCAR CLIENTE POR ID
    public ClienteResponseDTO buscarPorId(Long id) {

        return ClienteMapper.toResponseDTO(clienteRepository.findById(id).get());
    }


    // ATUALIZAR CLIENTE
    public ClienteResponseDTO atualizar(Long id, ClienteUpdateDTO dto) {

        Cliente cliente = clienteRepository.findById(id).get();

        cliente.setNome(dto.getNome());
        cliente.setEmail(dto.getEmail());

        return ClienteMapper.toResponseDTO(
                clienteRepository.save(cliente)
        );
    }


    // DELETAR CLIENTE
    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }


    // RELATORIO GASTOS
    public List<ClienteGastoProjection> relatorioGastos() {
        return clienteRepository.relatorioGastos();
    }





}
