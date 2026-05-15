package com.Weg.DriveFast.Dto.Create;

import com.Weg.DriveFast.Model.Cliente;
import com.Weg.DriveFast.Model.Veiculo;

import java.math.BigDecimal;

public class LocacaoCreateDTO {

    private Long clienteId;
    private Long veiculoId;
    private Integer dias;
    private BigDecimal valorTotal;
    private Cliente cliente;
    private Veiculo veiculo;

    public Integer getDias() {
        return dias;
    }

    public void setDias(Integer dias) {
        this.dias = dias;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public Long getVeiculoId() {
        return veiculoId;
    }

    public void setVeiculoId(Long veiculoId) {
        this.veiculoId = veiculoId;
    }
}
