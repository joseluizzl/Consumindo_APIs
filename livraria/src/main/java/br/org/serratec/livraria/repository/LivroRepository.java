package br.org.serratec.livraria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.org.serratec.livraria.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {
	@Query(value = "Delete from livro_autor where livro_id=:idLivro and autor_id=:idAutor",
			nativeQuery = true)
	void excluirLivroAutor(@Param("idLivro") Long idLivro, @Param("idAutor") Long idAutor);
	
	@Query(value = "Delete from Livro livros where id = :idLivro", nativeQuery = true)
	void excluirLivro(@Param("idLivro") Long idLivro);
	
	@Query("Select l from livro l where l.anoLancamento <= :ano")
	List<Livro> buscaPorAnoLancamentoMenor(@Param("ano") int ano);
}
