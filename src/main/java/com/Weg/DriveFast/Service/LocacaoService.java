package com.Weg.DriveFast.Service;

import com.Weg.DriveFast.Dto.Create.LocacaoCreateDTO;
import com.Weg.DriveFast.Dto.Response.LocacaoResponseDTO;
import com.Weg.DriveFast.Mapper.LocacaoMapper;
import com.Weg.DriveFast.Model.Cliente;
import com.Weg.DriveFast.Model.Locacao;
import com.Weg.DriveFast.Model.Veiculo;
import com.Weg.DriveFast.Repository.ClienteRepository;
import com.Weg.DriveFast.Repository.LocacaoRepository;
import com.Weg.DriveFast.Repository.VeiculoRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class LocacaoService {

    private final LocacaoRepository locacaoRepository;
    private final ClienteRepository clienteRepository;
    private final VeiculoRepository veiculoRepository;

    public LocacaoService(LocacaoRepository locacaoRepository, ClienteRepository clienteRepository, VeiculoRepository veiculoRepository) {
        this.clienteRepository = clienteRepository;
        this.veiculoRepository = veiculoRepository;
        this.locacaoRepository = locacaoRepository;
    }

    public LocacaoResponseDTO salvar(LocacaoCreateDTO dto) {
        Cliente cliente = clienteRepository.findById(dto.getClienteId()).get();

        Veiculo veiculo = veiculoRepository.findById(dto.getVeiculoId()).get();

        BigDecimal valorTotal = veiculo.getValorDiaria().multiply(BigDecimal.valueOf(dto.getDias()));

        if(dto.getDias() > 7) {
            valorTotal = valorTotal.multiply(BigDecimal.valueOf(0.9));
        }

        Locacao locacao = new Locacao();

        locacao.setCliente(cliente);
        locacao.setVeiculo(veiculo);
        locacao.setDias(dto.getDias());
        locacao.setValorTotal(valorTotal);

        veiculo.setDisponivel(false);

        veiculoRepository.save(veiculo);

        return LocacaoMapper.toResponseDTO(locacaoRepository.save(locacao));
    }


    // LISTA
    public List<LocacaoResponseDTO> listar() {

        return locacaoRepository.findAll().stream().map(LocacaoMapper::toResponseDTO).toList();
    }


    // LISTAR POR CLIENTE
    public List<LocacaoResponseDTO> listarPorCliente(Long clienteId) {

        return locacaoRepository.buscarPorCliente(clienteId).stream().map(LocacaoMapper::toResponseDTO).toList();
    }


    // DEVOLVER
    public void devolver (Long id) {
        Locacao locacao = locacaoRepository.findById(id).get();
        Veiculo veiculo = locacao.getVeiculo();
        veiculo.setDisponivel(true);
        veiculoRepository.save(veiculo);
        locacaoRepository.delete(locacao);
    }
}
