package org.serratec.javabackend.projetofinal.services;

import java.util.List;
import java.util.Optional;

import org.serratec.javabackend.projetofinal.entities.Produto;
import org.serratec.javabackend.projetofinal.exceptions.ItemNaoDisponivelException;
import org.serratec.javabackend.projetofinal.exceptions.ItemNotFoundException;
import org.serratec.javabackend.projetofinal.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CategoriaService categoriaService;
	
	@Autowired
	private FuncionarioService funcionarioService;

	
	@Transactional(readOnly = true)
	public List<Produto> buscaTodos(String atributo){
		return produtoRepository.findAll(Sort.by(atributo));
	}
	
	private Produto findId(Integer id) throws ItemNotFoundException {
		Optional<Produto> foundProduto = produtoRepository.findById(id);
		if (foundProduto.isPresent()) {
			return foundProduto.get();
		}
		throw new ItemNotFoundException(id);
	}
	
	@Transactional(readOnly = true)
	public Produto buscaPorId(Integer id) throws ItemNotFoundException {
		return findId(id);
	}
	
	@Transactional
	public Produto compraProduto(Integer id, Integer quantidade) throws ItemNotFoundException {
		Produto produto = findId(id);
		produto.setQuantidade(produto.getQuantidade() - quantidade);
		if(produto.getQuantidade()>=0)
			return produtoRepository.save(produto);
		else
			throw new ItemNaoDisponivelException(id);
	}
	
	@Transactional
	public Produto addProduto(Produto produto) throws ItemNotFoundException {
		Integer idC = produto.getCategoria().getId();
		Integer idF = produto.getFuncionario().getId();
		if (!categoriaService.buscaPorId(idC).equals(null)) {
			if (!funcionarioService.buscaPorId(idF).equals(null)) {
				return produtoRepository.save(produto);
			}
			else
				throw new ItemNotFoundException(idF);
		}
		else
			throw new ItemNotFoundException(idC);
	}

	@Transactional
	public Produto upProduto(Integer id, Produto newProduto ) throws ItemNotFoundException {
		Produto produto = findId(id);
		produto.setNomeProduto(newProduto.getNomeProduto());
		produto.setDescricao(newProduto.getDescricao());
		produto.setQuantidade(newProduto.getQuantidade());
		produto.setDataFabricacao(newProduto.getDataFabricacao());
		produto.setPreco(newProduto.getPreco());
		produto.setCategoria(newProduto.getCategoria());
		produto.setFuncionario(newProduto.getFuncionario());
		return produtoRepository.save(produto);
	}
	
	@Transactional
	public void delProduto(Integer id) throws ItemNotFoundException {
		Produto produto = findId(id);
		produtoRepository.delete(produto);
	}

}
