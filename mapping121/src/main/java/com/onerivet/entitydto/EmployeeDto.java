package com.onerivet.entitydto;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
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
