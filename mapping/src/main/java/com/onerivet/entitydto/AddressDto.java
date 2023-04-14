package com.onerivet.entitydto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDto {
	@NotNull(message = "flateHouseNo is mandatory")
	private int flateHouseNo;
	@NotEmpty(message = "area is mandatory")
	private String area;
	@NotEmpty(message = "city is mandatory")
	private String city;
	@NotEmpty(message = "state is mandatory")
	private String state;
}
