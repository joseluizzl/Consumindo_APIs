package br.org.serratec.restauranteOriental.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.serratec.restauranteOriental.dto.PedidoDto;
import br.org.serratec.restauranteOriental.service.PedidoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
	@Autowired
	private PedidoService service;
	
	@GetMapping
	public ResponseEntity<List<PedidoDto>> obterTodosPedidos() {
		return ResponseEntity.ok(service.obterTodosPedidos());
	}
	
	@PostMapping
	public ResponseEntity<PedidoDto> salvarPedido(@Valid @RequestBody PedidoDto novoPedido) {
		return new ResponseEntity<PedidoDto>(service.salvarPedido(novoPedido), HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PedidoDto> obterPedidoPorId(@PathVariable Long id) {
		Optional<PedidoDto> pedidoDto = service.ObterPedidoPorId(id);
		
		if (pedidoDto.isPresent()) {
			return ResponseEntity.ok(pedidoDto.get());
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
    public ResponseEntity<PedidoDto> atualizarPedido(@PathVariable Long id,@Valid @RequestBody PedidoDto pedidoAlterado) {
        Optional<PedidoDto> pedidoDto = service.atualizarPedido(id, pedidoAlterado);

        if (pedidoDto.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(pedidoDto.get());
    }
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluirPedido (@PathVariable Long id) {
		if (service.excluirPedido(id)) {
			return ResponseEntity.noContent().build();
			
		}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/pratos")
	public ResponseEntity<List<PedidoDto>> obterPorInicioPrato(@RequestBody String inicioPrato) {
		return ResponseEntity.ok(service.obterPorInicioPrato(inicioPrato));
	}
	
	@GetMapping("/clientes")
	public ResponseEntity<List<PedidoDto>> obterFinalCliente(@RequestBody String finalCliente) {
		return ResponseEntity.ok(service.obterFinalCliente(finalCliente));
	}
}
