package br.org.serratec.livraria.dto;

import java.time.LocalDate;

import br.org.serratec.livraria.config.Mapper;
import br.org.serratec.livraria.model.RegistroFuncionamento;

public record RegistroFuncionamentoDto(
		Long id,
		String cnpj,
		String alvara,
		LocalDate dataAutorizacao) {
	
	public RegistroFuncionamento toEntity() {
		return Mapper.getMapper().convertValue(this, RegistroFuncionamento.class);
	}

}