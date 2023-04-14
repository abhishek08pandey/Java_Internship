package com.onerivet.entitydto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NameDto {

	@NotEmpty(message = "firstName is mandatory")
	private String firstName;
	@NotEmpty(message = "middleName is mandatory")
	private String middleName;
	@NotEmpty(message = "lastName is mandatory")
	private String lastName;
}
