package com.rivetbank.service;

import java.sql.Connection;

public interface Service {

	public Connection createDBConnection();
	
	public boolean adminLogIn();

	public void createAccount();

	public void accountDetails();

	public void allAccountDetails();

	public void updateAccount();

	public void deleteAccountById();

}
