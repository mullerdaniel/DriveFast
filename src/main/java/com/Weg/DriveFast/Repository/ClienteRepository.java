package com.Weg.DriveFast.Repository;

import com.Weg.DriveFast.Model.Cliente;
import com.Weg.DriveFast.Projection.ClienteGastoProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query(value = """
        SELECT c.nome AS nomeCliente,
               SUM(l.valor_total) AS totalGasto
        FROM cliente c
        JOIN locacao l ON l.cliente_id = c.id
        GROUP BY c.nome
        """, nativeQuery = true)
    List<ClienteGastoProjection> relatorioGastos();

}
