package com.onerivet.dtoentity;

import com.onerivet.entity.Employee;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddressDto {

	private Long id;
	private int flateNo;
	private String area;
	private String city;
	private String state;
	private Employee employee;
}

