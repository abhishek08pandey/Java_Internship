package com.onerivet.exceptionhandling.classes;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class ApiException {
	
	private String message;
	private LocalDate localDate;
	private LocalTime localTime;

}
