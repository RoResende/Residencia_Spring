package org.serratec.javabackend.projetofinal.controllers;

import javax.validation.ConstraintViolationException;

import org.serratec.javabackend.projetofinal.exceptions.ItemNaoDisponivelException;
import org.serratec.javabackend.projetofinal.exceptions.ItemNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(ItemNotFoundException.class)
	public ResponseEntity<String> trataItemNotFound(ItemNotFoundException e) {
		return ResponseEntity
				.notFound()
				.header("error-code", "DATA_NOT_FOUND")
				.header("error-value", String.valueOf(e.getId()))
				.build();
	}
	
	@ExceptionHandler(ItemNaoDisponivelException.class)
	public ResponseEntity<String> trataItemNotFound(ItemNaoDisponivelException e) {
		return ResponseEntity
				.badRequest()
				.header("error-code", "PRODUCT_NOT_AVAILABLE")
				.header("error-value", String.valueOf(e.getId()))
				.build();
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<String> trataConstraintError(ConstraintViolationException e) {
		return ResponseEntity
				.badRequest()
				.header("error-code", "VALIDATION_ERROR")
				.header("error-message", e.getMessage())
				.build();
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<String> trataValidacao(MethodArgumentNotValidException e){
		return ResponseEntity
				.badRequest()
				.header("error-code", "INVALID_ARGUMENT")
				.header("error-message", e.getMessage())
				.build();
		
	}

}
