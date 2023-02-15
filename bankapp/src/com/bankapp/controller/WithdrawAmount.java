package com.bankapp.controller;

import java.util.Scanner;

public class WithdrawAmount extends Controller{

	public void withdrawAmount() {

		if (user.name.contentEquals(user.name)) {
			Scanner scn = new Scanner(System.in);
			System.out.println("Enter Withdraw Amount: ");
			double WithdrawAmount = scn.nextDouble();

			if (user.balance >= 0 && WithdrawAmount>=0) {
				user.balance = user.balance - WithdrawAmount;
				System.out.println("After Withdraw Amount Balance: " + user.balance);
				modeCall();
			} else {
				System.out.println("Invalid Inputs");
				withdrawAmount();
			}
		} else {
			System.out.println("User does not exist");
		}
	}
}
