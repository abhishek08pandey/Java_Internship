package com.onerivet.entitydto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.validation.constraints.NotEmpty;
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
