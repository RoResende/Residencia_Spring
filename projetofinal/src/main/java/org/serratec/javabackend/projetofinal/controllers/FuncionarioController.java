package org.serratec.javabackend.projetofinal.controllers;

import java.util.List;

import javax.validation.Valid;

import org.serratec.javabackend.projetofinal.entities.Funcionario;
import org.serratec.javabackend.projetofinal.exceptions.ItemNotFoundException;
import org.serratec.javabackend.projetofinal.services.FuncionarioService;
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
@RequestMapping("/funcionario")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioService funcionarioService;

	@GetMapping
	public List<Funcionario> buscaTodos(@RequestParam(defaultValue = "id") String atributo) {
		return funcionarioService.buscaTodos(atributo);
	}

	@GetMapping("/{id}")
	public Funcionario buscaPorId(@PathVariable Integer id) throws ItemNotFoundException {
		return funcionarioService.buscaPorId(id);
	}


	@PostMapping
	public Funcionario insere(@Valid @RequestBody Funcionario funcionario) {
		return funcionarioService.addFuncionario(funcionario);
	}

	@PutMapping("/{id}")
	public Funcionario atualiza(@PathVariable Integer id, @Valid @RequestBody Funcionario funcionario) throws ItemNotFoundException {
		return funcionarioService.upFuncionario(id, funcionario);
	}

	@DeleteMapping("/{id}")
	public void atualiza(@PathVariable Integer id) throws ItemNotFoundException {
		funcionarioService.delFuncionario(id);
	}

}
