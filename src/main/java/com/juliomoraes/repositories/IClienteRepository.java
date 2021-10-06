package com.juliomoraes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.juliomoraes.entities.Cliente;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente, Integer> {
	
	@Query("from Cliente m where m.email = :param")
	Cliente findByEmail(@Param("param") String email);
	
	@Query("from Cliente m where m.email = :paramEmail and m.senha = :paramSenha")
	Cliente findByEmailAndSenha(@Param("paramEmail") String email, @Param("paramSenha") String senha);
	
	@Query("from Cliente c where c.cpf = :param")
	Cliente findByCpf(@Param("param") String cpf);
}
