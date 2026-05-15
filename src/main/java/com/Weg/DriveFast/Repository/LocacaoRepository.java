package com.Weg.DriveFast.Repository;

import com.Weg.DriveFast.Model.Locacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LocacaoRepository extends JpaRepository<Locacao, Long> {

    @Query("SELECT l FROM Locacao l WHERE l.cliente.id = :clienteId")
    List<Locacao> buscarPorCliente(Long clienteId);
}
