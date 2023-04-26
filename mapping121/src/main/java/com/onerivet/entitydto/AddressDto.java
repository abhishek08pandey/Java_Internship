package com.onerivet.entitydto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.onerivet.view.Views;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@JsonIgnoreProperties(value = {"employeeDto"})
public class AddressDto {

	private long id;
	
	//@Pattern(regexp = "^[\\p{L} .'-]+$")// For any  language
	@Pattern(regexp = "[a-zA-Z]+\\.?")
	@JsonView(value = Views.User.class)
	@NotEmpty(message = "City is Mandatory !")
	private String city;
	
	@Pattern(regexp = "[a-zA-Z]+\\.?")
	@JsonView(value = Views.Admin.class)
	@NotEmpty(message = "State is Mandatory !")
	private String state;
	
	@JsonIgnore //for remove column 
	@JsonView(value = Views.Admin.class)
	private EmployeeDto employeeDto;
}
