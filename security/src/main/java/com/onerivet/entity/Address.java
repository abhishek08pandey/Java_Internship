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
@Table(name="addresses")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="address_id")
	private long id;
	
	private String city;
	private String state;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "address")// Bidirectional 
//	 @ManyToOne
//	 @JoinColumn(name="employee_id")
    private Employee employee;
}
