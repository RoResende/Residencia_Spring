package org.serratec.javabackend.projetofinal.exceptions;

public class ItemNaoDisponivelException extends RuntimeException {

	private static final long serialVersionUID = -320459785317718254L;
    private Integer id;
	
	public ItemNaoDisponivelException(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}

}
