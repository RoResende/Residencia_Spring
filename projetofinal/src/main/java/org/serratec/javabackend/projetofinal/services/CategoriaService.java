package org.serratec.javabackend.projetofinal.services;

import java.util.List;
import java.util.Optional;

import org.serratec.javabackend.projetofinal.entities.Categoria;
import org.serratec.javabackend.projetofinal.exceptions.ItemNotFoundException;
import org.serratec.javabackend.projetofinal.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	
	@Transactional(readOnly = true)
	public List<Categoria> buscaTodos(String atributo){
		return categoriaRepository.findAll(Sort.by(atributo));
	}
	
	private Categoria findId(Integer id) throws ItemNotFoundException {
		Optional<Categoria> foundCategoria = categoriaRepository.findById(id);
		if (foundCategoria.isPresent()) {
			return foundCategoria.get();
		}
		throw new ItemNotFoundException(id);
	}
	
	@Transactional(readOnly = true)
	public Categoria buscaPorId(Integer id) throws ItemNotFoundException {
		return findId(id);
	}
	
	
	@Transactional
	public Categoria addCategoria(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}

	@Transactional
	public Categoria upCategoria(Integer id, Categoria newCategoria ) throws ItemNotFoundException {
		Categoria categoria = findId(id);
		categoria.setTipo(newCategoria.getTipo());
		categoria.setDescricao(newCategoria.getDescricao());
		return categoriaRepository.save(categoria);
	}
	
	@Transactional
	public void delCategoria(Integer id) throws ItemNotFoundException {
		Categoria categoria = findId(id);
		categoriaRepository.delete(categoria);
	}
}
