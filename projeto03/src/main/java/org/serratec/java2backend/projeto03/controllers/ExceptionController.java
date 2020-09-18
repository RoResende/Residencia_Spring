package org.serratec.java2backend.projeto03.controllers;

import org.serratec.java2backend.projeto03.exception.ContaNotFoundException;
import org.serratec.java2backend.projeto03.exception.OperacaoInvalidaException;
import org.serratec.java2backend.projeto03.exception.SaldoInsuficienteException;
import org.serratec.java2backend.projeto03.exception.ValorNegativoException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

	@ExceptionHandler(ContaNotFoundException.class)
	public ResponseEntity<String> trataContaNotFound(ContaNotFoundException exception){
		
		String msg = String.format("A conta com id %d não foi encontrada.", exception.getId());
		return ResponseEntity.notFound()
				.header("x-erro-msg", msg)
				.header("x-erro-code","CONTA_NOT_FOUND")
				.header("x-erro-code",exception.getId().toString())
				.build();
	}
	
	@ExceptionHandler(SaldoInsuficienteException.class)
	public ResponseEntity<String> trataSaldoInsuficiente(SaldoInsuficienteException exception){
		
		String msg = String.format("A conta não possui saldo suficiente para operação de %.2f."
				, exception.getValor());
		return ResponseEntity.badRequest()
				.header("x-erro-msg", msg)
				.header("x-erro-code","SALDO_INSUFICIENTE")
				.header("x-erro-code",exception.getValor().toString())
				.build();
	}
	
	@ExceptionHandler(ValorNegativoException.class)
	public ResponseEntity<String> trataValorNegativo(ValorNegativoException exception){
		
		String msg = String.format("%.2f, valor negativo inválido para operação."
				, exception.getValor());
		return ResponseEntity.badRequest()
				.header("x-erro-msg", msg)
				.header("x-erro-code","VALOR_NEGATIVO")
				.header("x-erro-code",exception.getValor().toString())
				.build();
	}
	
	@ExceptionHandler(OperacaoInvalidaException.class)
	public ResponseEntity<String> trataOperacaoInvalida(OperacaoInvalidaException exception){
		
		String msg = String.format("%s operação inválida."
				, exception.getOperacao());
		return ResponseEntity.badRequest()
				.header("x-erro-msg", msg)
				.header("x-erro-code","OPERACAO_INVALIDA")
				.header("x-erro-code",exception.getOperacao())
				.build();
	}
	
}
