package org.serratec.java2backend.projeto03.controllers;

import java.util.List;

import org.serratec.java2backend.projeto03.dominio.Conta;
import org.serratec.java2backend.projeto03.exception.ContaNotFoundException;
import org.serratec.java2backend.projeto03.services.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContaController {

	@Autowired
	private ContaService contaService;

	@RequestMapping("/conta")
	public List<Conta> getTodos() {
		return contaService.listaTodos();
	}

	@GetMapping("/conta/{id}")
	public Conta getID(@PathVariable Integer id) throws ContaNotFoundException {
		return contaService.getConta(id);
	}

	@PostMapping("/conta")
	public Conta postTodo(@RequestBody Conta todo) {
		return contaService.criaConta(todo);
	}

	@PutMapping("/conta/{id}")
	public Conta putTodo(@PathVariable Integer id, @RequestBody Conta conta) throws ContaNotFoundException {
		return contaService.atualizaConta(conta, id);
	}

	@PostMapping("/conta/{id}/{operacao}")
	public Conta operacaoConta(@PathVariable Integer id, @PathVariable String operacao, @RequestBody Conta conta)
			throws ContaNotFoundException {
		
		return contaService.operacaoConta(conta, id, operacao);
	}

	@DeleteMapping("/conta/{id}")
	public void deleteTodo(@PathVariable Integer id) throws ContaNotFoundException {
		contaService.apagaConta(id);
	}
}
