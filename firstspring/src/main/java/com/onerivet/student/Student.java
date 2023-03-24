package com.onerivet.student;

public class Student {

	private int id;
	private String name;
	private String email;
	private String password;
	private Adress adress;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Adress getAdress() {
		return adress;
	}
	public void setAdress(Adress adress) {
		this.adress = adress;
	}
	public Student(int id, String name, String email, String password, Adress adress) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.adress = adress;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
