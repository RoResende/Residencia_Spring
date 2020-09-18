package org.serratec.javabackend.projetofinal.services;

import java.util.List;
import java.util.Optional;

import org.serratec.javabackend.projetofinal.entities.Pedido;
import org.serratec.javabackend.projetofinal.entities.PedidoItem;
import org.serratec.javabackend.projetofinal.exceptions.ItemNotFoundException;
import org.serratec.javabackend.projetofinal.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private PedidoItemService pedidoItemService;
	
	@Transactional(readOnly = true)
	public List<Pedido> buscaTodos(String atributo){
		return pedidoRepository.findAll(Sort.by(atributo));
	}
	
	private Pedido findId(Integer id) throws ItemNotFoundException {
		Optional<Pedido> foundPedido = pedidoRepository.findById(id);
		if (foundPedido.isPresent()) {
			return foundPedido.get();
		}
		throw new ItemNotFoundException(id);
	}
	
	@Transactional(readOnly = true)
	public Pedido buscaPorId(Integer id) throws ItemNotFoundException {
		return findId(id);
	}
	
	
	@Transactional
	public Pedido addPedido(Pedido pedido) throws ItemNotFoundException {
		Integer id = pedido.getCliente().getId();
		if (!clienteService.buscaPorId(id).equals(null)){
			for (PedidoItem pedidoItem : pedido.getItens())
				pedidoItemService.addPedidoItem(pedidoItem);
			return pedidoRepository.save(pedido);
		}
		else
			throw new ItemNotFoundException(id);
	}

	//Essa parte é necessária? Geralmente uma vez feito pedido não pode ser alterado.
	@Transactional
	public Pedido upPedido(Integer id, Pedido newPedido ) throws ItemNotFoundException {
		Pedido pedido = findId(id);
		pedido.setDataPedido(newPedido.getDataPedido());
		pedido.setCliente(newPedido.getCliente());
		pedido.setItens(newPedido.getItens());
		return pedidoRepository.save(pedido);
	}
	
	@Transactional
	public void delPedido(Integer id) throws ItemNotFoundException {
		Pedido pedido = findId(id);
		pedidoRepository.delete(pedido);
	}
}
