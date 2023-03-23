package com.rivet.secondmaven;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name= "tablestudent")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	public void setId(int id) {
		this.id=id;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Student(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Student() {
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
	
	
}
