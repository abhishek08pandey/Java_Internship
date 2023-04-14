package com.onerivet.entitydto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDto {

	
	private long id;
	@Valid
	private NameDto name;
	@Valid
	private AddressDto address;
	
	@Email(message="Enter valid Email Id")
	private String email;
	
	@NotEmpty(message = "Password is mandatory")
	private String password;
	
	@Pattern(message="insert valid input", regexp = "[6-9][0-9]{9}")
	private String mobileNumber;
	
	@Min(value = 18)
	@Max(value = 125)
	private int age;
	
	private boolean status;
}
