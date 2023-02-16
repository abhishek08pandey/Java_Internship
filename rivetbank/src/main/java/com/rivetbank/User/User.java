package com.rivetbank.User;

public class User {

	private int id;//1
	private String name;//2
	private long mobileNumber;//3
	private String city;//4
	private String accountType;//5
	private long accountNumber;//6
	private double balance;//7
	private int age;	//8
	private String gender;//9
		
	public User(int id, String name, long mobileNumber, String city, String accountType, long accountNumber,
			double balance, int age, String gender) {
		super();
		this.id = id;
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.city = city;
		this.accountType = accountType;
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.age = age;
		this.gender = gender;
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
	
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
}
