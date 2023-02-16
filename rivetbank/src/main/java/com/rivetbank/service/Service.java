package com.rivetbank.service;

import java.sql.Connection;

public interface Service {

	public Connection createDBConnection();
	
	public boolean adminLogIn();

	public void createAccount();

	public void accountDetails(int id);

	public void allAccountDetails();

	public void updateAccount(int updateRecord);

	public void deleteAccountById(int deleteId);

}
