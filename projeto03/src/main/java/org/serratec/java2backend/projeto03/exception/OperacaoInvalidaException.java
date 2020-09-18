package org.serratec.java2backend.projeto03.exception;

public class OperacaoInvalidaException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String operacao;
	
	public OperacaoInvalidaException(String operacao) {
		super(operacao + " é uma operação inválida.");
		this.operacao = operacao;
	}

	public String getOperacao() {
		return operacao;
	}

	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}
	
}
