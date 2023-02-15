package com.bankapp.controller;

import java.util.Scanner;

public class CreateAccount extends Controller {

	public  void createAccount() {
		try {
			Scanner scn = new Scanner(System.in);
			System.out.println("*******************************************");
			System.out.println("Enter Name: ");
			user.name = scn.next();
			System.out.println("Enter Account type: ");
			user.accountType = scn.next();
			System.out.println("Enter Account Number: ");
			user.accountNumber = scn.nextLong();
			System.out.println("Balance: ");
			user.balance = scn.nextDouble();

			System.out.println("*******************************************");
			System.out.println(user.name+" 💆 Acoount created successfully");
			System.out.println("\nThanks for Using Bank application");

			modeCall();
		} catch (Exception e) {
			System.out.println("Enter valid input");
			//modeCall();
			createAccount();
		}
	}
}
