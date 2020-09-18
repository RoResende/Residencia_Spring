package org.serratec.javabackend.projetofinal.controllers;

import java.util.List;

import javax.validation.Valid;

import org.serratec.javabackend.projetofinal.entities.Pedido;
import org.serratec.javabackend.projetofinal.exceptions.ItemNotFoundException;
import org.serratec.javabackend.projetofinal.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
	
	@Autowired
	private PedidoService pedidoService;
	
	@GetMapping
	public List<Pedido> buscaTodos(@RequestParam(defaultValue = "id") String atributo) {
		return pedidoService.buscaTodos(atributo);
	}

	@GetMapping("/{id}")
	public Pedido buscaPorId(@PathVariable Integer id) throws ItemNotFoundException {
		return pedidoService.buscaPorId(id);
	}


	@PostMapping
	public Pedido insere(@Valid @RequestBody Pedido pedido) throws ItemNotFoundException {
		return pedidoService.addPedido(pedido);
	}

	@PutMapping("/{id}")
	public Pedido atualiza(@PathVariable Integer id, @Valid @RequestBody Pedido pedido) throws ItemNotFoundException {
		return pedidoService.upPedido(id, pedido);
	}

	@DeleteMapping("/{id}")
	public void atualiza(@PathVariable Integer id) throws ItemNotFoundException {
		pedidoService.delPedido(id);
	}

}
