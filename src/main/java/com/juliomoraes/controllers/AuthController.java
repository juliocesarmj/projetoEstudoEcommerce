package com.juliomoraes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juliomoraes.dtos.auth.AuthGetDTO;
import com.juliomoraes.dtos.auth.AuthPostDTO;
import com.juliomoraes.services.auth.cliente.IAuthClienteService;

@RestController
@RequestMapping(value = "/api/auth")
public class AuthController {
	
	@Autowired
	private IAuthClienteService service;
	
	@CrossOrigin
	@PostMapping
	public ResponseEntity<AuthGetDTO> post(@RequestBody AuthPostDTO dto) {
		return ResponseEntity.status(HttpStatus.OK).body(this.service.autenticar(dto));
	}

}
