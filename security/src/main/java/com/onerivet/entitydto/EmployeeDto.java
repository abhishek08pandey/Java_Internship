package com.onerivet.entitydto;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class EmployeeDto {

	private long id;
	@NotNull(message = "Invalid Name enter !")
	private String name;
	
	@Valid
	private AddressDto address;
	
    @Email(message="Invalid Email Enter !")
	private String email;
    
	private String password;
	
	@Pattern(regexp = "[6-9][0-9]{9}")
	private String mobile;
	
}
