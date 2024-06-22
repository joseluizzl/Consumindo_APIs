package br.org.serratec.eletronicos.dto;

import java.util.List;

import br.org.serratec.eletronicos.model.Pagamento;
import br.org.serratec.eletronicos.model.Pedidos;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PedidosDto(

        Long id,
        @NotBlank(message = "Informe o nome do cliente.")
        String nome,
        @NotBlank(message = "Informe o cpf do cliente.")
        String cpf,
        @NotNull(message = "Informe o valor final do pedido!")
        Double valorFinal,
        Pagamento pagamento,
        List<ProdutosDto> produtos
        ) {

    public Pedidos toEntity() {
        return new Pedidos (
                this.id,
                this.nome,
                this.cpf,
                this.valorFinal,
                this.pagamento,
                this.produtos);

    }
    

}
