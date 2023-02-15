package com.rivetbank.service;


public interface Service {

	public void createDBConnection();

	public void createAccount();

	public void accountDetails(int id);

	public void allAccountDetails();

	public void updateAccount(int updateRecord);

	public void deleteAccountById(int deleteId);

}
