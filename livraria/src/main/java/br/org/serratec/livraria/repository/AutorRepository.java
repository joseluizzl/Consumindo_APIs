package br.org.serratec.livraria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.livraria.model.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long>{

}
