package com.juliomoraes.services.auth.cliente;

import com.juliomoraes.dtos.auth.AuthGetDTO;
import com.juliomoraes.dtos.auth.AuthPostDTO;

public interface IAuthClienteService {
	
	AuthGetDTO autenticar(AuthPostDTO dto);
}
