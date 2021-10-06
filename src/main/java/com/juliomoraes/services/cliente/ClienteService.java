package com.juliomoraes.services.cliente;

import org.springframework.beans.factory.annotation.Autowired;

import com.juliomoraes.dtos.clientes.ClienteGetDTO;
import com.juliomoraes.dtos.clientes.ClientePostDTO;
import com.juliomoraes.dtos.clientes.ClientePutDTO;
import com.juliomoraes.entities.Cliente;
import com.juliomoraes.entities.Endereco;
import com.juliomoraes.repositories.IClienteRepository;
import com.juliomoraes.security.Cryptograhy;

public class ClienteService implements IClienteService {
	
	@Autowired
	private IClienteRepository repository;
	
	
	@Override
	public Boolean cadastrar(ClientePostDTO dto) {
		
		try {
			
			if(this.repository.findByEmail(dto.getEmail()) != null) {
				//EXCEPTION EMAIL INFORMADO JÁ EXISTE 400
				return false;
			}
			if(this.repository.findByCpf(dto.getCpf()) != null) {
				//exception cpf informado já existe 400
				return false;
			}
			Cliente cliente = new Cliente();
			cliente.setNome(dto.getNome());
			cliente.setEmail(dto.getEmail());
			cliente.setCpf(dto.getCpf());
			cliente.setTelefone(dto.getTelefone());
			cliente.setSenha(Cryptograhy.criptografar(dto.getSenha()));
			
			cliente.setEndereco(new Endereco());
			cliente.getEndereco().setLogradouro(dto.getLogradouro());
			cliente.getEndereco().setNumero(dto.getNumero());
			cliente.getEndereco().setComplemento(dto.getComplemento());
			cliente.getEndereco().setBairro(dto.getBairro());
			cliente.getEndereco().setCidade(dto.getCidade());
			cliente.getEndereco().setEstado(dto.getEstado());
			cliente.getEndereco().setCep(dto.getCep());
			
			this.repository.save(cliente);
			
			return true;
		} catch (Exception e) {
			//TODO EXCEPTION
			return false;
		}
	}

	@Override
	public Boolean alterar(Integer id, ClientePutDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean excluir(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClienteGetDTO consultar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
