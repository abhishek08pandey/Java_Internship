package com.onerivet.entitydto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDto {

	private long id;
	
	@NotEmpty(message = "Invalid City enter !")
	private String city;
	
	@NotEmpty(message = "Invalid State enter !")
	private String state;
	
   // private Employee employee;
}
