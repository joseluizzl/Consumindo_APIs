package br.org.serratec.eletronicos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.org.serratec.eletronicos.dto.PedidosDto;
import br.org.serratec.eletronicos.service.EletronicosService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/eletronicos")
public class EletronicosController {
	
	@Autowired
	EletronicosService servico;
	
	@GetMapping
	public ResponseEntity<List<PedidosDto>> listarTodos() {
		return ResponseEntity.ok(servico.obterTodosPedidos());
	}
	
	@PostMapping
    public ResponseEntity<PedidosDto> registrarPedido(
            @RequestBody PedidosDto novoPedido) {
        return new ResponseEntity<PedidosDto>(
                servico.registrarPedido(novoPedido), HttpStatus.CREATED);
    }
	
}
