package br.org.serratec.eletronicos.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.serratec.eletronicos.dto.PedidosDto;
import br.org.serratec.eletronicos.model.Pedidos;
import br.org.serratec.eletronicos.repository.EletronicosRepository;
import jakarta.validation.Valid;

@Service
public class EletronicosService {
	
	@Autowired
	private EletronicosRepository repositorio;
	
	
	public List<PedidosDto> obterTodosPedidos(){
        List<PedidosDto> pedidos = new ArrayList<>();
        repositorio.findAll().forEach(pedido -> {
            pedidos.add(pedido.toDto());

        });
        return pedidos;
    }

	public PedidosDto registrarPedido(PedidosDto novoPedido) {
        Pedidos pedidosEntity = repositorio.save(novoPedido.toEntity());
        return pedidosEntity.toDto();
    }
}
