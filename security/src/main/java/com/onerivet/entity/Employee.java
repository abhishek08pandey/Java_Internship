package com.onerivet.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
