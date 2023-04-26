package com.onerivet.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.onerivet.entity.Employee;

@ControllerAdvice

public class EmployeeExceptionController {

	@ExceptionHandler(value = DataNotFoundException.class)
	public ResponseEntity<Employee> exception(DataNotFoundException exception) {
		return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
	}
}
