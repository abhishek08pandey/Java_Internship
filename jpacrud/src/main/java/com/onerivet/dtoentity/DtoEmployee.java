package com.onerivet.dtoentity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class  DtoEmployee{

	private int id;
	
	@NotEmpty(message = "First Name is mandatory")
	private String firstName;
	
	@NotEmpty(message = "Last Name is mandatory")
	private String lastName;
	
	@NotEmpty(message = "City Name is mandatory")
	private String city;
	
	@Email(message="Enter valid Email Id.")
	private String email;
	
	@NotEmpty(message = "Password is mandatory")
	private String password;// Default null
	
	@Pattern(message="insert valid input", regexp = "[6-9][0-9]{9}")
	private String mobileNumber;// Default value 0 
	
	@Min(value = 18)
	@Max(value = 125)
	private int age;// Mandatory field
	
	private boolean status;// Default status false
	
//	@NotNull(message = "Adress is mandatory")
//	private AddressDto address;
	
	
}
