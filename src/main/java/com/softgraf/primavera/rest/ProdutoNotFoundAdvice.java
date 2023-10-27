package com.softgraf.primavera.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/*
 * Quando uma exceção do tipo ProdutoNotFoundException for lançada pelo sistema o Spring MVC rederiza um erro HTTP 404
 */
@ControllerAdvice
public class ProdutoNotFoundAdvice {

	@ResponseBody
	@ExceptionHandler(ProdutoNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String produtoNotFoundHandler(ProdutoNotFoundException ex) {
		return ex.getMessage();
	}
}
