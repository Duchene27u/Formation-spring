package fr.sparks.plage.controller.rest;


import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice; 

@RestControllerAdvice
public class PlageRestControllerAdvice {
	
	@ExceptionHandler(javax.validation.ConstraintViolationException.class)
	@ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
	public List<String> traiterDonneesInvalidesAvecDetails(ConstraintViolationException exception) {
		return exception.getConstraintViolations().stream().map(ConstraintViolation::getMessage)
				.collect(Collectors.toList());
	}

	@ExceptionHandler({ DataIntegrityViolationException.class })
	public ResponseEntity<Exception> handle(Exception e, Locale locale) {
		return ResponseEntity.status(400).body(new DataIntegrityViolationException(e.getMessage()));
	}
}