package org.serratec.javabackend.projeto04.exceptions;

public class LivroNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	private Integer id;

	public LivroNotFoundException(Integer id) {
		this.id=id;
		System.out.println("Livro número: "+id+" não existe.");
	}

	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
