package br.org.serratec.restauranteOriental.model;

import br.org.serratec.restauranteOriental.dto.PedidoDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="pedido")
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String pratos;
	private String clientes;
	private Double valor;
	
	public Pedido() {}
	

	public Pedido(Long id, String pratos, String clientes, Double valor) {
		super();
		this.id = id;
		this.pratos = pratos;
		this.clientes = clientes;
		this.valor = valor;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getPratos() {
		return pratos;
	}


	public void setPratos(String pratos) {
		this.pratos = pratos;
	}


	public String getClientes() {
		return clientes;
	}


	public void setClientes(String clientes) {
		this.clientes = clientes;
	}


	public Double getValor() {
		return valor;
	}


	public void setValor(Double valor) {
		this.valor = valor;
	}


	public PedidoDto toDto() {
		return new PedidoDto(this.id, this.pratos, this.clientes, this.valor);
	}
	
}
