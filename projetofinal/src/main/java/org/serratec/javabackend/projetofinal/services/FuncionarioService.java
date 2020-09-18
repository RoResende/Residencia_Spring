package org.serratec.javabackend.projetofinal.services;

import java.util.List;
import java.util.Optional;

import org.serratec.javabackend.projetofinal.entities.Funcionario;
import org.serratec.javabackend.projetofinal.exceptions.ItemNotFoundException;
import org.serratec.javabackend.projetofinal.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	
	@Transactional(readOnly = true)
	public List<Funcionario> buscaTodos(String atributo){
		return funcionarioRepository.findAll(Sort.by(atributo));
	}
	
	private Funcionario findId(Integer id) throws ItemNotFoundException {
		Optional<Funcionario> foundFuncionario = funcionarioRepository.findById(id);
		if (foundFuncionario.isPresent()) {
			return foundFuncionario.get();
		}
		throw new ItemNotFoundException(id);
	}
	
	@Transactional(readOnly = true)
	public Funcionario buscaPorId(Integer id) throws ItemNotFoundException {
		return findId(id);
	}
	
	
	@Transactional
	public Funcionario addFuncionario(Funcionario cliente) {
		return funcionarioRepository.save(cliente);
	}

	@Transactional
	public Funcionario upFuncionario(Integer id, Funcionario newFuncionario ) throws ItemNotFoundException {
		Funcionario funcionario = findId(id);
		funcionario.setNomeCompleto(newFuncionario.getNomeCompleto());
		funcionario.setCpf(newFuncionario.getCpf());
		return funcionarioRepository.save(funcionario);
	}
	
	@Transactional
	public void delFuncionario(Integer id) throws ItemNotFoundException {
		Funcionario funcionario = findId(id);
		funcionarioRepository.delete(funcionario);
	}
}
