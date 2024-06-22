package br.org.serratec.eletronicos.dto;

import br.org.serratec.eletronicos.model.Produtos;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProdutosDto(
		 Long id,
		 
		 @NotBlank(message = "Informe o nome do produto!")
		 String nomeProduto,
		 @NotNull(message = "Informe a quantidade do produto!")
		 int quantidade,
		 @NotNull(message =  "Informe o valor do produto!")
		 Double preco
		 ) {

	public Produtos toEntity() {
        return new Produtos(
                this.id,
                this.nomeProduto,
                this.quantidade,
                this.preco
                );
    }

}
