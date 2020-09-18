package org.serratec.javabackend.projetofinal.controllers;

import java.util.List;

import javax.validation.Valid;

import org.serratec.javabackend.projetofinal.entities.Categoria;
import org.serratec.javabackend.projetofinal.exceptions.ItemNotFoundException;
import org.serratec.javabackend.projetofinal.services.CategoriaService;
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
@RequestMapping("/categoria")
public class CategoriaController {
	
	@Autowired
	private CategoriaService categoriaService;

	@GetMapping
	public List<Categoria> buscaTodos(@RequestParam(defaultValue = "id") String atributo) {
		return categoriaService.buscaTodos(atributo);
	}

	@GetMapping("/{id}")
	public Categoria buscaPorId(@PathVariable Integer id) throws ItemNotFoundException {
		return categoriaService.buscaPorId(id);
	}


	@PostMapping
	public Categoria insere(@Valid @RequestBody Categoria categoria) {
		return categoriaService.addCategoria(categoria);
	}

	@PutMapping("/{id}")
	public Categoria atualiza(@PathVariable Integer id, @Valid @RequestBody Categoria categoria) throws ItemNotFoundException {
		return categoriaService.upCategoria(id, categoria);
	}

	@DeleteMapping("/{id}")
	public void atualiza(@PathVariable Integer id) throws ItemNotFoundException {
		categoriaService.delCategoria(id);
	}

}
