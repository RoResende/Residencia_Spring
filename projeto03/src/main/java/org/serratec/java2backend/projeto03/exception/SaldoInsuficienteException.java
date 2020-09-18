package org.serratec.java2backend.projeto03.exception;

public class SaldoInsuficienteException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private Double valor;

	public SaldoInsuficienteException(Double valor) {
		super("Saldo insuficiente para a operação no valor: " + valor);
		this.valor = valor;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	
}
