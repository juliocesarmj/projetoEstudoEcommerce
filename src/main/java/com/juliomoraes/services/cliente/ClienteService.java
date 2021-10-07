package com.juliomoraes.services.cliente;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.juliomoraes.dtos.clientes.ClienteGetDTO;
import com.juliomoraes.dtos.clientes.ClientePostDTO;
import com.juliomoraes.dtos.clientes.ClientePutDTO;
import com.juliomoraes.entities.Cliente;
import com.juliomoraes.entities.Endereco;
import com.juliomoraes.repositories.IClienteRepository;
import com.juliomoraes.repositories.IEnderecoRepository;
import com.juliomoraes.security.Cryptograhy;

@Service
public class ClienteService implements IClienteService {
	
	
	private IClienteRepository repository;
	
	private IEnderecoRepository enderecoRepository;
	
	@Autowired
	public ClienteService(IClienteRepository repository, IEnderecoRepository enderecoRepository) {
		this.repository = repository;
		this.enderecoRepository = enderecoRepository;
	}
	
	@Transactional
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
			
			Endereco endereco = new Endereco();
			
			endereco.setLogradouro(dto.getLogradouro());
			endereco.setNumero(dto.getNumero());
			endereco.setComplemento(dto.getComplemento());
			endereco.setBairro(dto.getBairro());
			endereco.setCidade(dto.getCidade());
			endereco.setEstado(dto.getEstado());
			endereco.setCep(dto.getCep());
			
			endereco.setCliente(cliente);
			
			this.repository.save(cliente);
			this.enderecoRepository.save(endereco);
			
			return true;
		} catch (Exception e) {
			//TODO EXCEPTION
			return false;
		}
	}
	
	@Transactional
	@Override
	public Boolean alterar(Integer id, ClientePutDTO dto) {
		
		try {
			Optional<Cliente> clienteOptional = this.repository.findById(id);
			
			if(clienteOptional.isEmpty() || clienteOptional == null) {
				//exceçao cliente n encontrado
				return null;
			}
			Cliente cliente = clienteOptional.get();
			
			cliente.setNome(dto.getNome());
			cliente.setTelefone(dto.getTelefone());
			cliente.setSenha(Cryptograhy.criptografar(dto.getSenha()));
			
			cliente.getEndereco().setLogradouro(dto.getLogradouro());
			cliente.getEndereco().setNumero(dto.getNumero());
			cliente.getEndereco().setComplemento(dto.getComplemento());
			cliente.getEndereco().setBairro(dto.getBairro());
			cliente.getEndereco().setCidade(dto.getCidade());
			cliente.getEndereco().setEstado(dto.getEstado());
			cliente.getEndereco().setCep(dto.getCep());
			
			this.repository.save(cliente);
			return Boolean.TRUE;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
	@Transactional
	@Override
	public Boolean excluir(Integer id) {
		try {
			Optional<Cliente> clienteOptional = this.repository.findById(id);
			
			if(clienteOptional.isEmpty() || clienteOptional == null) {
				//exceçao cliente n encontrado
				return null;
			}
			this.repository.delete(clienteOptional.get());
				
			return Boolean.TRUE;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
	@Transactional(readOnly = true)
	@Override
	public ClienteGetDTO consultar(Integer id) {
		
		try {
			Optional<Cliente> clienteOptional = this.repository.findById(id);
			
			if(clienteOptional.isPresent()) {
				return null;
			}
			//TODO EXCEPTION CLIENTE N ENCONTRADO
			return null;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
	}

}
