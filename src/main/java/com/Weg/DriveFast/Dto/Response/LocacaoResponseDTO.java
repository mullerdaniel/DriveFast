package com.Weg.DriveFast.Dto.Response;

import com.Weg.DriveFast.Model.Cliente;
import com.Weg.DriveFast.Model.Veiculo;

import java.math.BigDecimal;

public class LocacaoResponseDTO {

    private Long id;
    private Integer dias;
    private BigDecimal valorTotal;
    private Cliente cliente;
    private Veiculo veiculo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
}
