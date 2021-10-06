package com.juliomoraes.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer idPedido;
	
	@Column(nullable = false, unique = true)
	private String codPedido;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date dataPedido;
	
	@Column(nullable = false)
	private Double valor;
	
	@ManyToOne
	@JoinColumn(name = "idCliente", nullable = false)
	private Cliente cliente;
	
	@ManyToMany
	//cria uma terceira tabela de nome item pedido e acossia as 2 ids(pedido,produto) como FK
	@JoinTable(
			name = "item_pedido",
			joinColumns = @JoinColumn(name = "idPedido", nullable = false),
			inverseJoinColumns = @JoinColumn(name = "idProduto", nullable = false)
			)
	private List<Produto> produtos;
	
	public Pedido() {
	}

	public Pedido(Integer idPedido, String codPedido, Date dataPedido, Double valor, Cliente cliente) {
		super();
		this.idPedido = idPedido;
		this.codPedido = codPedido;
		this.dataPedido = dataPedido;
		this.valor = valor;
		this.cliente = cliente;
	}

	public Integer getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}

	public String getCodPedido() {
		return codPedido;
	}

	public void setCodPedido(String codPedido) {
		this.codPedido = codPedido;
	}

	public Date getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Pedido [idPedido=" + idPedido + ", codPedido=" + codPedido + ", dataPedido=" + dataPedido + ", valor="
				+ valor + "]";
	}
}
