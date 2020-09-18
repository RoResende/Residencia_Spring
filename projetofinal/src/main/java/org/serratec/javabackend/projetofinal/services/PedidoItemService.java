package org.serratec.javabackend.projetofinal.services;

import java.util.List;
import java.util.Optional;

import org.serratec.javabackend.projetofinal.entities.PedidoItem;
import org.serratec.javabackend.projetofinal.exceptions.ItemNotFoundException;
import org.serratec.javabackend.projetofinal.repositories.PedidoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PedidoItemService {

	@Autowired
	private PedidoItemRepository pedidoItemRepository;
	
	@Autowired
	private ProdutoService produtoService;
	
	@Transactional(readOnly = true)
	public List<PedidoItem> buscaTodos(String atributo){
		return pedidoItemRepository.findAll(Sort.by(atributo));
	}
	
	private PedidoItem findId(Integer id) throws ItemNotFoundException {
		Optional<PedidoItem> foundPedidoItem = pedidoItemRepository.findById(id);
		if (foundPedidoItem.isPresent()) {
			return foundPedidoItem.get();
		}
		throw new ItemNotFoundException(id);
	}
	
	@Transactional(readOnly = true)
	public PedidoItem buscaPorId(Integer id) throws ItemNotFoundException {
		return findId(id);
	}
	
	
	@Transactional
	public PedidoItem addPedidoItem(PedidoItem pedidoItem) throws ItemNotFoundException {
		Integer quantidade = pedidoItem.getQuantidade();
		Integer id = pedidoItem.getProduto().getId();
		//if(produtoService.buscaPorId(id).getId().equals(pedidoItem.getProduto().getId()))
		if(!produtoService.buscaPorId(id).equals(null))	{
			produtoService.compraProduto(id,quantidade);
			pedidoItem.setValor(produtoService.buscaPorId(id).getPreco()*quantidade);
			return pedidoItemRepository.save(pedidoItem);
		}
		else
			throw new ItemNotFoundException(id);
	}
	
	//Essa parte é necessária? Geralmente uma vez feito pedido não pode ser alterado.
	@Transactional
	public PedidoItem upPedidoItem(Integer id, PedidoItem newPedidoItem ) throws ItemNotFoundException {
		PedidoItem pedidoItem = findId(id);
		pedidoItem.setQuantidade(newPedidoItem.getQuantidade());
		pedidoItem.setValor(newPedidoItem.getValor());
		pedidoItem.setProduto(newPedidoItem.getProduto());
		return pedidoItemRepository.save(pedidoItem);
	}
	
	@Transactional
	public void delPedidoItem(Integer id) throws ItemNotFoundException {
		PedidoItem pedidoItem = findId(id);
		pedidoItemRepository.delete(pedidoItem);
	}
}
