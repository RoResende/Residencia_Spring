package org.serratec.javabackend.projetofinal.exceptions;

public class ItemNotFoundException extends Exception{

	private static final long serialVersionUID = 5535845560408959113L;
	private Integer id;
	
	public ItemNotFoundException(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
	
}
