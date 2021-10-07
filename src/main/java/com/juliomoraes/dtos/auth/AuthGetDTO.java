package com.juliomoraes.dtos.auth;

import com.juliomoraes.dtos.clientes.ClienteGetDTO;

public class AuthGetDTO {
	
	private String mensagem;
	private String acessToken;
	private ClienteGetDTO cliente;
	
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public String getAcessToken() {
		return acessToken;
	}
	public void setAcessToken(String acessToken) {
		this.acessToken = acessToken;
	}
	public ClienteGetDTO getCliente() {
		return cliente;
	}
	public void setCliente(ClienteGetDTO cliente) {
		this.cliente = cliente;
	}
	
	
}
