package com.onerivet.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name="employee_details")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	private String name;
// , mappedBy = "employee" It is used when we don't need to address column in main entity
	@OneToOne(cascade = CascadeType.ALL)
	//@OneToMany(cascade = CascadeType.ALL)
	private Address address;
	
	private String email;
	private String password;
	private String mobile;
	
}
