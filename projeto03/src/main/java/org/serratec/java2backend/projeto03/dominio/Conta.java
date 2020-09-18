package org.serratec.java2backend.projeto03.dominio;

import org.serratec.java2backend.projeto03.exception.SaldoInsuficienteException;
import org.serratec.java2backend.projeto03.exception.ValorNegativoException;

public class Conta {

	private Integer numero;
	private String titular;
	private Double saldo;
	
	public Conta(Integer numero, String titular, double saldo) {
		super();
		this.numero = numero;
		this.titular = titular;
		this.saldo = saldo;
	}
	
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getTitular() {
		return titular;
	}
	public void setTitular(String titular) {
		this.titular = titular;
	}
	public Double getSaldo() {
		return saldo;
	}
	
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public void saque(Double valor) {
		if (valor < 0)
			throw new ValorNegativoException(valor);
		if (this.saldo < valor)
			throw new SaldoInsuficienteException(valor);

		else {
			this.saldo = this.saldo - valor;
		}
	}

	public void deposito(Double valor) {
		if (valor < 0) {
			throw new ValorNegativoException(valor);
		} else {
			this.saldo += valor;
		}
	}
	
	
}
