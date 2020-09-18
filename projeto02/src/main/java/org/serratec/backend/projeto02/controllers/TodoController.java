package org.serratec.backend.projeto02.controllers;

import java.util.List;

import org.serratec.backend.projeto02.dominio.Conta;
import org.serratec.backend.projeto02.services.TodoService;
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
public class TodoController {

	@Autowired
	private TodoService todoService;

	@RequestMapping("/todo")
	public List<Conta> getTodos() {
		return todoService.listaTodos();
	}
	
	@GetMapping("/todo/{id}")
	public Conta getID(@PathVariable Integer id) {
		return todoService.getTodo(id);
	}
	
	@PostMapping("/todo")
	public Conta postTodo(@RequestBody Conta todo) {
		return todoService.criaTodo(todo);
	}
	
	@PutMapping("/todo")
	public Conta putTodo(@PathVariable Integer id,@RequestBody Conta todo) {
		return todoService.atualizaTodo(todo,id);
	}
	
	@DeleteMapping("/todo/{id}")
	public void deleteTodo(@PathVariable Integer id) {
		todoService.apagaTodo(id);
	}
	
}
