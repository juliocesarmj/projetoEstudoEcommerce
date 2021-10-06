package com.juliomoraes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juliomoraes.repositories.IClienteRepository;

@RestController
@RequestMapping(value = "/api/auth")
public class AuthController {
	
	@Autowired
	private IClienteRepository repository;
	
	@CrossOrigin
	@PostMapping
	public ResponseEntity<String> post() {
		return null;
	}

}
