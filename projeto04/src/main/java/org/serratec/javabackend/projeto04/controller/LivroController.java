package org.serratec.javabackend.projeto04.controller;

import java.util.List;

import javax.validation.Valid;

import org.serratec.javabackend.projeto04.dominio.Livro;
import org.serratec.javabackend.projeto04.exceptions.LivroNotFoundException;
import org.serratec.javabackend.projeto04.services.LivroService;
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
public class LivroController {
	
	@Autowired
	private LivroService livroService;
	
	@RequestMapping("/livro")
	public List<Livro> getTodos() {
		return livroService.listaLivros();
	}

	@GetMapping("/livro/{id}")
	public Livro getID(@PathVariable Integer id) throws LivroNotFoundException {
		return livroService.getLivro(id);
	}
	
	@GetMapping(value="/livro",params="ordem")
	public List<Livro> getLivroOrdena(@RequestParam String ordem) throws LivroNotFoundException {
		return livroService.ordenaLivro(ordem);
	}

	@PostMapping("/livro")
	public Livro postLivro(@Valid @RequestBody Livro livro) {
		return livroService.addLivro(livro);
	}

	@PutMapping("/livro/{id}")
	public Livro putTodo(@PathVariable Integer id,@Valid @RequestBody Livro livro) throws LivroNotFoundException {
		return livroService.atualizaLivro(livro, id);
	}

	@DeleteMapping("/livro/{id}")
	public void deleteTodo(@PathVariable Integer id) throws LivroNotFoundException {
		livroService.apagaLivro(id);
	}
	

}
