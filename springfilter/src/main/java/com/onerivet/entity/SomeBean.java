package com.onerivet.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class SomeBean {

	
	private String name;
	private long mobile;
	@JsonIgnore  
	private long salary;
	
	
	
	public SomeBean(String name, long mobile, long salary) {
		super();
		this.name = name;
		this.mobile = mobile;
		this.salary = salary;
	}



	public SomeBean(String string, String string2, String string3) {
		// TODO Auto-generated constructor stub
	}
}
