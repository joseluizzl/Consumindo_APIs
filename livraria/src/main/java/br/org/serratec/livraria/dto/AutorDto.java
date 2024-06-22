package br.org.serratec.livraria.dto;

import br.org.serratec.livraria.config.Mapper;
import br.org.serratec.livraria.model.Autor;
import br.org.serratec.livraria.model.Endereco;

public record AutorDto(
		Long id,
		String nome,
		Endereco endereco) {
	
	public Autor toEntity() {
		return Mapper.getMapper().convertValue(this, Autor.class);
	}

}