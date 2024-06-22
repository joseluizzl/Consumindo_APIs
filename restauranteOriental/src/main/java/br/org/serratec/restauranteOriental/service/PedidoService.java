package br.org.serratec.restauranteOriental.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.serratec.restauranteOriental.dto.PedidoDto;
import br.org.serratec.restauranteOriental.model.Pedido;
import br.org.serratec.restauranteOriental.repository.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repository;
	
	public List<PedidoDto> obterTodosPedidos() {
		List<PedidoDto> pedidos = new ArrayList<>();
		repository.findAll().forEach(p -> {
			pedidos.add(p.toDto());
		});
		return pedidos;
	}
	
	public PedidoDto salvarPedido(PedidoDto novoPedido) {
        Pedido pedidoSalvo = repository.save(novoPedido.toEntity());
        return pedidoSalvo.toDto();
    }
	
	public Optional<PedidoDto> ObterPedidoPorId(Long id) {
		Optional<Pedido> pedido = repository.findById(id);
		
		if (pedido.isPresent()) {
			return Optional.of(pedido.get().toDto());
		}
		
		return Optional.empty();
	}
	
	public Optional<PedidoDto> atualizarPedido(Long id, PedidoDto pedidoAlterado) {
        Pedido pedido = pedidoAlterado.toEntity();

        if (repository.existsById(id)) {
        	pedido.setId(id);
            repository.save(pedido);
            return Optional.of(pedido.toDto());
        }
        return Optional.empty();
    }
	
	public boolean excluirPedido(Long id) {
		if (repository.existsById(id)) {
			 repository.deleteById(id);
			 return true;
		}
		
		 return false;
	}
	
	public List<PedidoDto> obterPorInicioPrato(String inicioPrato) {
		List<PedidoDto> pratos = new ArrayList<>();
		repository.findByPratosStartingWithIgnoreCase(inicioPrato).forEach(l -> {
			pratos.add(l.toDto());
		});
		return pratos;
	}
	
	public List<PedidoDto> obterFinalCliente(String finalCliente) {
		List<PedidoDto> clientes = new ArrayList<>();
		repository.findByClientesEndingWithIgnoreCase(finalCliente).forEach(l -> {
			clientes.add(l.toDto());
		});
		return clientes;
	}
	
}
