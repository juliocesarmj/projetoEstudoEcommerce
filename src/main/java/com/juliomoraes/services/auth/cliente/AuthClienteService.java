package com.juliomoraes.services.auth.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juliomoraes.dtos.auth.AuthGetDTO;
import com.juliomoraes.dtos.auth.AuthPostDTO;
import com.juliomoraes.dtos.clientes.ClienteGetDTO;
import com.juliomoraes.entities.Cliente;
import com.juliomoraes.repositories.IClienteRepository;
import com.juliomoraes.security.Cryptograhy;
import com.juliomoraes.security.JwtToken;

@Service
public class AuthClienteService implements IAuthClienteService {
	
	@Autowired
	private IClienteRepository repository;
	
	@Override
	public AuthGetDTO autenticar(AuthPostDTO dto) {
		
		try {
			
			Cliente cliente = this.repository.findByEmailAndSenha(dto.getEmail(),
					Cryptograhy.criptografar(dto.getSenha()));
			
			if(cliente == null) {
				//TODO NAO AUTORIZADO- CLIENTE N ENCONTRADO
			}
			
			AuthGetDTO result = new AuthGetDTO();
			
			result.setAcessToken(JwtToken.generatedToken(cliente.getEmail()));
			result.setCliente(new ClienteGetDTO());
			
			result.getCliente().setIdCliente(cliente.getIdCliente());
			result.getCliente().setNome(cliente.getNome());
			result.getCliente().setEmail(cliente.getEmail());
			result.getCliente().setCpf(cliente.getCpf());
			result.getCliente().setTelefone(cliente.getTelefone());
			result.getCliente().setLogradouro(cliente.getEndereco().getLogradouro());
			result.getCliente().setNumero(cliente.getEndereco().getNumero());
			result.getCliente().setComplemento(cliente.getEndereco().getComplemento());
			result.getCliente().setBairro(cliente.getEndereco().getBairro());
			result.getCliente().setCidade(cliente.getEndereco().getCidade());
			result.getCliente().setEstado(cliente.getEndereco().getEstado());
			result.getCliente().setCep(cliente.getEndereco().getCep());
			
			return result;
			
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

}
