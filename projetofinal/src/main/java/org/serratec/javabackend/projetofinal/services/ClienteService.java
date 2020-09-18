package org.serratec.javabackend.projetofinal.services;

import java.util.List;
import java.util.Optional;

import org.serratec.javabackend.projetofinal.entities.Cliente;
import org.serratec.javabackend.projetofinal.exceptions.ItemNotFoundException;
import org.serratec.javabackend.projetofinal.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	
	@Transactional(readOnly = true)
	public List<Cliente> buscaTodos(String atributo){
		return clienteRepository.findAll(Sort.by(atributo));
	}
	
	private Cliente findId(Integer id) throws ItemNotFoundException {
		Optional<Cliente> foundCliente = clienteRepository.findById(id);
		if (foundCliente.isPresent()) {
			return foundCliente.get();
		}
		throw new ItemNotFoundException(id);
	}
	
	@Transactional(readOnly = true)
	public Cliente buscaPorId(Integer id) throws ItemNotFoundException {
		return findId(id);
	}
	
	
	@Transactional
	public Cliente addCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	@Transactional
	public Cliente upCliente(Integer id, Cliente newCliente ) throws ItemNotFoundException {
		Cliente cliente = findId(id);
		cliente.setNomeCompleto(newCliente.getNomeCompleto());
		cliente.setNomeUsuario(newCliente.getNomeUsuario());
		cliente.setCpf(newCliente.getCpf());
		cliente.setEmail(newCliente.getEmail());
		cliente.setEndereco(newCliente.getEndereco());
		cliente.setCep(newCliente.getCep());
		cliente.setDataNascimento(newCliente.getDataNascimento());
		return clienteRepository.save(cliente);
	}
	
	@Transactional
	public void delCliente(Integer id) throws ItemNotFoundException {
		Cliente cliente = findId(id);
		clienteRepository.delete(cliente);
	}
	
}
