package com.onerivet.exception;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.onerivet.entitydto.Api_Response;

@RestControllerAdvice
public class GlobalExceptionHandler extends RuntimeException {
	
	@ExceptionHandler(DataNotFoundException.class)
	public Api_Response resourceNotFoundHandler(DataNotFoundException rn) {
		
		String message = rn.getMessage();
		LocalDate now = LocalDate.now();
		
		return new Api_Response(message, now);
		
		
	}
	

}
