package br.org.serratec.restauranteOriental.dto;

import br.org.serratec.restauranteOriental.model.Pedido;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PedidoDto(
		 Long id,
		 @NotBlank(message="O campo 'pratos' não pode ser vazio!")
		 String pratos,
		 @NotBlank(message="O campo 'clientes' não pode ser vazio!")
		 String clientes,
		 @NotNull(message="O campo 'valor' não pode ser vazio!")
		 Double valor
		){

	public Pedido toEntity() {
		return new Pedido(this.id, this.pratos, this.clientes, this.valor);
	}
	
	

}
