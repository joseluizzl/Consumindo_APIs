package br.org.serratec.eletronicos.model;

import java.util.ArrayList;
import java.util.List;

import br.org.serratec.eletronicos.dto.PedidosDto;
import br.org.serratec.eletronicos.dto.ProdutosDto;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedidos")
public class Pedidos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
    private String cpf;
	private Double valorFinal;
	@Enumerated(EnumType.STRING)
	private Pagamento pagamento;
	
	
	public Pedidos() {}
	
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
	private List<Produtos> produtos;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Double getValorFinal() {
		return valorFinal;
	}

	public void setValorFinal(Double valorFinal) {
		this.valorFinal = valorFinal;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	public List<Produtos> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<ProdutosDto> produtosDto) {
		List<Produtos> produtosEntity = new ArrayList<Produtos>();
		produtosDto.forEach(pDto -> {
			Produtos produtos = pDto.toEntity();
			produtos.setPedidos(this);
			produtosEntity.add(produtos);
		});
		this.produtos = produtosEntity;
		
	}
	
	public Pedidos(Long id, 
            String nome, 
            String cpf,
            Double valorFinal, 
            Pagamento pagamento,
            List<ProdutosDto> produtos) {
        super();
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.valorFinal = valorFinal;
        setProdutos(produtos);
    }
	
	public PedidosDto toDto() {
        List<ProdutosDto> produtosDto = new ArrayList<ProdutosDto>();
        this.produtos.forEach(produtoEntity -> {
            ProdutosDto produto = produtoEntity.toDto();
            produtosDto.add(produtos);
        });
        return new PedidosDto(
                this.id, 
                this.nome, 
                this.cpf,
                this.valorFinal, 
                this.pagamento,
                produtosDto
               );
    }
	
	
	
	
}
