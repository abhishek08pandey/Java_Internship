package com.onerivet.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "employees")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String firstName;
	private String lastName;
	private String city;
	private String email;
	private String password;
	private String mobileNumber;
	private int age;
	private boolean status;

//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "address", referencedColumnName = "id")
//	private Address address;

//	@OneToOne(cascade = CascadeType.ALL, mappedBy = "employee")
//    private Address address;
	
}
