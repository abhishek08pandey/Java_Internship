package com.onerivet.exceptionhandling;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DataNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DataNotFoundException(String message) {
		super(message);
	}
}
