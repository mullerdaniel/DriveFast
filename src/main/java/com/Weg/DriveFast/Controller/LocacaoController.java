package com.Weg.DriveFast.Controller;

import com.Weg.DriveFast.Dto.Create.LocacaoCreateDTO;
import com.Weg.DriveFast.Dto.MensagemDTO;
import com.Weg.DriveFast.Dto.Response.LocacaoResponseDTO;
import com.Weg.DriveFast.Service.LocacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locacoes")
public class LocacaoController {

    private final LocacaoService locacaoService;

    public LocacaoController(LocacaoService locacaoService) {
        this.locacaoService = locacaoService;
    }


    @PostMapping
    public ResponseEntity<LocacaoResponseDTO> salvar(
            @RequestBody LocacaoCreateDTO dto
            ) {
        return ResponseEntity.ok(locacaoService.salvar(dto));
    }


    @GetMapping
    public ResponseEntity<List<LocacaoResponseDTO>> listar() {
        return ResponseEntity.ok(locacaoService.listar());
    }


    @GetMapping("/cliente{clienteId}")
    public ResponseEntity<List<LocacaoResponseDTO>> listarPorCliente(
            @PathVariable Long clienteId
    ) {
        return ResponseEntity.ok(locacaoService.listarPorCliente(clienteId));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<MensagemDTO> devolver(
            @PathVariable Long id
    ) {
        locacaoService.devolver(id);

        return ResponseEntity.ok(new MensagemDTO("Veiculo devolvido a locação encerrada!"));
    }
}
