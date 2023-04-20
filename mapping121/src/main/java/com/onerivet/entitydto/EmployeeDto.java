package com.onerivet.entitydto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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
