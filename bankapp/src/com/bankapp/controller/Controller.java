package com.bankapp.controller;

import java.util.Scanner;
import com.bankapp.user.User;

public class Controller {
	
	static User user = new User();
	static Controller controller = new Controller();
	static CreateAccount createAccount = new CreateAccount();
	static BalanceInquiry balanceInquiry = new BalanceInquiry();
	static AccountDetails accountDetails = new AccountDetails();
	static CreditAmount creditAmount = new CreditAmount();
	static WithdrawAmount withdrawAmount = new WithdrawAmount();
	
	public static void main(String[] args) {
		modeCall();
	}

	public static void modeCall() {
		try {
			Scanner scan = new Scanner(System.in);
			System.out.println("*******************************************");
			System.out.println(
					"Mode:\n Create Account 1\n Balance inquiry 2 \n Account Details 3\n Credit Amount 4\n Withdraw Amount 5 \n Exit press: 6");
			String selectedMode = scan.next();
			if (selectedMode.contentEquals("1")) {
				createAccount.createAccount();
			} else if (selectedMode.contentEquals("2") && !user.name.isEmpty()) {
				balanceInquiry.balanceInquiry();
			} else if (selectedMode.contentEquals("3") && !user.name.isEmpty()) {
				accountDetails.accountDetails();
			} else if (selectedMode.contentEquals("4") && !user.name.isEmpty()) {
				creditAmount.creditAmount();
			} else if (selectedMode.contentEquals("5") && !user.name.isEmpty()) {
				withdrawAmount.withdrawAmount();
			} else if (selectedMode.contentEquals("6")) {
				System.out.println("Thanks for Using Bank application");
			} else {
				System.out.println("Choose correct Mode: ");
				modeCall();
			}
		} catch (NullPointerException e) {
			System.out.println("You have to create account, User does not exist");
			modeCall();
		}
	}
}
