package com.onerivet.entitydto;


import com.fasterxml.jackson.annotation.JsonView;
import com.onerivet.view.Views;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class EmployeeDto {

	private long id;
	
	@JsonView(value = Views.User.class)
	@Pattern(regexp = "[a-zA-Z]+\\.?")
	@NotEmpty(message = "Name is Mandatory !")
	private String name;
	
	@JsonView(value =  Views.User.class)
	@Valid
	private AddressDto address;
	
	@NotEmpty(message="Email is Mandatory !")
    @Email(message="Invalid Email Enter !")
	private String email;
    
	@NotEmpty(message="Password is Mandatory !")
    @JsonView(value = Views.Admin.class)
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*_=+-]).{8,12}$", message = "Enter valid Password "
			+ "At least 1 Uppercase"
			+ "At least 1 Lowercase"
			+ "At least 1 Number"
			+ "At least 1 Symbol, symbol allowed --> !@#$%^&*_=+-"
			+ "Min 8 chars and Max 12 chars")
	private String password;
	
	
    @NotEmpty(message="Mobile Number is Mandatory !")
	@Pattern(regexp = "[6-9][0-9]{9}", message = "Enter valid Mobile Number !")
	private String mobile;
    
}
