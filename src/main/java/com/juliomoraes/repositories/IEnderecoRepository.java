package com.juliomoraes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.juliomoraes.entities.Endereco;

@Repository
public interface IEnderecoRepository extends JpaRepository<Endereco, Integer> {

}
