package com.onerivet.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	//@Embedded
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "employee")
	private Name name;
	//@Embedded
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "employee")
	private Address address;
	private String email;
	private String password;
	private String mobileNumber;
	private int age;
	private boolean status;
}
