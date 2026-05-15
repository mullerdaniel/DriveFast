package com.Weg.DriveFast.Controller;

import com.Weg.DriveFast.Dto.Create.ClienteCreateDTO;
import com.Weg.DriveFast.Dto.MensagemDTO;
import com.Weg.DriveFast.Dto.Response.ClienteResponseDTO;
import com.Weg.DriveFast.Dto.Update.ClienteUpdateDTO;
import com.Weg.DriveFast.Projection.ClienteGastoProjection;
import com.Weg.DriveFast.Service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }


    @PostMapping
    public ResponseEntity<ClienteResponseDTO> salvar(
            @RequestBody ClienteCreateDTO dto
            ) {
        return ResponseEntity.ok(clienteService.salvar(dto));
    }


    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> buscarPorId(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(clienteService.buscarPorId(id));
    }


    @PutMapping
    public ResponseEntity<ClienteResponseDTO> atualizar(
            @PathVariable Long id,
            @RequestBody ClienteUpdateDTO dto
            ) {
        return ResponseEntity.ok(clienteService.atualizar(id, dto));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<MensagemDTO> deletar(
            @PathVariable Long id
    ) {
        clienteService.deletar(id);

        return ResponseEntity.ok(new MensagemDTO("Cliente removido com sucesso!"));
    }


    @GetMapping("/relatorios-gastos")
    public ResponseEntity<List<ClienteGastoProjection>> relatorio() {
        return ResponseEntity.ok(clienteService.relatorioGastos());
    }
}
