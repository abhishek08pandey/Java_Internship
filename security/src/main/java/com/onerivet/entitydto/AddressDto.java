package com.onerivet.entitydto;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@JsonIgnoreProperties(value = {"employeeDto"})
public class AddressDto {

	private long id;
	
	@NotEmpty(message = "Invalid City enter !")
	private String city;
	
	@NotEmpty(message = "Invalid State enter !")
	private String state;
	
	@JsonIgnore
	private EmployeeDto employeeDto;
}
