package org.serratec.javabackend.projeto05.exceptions;

public class MethodOrdenacaoNotValidException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String ordem;
	
	public MethodOrdenacaoNotValidException(String ordem) {
		this.ordem=ordem;
	}

	public String getOrdem() {
		return ordem;
	}

}
