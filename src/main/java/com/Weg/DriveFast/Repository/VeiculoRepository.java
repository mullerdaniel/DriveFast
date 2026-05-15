package com.Weg.DriveFast.Repository;

import com.Weg.DriveFast.Model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

    List<Veiculo> findByDisponivel(Boolean disponivel);

}
