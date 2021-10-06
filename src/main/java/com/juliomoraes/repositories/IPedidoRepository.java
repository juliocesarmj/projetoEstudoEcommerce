package com.juliomoraes.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.juliomoraes.entities.Pedido;

@Repository
public interface IPedidoRepository extends JpaRepository<Pedido, Integer> {
	
	@Query("from Pedido p inner join p.cliente c where c.idCliente = :pIdCliente")
	List<Pedido> findByPedidosPorCliente(@Param("pIdCliente") Integer idCliente);
}
