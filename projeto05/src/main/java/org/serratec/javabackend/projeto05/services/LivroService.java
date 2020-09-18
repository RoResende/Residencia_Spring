package org.serratec.javabackend.projeto05.services;

import java.util.List;
import java.util.Optional;

import org.serratec.javabackend.projeto05.dominio.Livro;
import org.serratec.javabackend.projeto05.exceptions.LivroNotFoundException;
import org.serratec.javabackend.projeto05.exceptions.MethodOrdenacaoNotValidException;
import org.serratec.javabackend.projeto05.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class LivroService {

	@Autowired
	private LivroRepository livroRepository;
	
	public List<Livro> listaLivros() {
		List<Livro> livros = livroRepository.findAll();
		return livros;
	}

	private Livro findLivro(Integer id) throws LivroNotFoundException {

		Optional<Livro> livroExistente = livroRepository.findById(id);

		if (!livroExistente.isPresent()) {
			throw new LivroNotFoundException(id);
		}

		return livroExistente.get();
	}

	

	public Livro getLivro(Integer id) throws LivroNotFoundException {

		return findLivro(id);
	}

	public Livro addLivro(Livro livro) {

		Livro livroSalvo = livroRepository.save(livro);
		return livroSalvo;
	}
	
	public List<Livro> ordenaLivro(String ordem) {

		if(ordem.equals("titulo")) {
			List<Livro> livroOrdenado=livroRepository.findAll(Sort.by(Sort.Direction.ASC,"titulo"));
			return livroOrdenado;
		}
		else if(ordem.equals("tipo")) {
			List<Livro> livroOrdenado=livroRepository.findAll(Sort.by(Sort.Direction.ASC,"tipo"));
			return livroOrdenado;
		}
		else if(ordem.equals("autor")) {
			List<Livro> livroOrdenado=livroRepository.findAll(Sort.by(Sort.Direction.ASC,"autor"));
			return livroOrdenado;
		}
		else
			throw new MethodOrdenacaoNotValidException(ordem);
	}

	public Livro atualizaLivro(Livro newLivro, Integer id) throws LivroNotFoundException {

		Livro livro = findLivro(id);
		if(newLivro.getId()!=null)
			livro.setId(newLivro.getId());
		if(newLivro.getTitulo()!=null)
			livro.setTitulo(newLivro.getTitulo());
		if(newLivro.getTipo()!=null)
			livro.setTipo(newLivro.getTipo());
		if(newLivro.getAutor()!=null)
			livro.setAutor(newLivro.getAutor());
		if(newLivro.getDataPublicacao()!=null)
			livro.setDataPublicacao(newLivro.getDataPublicacao());
		return livro;

	}

	public void apagaLivro(Integer id) throws LivroNotFoundException {

		Livro livro = findLivro(id);
		livroRepository.delete(livro);

	}
	
}
