package br.org.serratec.eletronicos.model;

import br.org.serratec.eletronicos.dto.ProdutosDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "produtos")
public class Produtos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomeProduto;
	private int quantidade;
	private Double preco;
	
	public Produtos() {}
	
	@ManyToOne
	private Pedidos pedido;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	public Pedidos getPedidos() {
		return pedido;
	}

	public void setPedidos(Pedidos pedido) {
		this.pedido = pedido;
	}

	public Produtos(Long id, String nomeProduto, int quantidade, Double preco) {
		super();
		this.id = id;
		this.nomeProduto = nomeProduto;
		this.quantidade = quantidade;
		this.preco = preco;
	}

	public ProdutosDto toDto() {
		
		return new ProdutosDto(
				this.id,
				this.nomeProduto,
				this.quantidade,
				this.preco
		);
	}
	
	
}
