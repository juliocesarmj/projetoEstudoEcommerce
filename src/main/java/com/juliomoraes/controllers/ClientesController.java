package com.juliomoraes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juliomoraes.dtos.clientes.ClientePostDTO;
import com.juliomoraes.repositories.IClienteRepository;

@RestController
@RequestMapping("/api/clientes")
public class ClientesController {
	
	@Autowired
	private IClienteRepository repository;
	
	@CrossOrigin
	@PostMapping
	public ResponseEntity<String> post(@RequestBody ClientePostDTO dto) {
		return null;
	}
	
	@CrossOrigin
	@PutMapping(value = "/{id}")
	public ResponseEntity<String> put(@PathVariable Integer id) {
		return null;
	}
	
	@CrossOrigin
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id) {
		return null;
	}
	
	@CrossOrigin
	@GetMapping(value = "/{id}")
	public ResponseEntity<String> getId(@PathVariable Integer id) {
		return null;
	}
}
