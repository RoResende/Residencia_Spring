package org.serratec.javabackend.projetofinal.controllers;

import java.util.List;

import javax.validation.Valid;

import org.serratec.javabackend.projetofinal.entities.Cliente;
import org.serratec.javabackend.projetofinal.exceptions.ItemNotFoundException;
import org.serratec.javabackend.projetofinal.services.ClienteService;
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
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@GetMapping
	public List<Cliente> buscaTodos(@RequestParam(defaultValue = "id") String atributo) {
		return clienteService.buscaTodos(atributo);
	}

	@GetMapping("/{id}")
	public Cliente buscaPorId(@PathVariable Integer id) throws ItemNotFoundException {
		return clienteService.buscaPorId(id);
	}


	@PostMapping
	public Cliente insere(@Valid @RequestBody Cliente cliente) {
		return clienteService.addCliente(cliente);
	}

	@PutMapping("/{id}")
	public Cliente atualiza(@PathVariable Integer id, @Valid @RequestBody Cliente cliente) throws ItemNotFoundException {
		return clienteService.upCliente(id, cliente);
	}

	@DeleteMapping("/{id}")
	public void atualiza(@PathVariable Integer id) throws ItemNotFoundException {
		clienteService.delCliente(id);
	}
}
