package com.rivetbank.User;

public class User {

	private int id;
	private String name;
	private long mobileNumber;
	private String city;
	private int age;
		
	public User(int id, String name, long mobileNumber, String city, int age) {
		this.id = id;
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.city = city;
		this.age = age;
	}
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
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", mobileNumber=" + mobileNumber + ", city=" + city + ", age="
				+ age + "]";
	}
	
	
}
