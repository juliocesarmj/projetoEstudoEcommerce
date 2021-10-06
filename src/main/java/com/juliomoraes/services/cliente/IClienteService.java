package com.juliomoraes.services.cliente;

import com.juliomoraes.dtos.clientes.ClienteGetDTO;
import com.juliomoraes.dtos.clientes.ClientePostDTO;
import com.juliomoraes.dtos.clientes.ClientePutDTO;

public interface IClienteService {
	
	Boolean cadastrar(ClientePostDTO dto);
	
	Boolean alterar(Integer id, ClientePutDTO dto);
	
	Boolean excluir(Integer id);
	
	ClienteGetDTO consultar(Integer id);
}
