package br.org.serratec.livraria.dto;

import br.org.serratec.livraria.config.Mapper;
import br.org.serratec.livraria.model.Editora;

public record EditoraDto(
		 Long id,
		 String nome,
		 RegistroFuncionamentoDto registro)  {
	
	public Editora toEntity() {
		return Mapper.getMapper().convertValue(this, Editora.class);
	}

}