package br.org.serratec.eletronicos.model;

import jakarta.validation.constraints.NotBlank;

@NotBlank(message = "A forma de pagamento deverá ser informada!")
public enum Pagamento {
	DINHEIRO,
	PIX,
	CREDITO,
	DEBITO
}
