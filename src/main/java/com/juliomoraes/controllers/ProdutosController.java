package com.juliomoraes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juliomoraes.repositories.IProdutoRepository;

@RestController
@RequestMapping("/api/produtos")
public class ProdutosController {
	
	@Autowired
	private IProdutoRepository repository;
	
	@CrossOrigin
	@GetMapping
	public ResponseEntity<String> getAll() {
		return null;
	}
	
	@CrossOrigin
	@GetMapping(value = "/{id}")
	public ResponseEntity<String> getById(@PathVariable Integer id) {
		return null;
	}

}
