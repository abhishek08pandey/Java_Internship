package com.onerivet.entity;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Name {

	private String firstName;
	private String middleName;
	private String lastName;
}
