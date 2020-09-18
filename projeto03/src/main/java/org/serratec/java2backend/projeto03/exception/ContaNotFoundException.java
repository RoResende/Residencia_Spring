package org.serratec.java2backend.projeto03.exception;

public class ContaNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	private Integer id;

	public ContaNotFoundException(Integer id) {
		this.id=id;
		System.out.println("Conta número: "+id+" não existe.");
	}

	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
