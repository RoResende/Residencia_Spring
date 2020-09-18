package org.serratec.javabackend.projetofinal.controllers;

import java.util.List;

import javax.validation.Valid;

import org.serratec.javabackend.projetofinal.entities.Produto;
import org.serratec.javabackend.projetofinal.exceptions.ItemNotFoundException;
import org.serratec.javabackend.projetofinal.services.ProdutoService;
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
@RequestMapping("/produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;

	@GetMapping
	public List<Produto> buscaTodos(@RequestParam(defaultValue = "id") String atributo) {
		return produtoService.buscaTodos(atributo);
	}

	@GetMapping("/{id}")
	public Produto buscaPorId(@PathVariable Integer id) throws ItemNotFoundException {
		return produtoService.buscaPorId(id);
	}


	@PostMapping
	public Produto insere(@Valid @RequestBody Produto produto) throws ItemNotFoundException {
		return produtoService.addProduto(produto);
	}

	@PutMapping("/{id}")
	public Produto atualiza(@PathVariable Integer id, @Valid @RequestBody Produto produto) throws ItemNotFoundException {
		return produtoService.upProduto(id, produto);
	}

	@DeleteMapping("/{id}")
	public void atualiza(@PathVariable Integer id) throws ItemNotFoundException {
		produtoService.delProduto(id);
	}

}
