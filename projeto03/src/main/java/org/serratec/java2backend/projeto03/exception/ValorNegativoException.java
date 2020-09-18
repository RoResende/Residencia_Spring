package org.serratec.java2backend.projeto03.exception;

public class ValorNegativoException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private Double valor;

	public ValorNegativoException(Double valor) {
		super("\"Você tentou depositar um valor negativo: " + valor);
		this.valor = valor;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
}
