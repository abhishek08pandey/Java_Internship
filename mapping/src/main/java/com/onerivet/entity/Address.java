package com.onerivet.entity;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Address {

	private int flateHouseNo;
	private String area;
	private String city;
	private String state;
}
