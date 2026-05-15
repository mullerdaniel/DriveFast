package com.Weg.DriveFast.Controller;

import com.Weg.DriveFast.Dto.Create.VeiculoCreateDTO;
import com.Weg.DriveFast.Dto.MensagemDTO;
import com.Weg.DriveFast.Dto.Response.VeiculoResponseDTO;
import com.Weg.DriveFast.Dto.Update.VeiculoUpdateDTO;
import com.Weg.DriveFast.Service.VeiculoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    private final VeiculoService veiculoService;

    public VeiculoController(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }


    @PostMapping
    public ResponseEntity<VeiculoResponseDTO> salvar(
            @RequestBody VeiculoCreateDTO dto
            ) {
        return ResponseEntity.ok(veiculoService.salvar(dto));
    }


    @GetMapping
    public ResponseEntity<List<VeiculoResponseDTO>> listar() {
        return ResponseEntity.ok(veiculoService.listar());
    }


    @GetMapping("/disponiveis")
    public ResponseEntity<List<VeiculoResponseDTO>> listarDisponiveis() {
        return ResponseEntity.ok(veiculoService.listarDisponiveis());
    }


    @PutMapping("/{id}")
    public ResponseEntity<VeiculoResponseDTO> atualizar(
            @PathVariable Long id,
            @RequestBody VeiculoUpdateDTO dto
            ) {
        return ResponseEntity.ok(veiculoService.atualizar(id, dto));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<MensagemDTO> deletar(
            @PathVariable Long id
    ) {
        veiculoService.deletar(id);

        return ResponseEntity.ok(new MensagemDTO("Veiculo removido com sucesso!"));
    }
}
