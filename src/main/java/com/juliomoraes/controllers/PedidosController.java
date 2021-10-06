package com.juliomoraes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juliomoraes.repositories.IPedidoRepository;

@RestController
@RequestMapping(value = "/api/pedidos")
public class PedidosController {
	
	@Autowired
	private IPedidoRepository repository;
	
	@CrossOrigin
	@PostMapping
	public ResponseEntity<String> post() {
		return null;
	}
	
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
