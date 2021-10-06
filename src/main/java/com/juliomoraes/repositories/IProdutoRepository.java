package com.juliomoraes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.juliomoraes.entities.Produto;

@Repository
public interface IProdutoRepository extends JpaRepository<Produto, Integer>{

}
