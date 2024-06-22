package br.org.serratec.eletronicos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.eletronicos.model.Pedidos;

public interface EletronicosRepository extends JpaRepository<Pedidos, Long>{

}
