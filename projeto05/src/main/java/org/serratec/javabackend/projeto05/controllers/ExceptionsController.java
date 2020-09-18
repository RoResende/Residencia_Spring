package org.serratec.javabackend.projeto05.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.serratec.javabackend.projeto05.exceptions.LivroNotFoundException;
import org.serratec.javabackend.projeto05.exceptions.MethodOrdenacaoNotValidException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionsController {
	
	@ExceptionHandler(LivroNotFoundException.class)
	public ResponseEntity<String> trataContaNotFound(LivroNotFoundException ex){
		
		String msg = String.format("O livro com id %d não foi encontrado.", ex.getId());
		return ResponseEntity.notFound()
				.header("x-erro-msg", msg)
				.header("x-erro-code","LIVRO_NOT_FOUND")
				.header("x-erro-code",ex.getId().toString())
				.build();
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String,String> handleValidationException(MethodArgumentNotValidException ex){
		
		Map<String,String> errosOcorridos = new HashMap<>();
		List<ObjectError> erros = ex.getBindingResult().getAllErrors();
		for(ObjectError erro:erros) {
			String atributo = ((FieldError)erro).getField();
			String mensagem = erro.getDefaultMessage();
			errosOcorridos.put(atributo, mensagem);
		}
		return errosOcorridos;
	}
	
	@ExceptionHandler(MethodOrdenacaoNotValidException.class)
	public ResponseEntity<String> trataContaNotFound(MethodOrdenacaoNotValidException ex){
		
		String msg = String.format("O livro com id %d não foi encontrado.", ex.getOrdem());
		return ResponseEntity.badRequest()
				.header("x-erro-msg", msg)
				.header("x-erro-code","ORDEM_NOT_VALID")
				.header("x-erro-code",ex.getOrdem())
				.build();
	}

}
