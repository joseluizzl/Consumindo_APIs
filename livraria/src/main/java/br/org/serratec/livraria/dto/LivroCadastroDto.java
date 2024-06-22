package br.org.serratec.livraria.dto;

import java.util.List;

import br.org.serratec.livraria.config.Mapper;
import br.org.serratec.livraria.model.Livro;

public record LivroCadastroDto(
		String titulo,
		String isbn,
		int anoLancamento,
		Long editoraId,
		List<Long> autoresId) {
	
	public Livro toEntity() {
		return Mapper.getMapper().convertValue(this, Livro.class);
	}
	
}