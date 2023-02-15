package com.bankapp.controller;

import java.util.Scanner;

public class CreditAmount extends Controller{

	public void creditAmount() {

		if (user.name.contentEquals(user.name)) {
			Scanner scn = new Scanner(System.in);
			System.out.println("Enter Credit Amount: ");
			double addAmount = scn.nextDouble();

			if (user.balance >= 0 && addAmount>=0) {
				user.balance = addAmount+user.balance;
				
				System.out.println("After Credited Amount Balance: " + user.balance);
				modeCall();
			} else {
				System.out.println("Invalid Inputs");
				creditAmount();
			}
		} else {
			System.out.println("User does not exist");
		}
	}
}
