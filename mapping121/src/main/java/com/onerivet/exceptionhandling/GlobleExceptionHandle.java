package com.onerivet.exceptionhandling;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.onerivet.exceptionhandling.classes.ApiException;

@RestControllerAdvice
public class GlobleExceptionHandle extends RuntimeException {

	private static final long serialVersionUID = 1L;

	@ExceptionHandler(DataNotFoundException.class)
	public ApiException getApiException(DataNotFoundException dataNotFoundException) {

//		String message = dataNotFoundException.getMessage();
//		LocalDate date = LocalDate.now();
//		LocalTime time = LocalTime.now();
//		
//		return new ApiException(message, date, time);

		return new ApiException(dataNotFoundException.getMessage(), LocalDate.now(), LocalTime.now());
		// return (()-> (message, date, time));
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleMethodArguments(MethodArgumentNotValidException methodArgs) {

		Map<String, String> response = new HashMap<>();

		BindingResult bindingResult = methodArgs.getBindingResult();
		
		List<ObjectError> allErrors = bindingResult.getAllErrors();
		
		
		
		
//		BindingResult bindingResult = methodArgs.getBindingResult();
//
//		List<ObjectError> allErrors = bindingResult.getAllErrors();
//
//		FieldError FieldError = new FieldError(detailMessage, detailMessage, detailMessage);
//		
//		String field = FieldError.getField();
//
//		ObjectError ObjectError = new ObjectError(getLocalizedMessage(), getMessage());
//
//		String defaultMessage = ObjectError.getDefaultMessage();

		methodArgs.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String message = error.getDefaultMessage();
			response.put(fieldName, message);
		});
		return response;
	}
}
