package com.bankapp.controller;

public class AccountDetails extends Controller{

	public void accountDetails() {
		System.out.println("*******************************************");
		System.out.println("AccountDetails: \n" + "Name: " + user.name + "\n" + "Account number: " + user.accountNumber
				+ "\n" + "Account type: " + user.accountType + "\n" + "Balance: " + user.balance);
		System.out.println("\nThanks for Using Bank application");
		modeCall();
	}
}
