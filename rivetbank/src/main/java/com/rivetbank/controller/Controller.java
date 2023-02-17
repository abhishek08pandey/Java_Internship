package com.rivetbank.controller;

import java.sql.Connection;
import java.util.Scanner;
import com.rivetbank.service.Service;
import com.rivetbank.service.ServiceCreditDebit;
import com.rivetbank.service.ServiceImpl;

public class Controller {

	static Service service = new ServiceImpl();
	static ServiceCreditDebit serviceCreditDebit = new ServiceCreditDebit();

	public static void main(String[] args) {
		Connection connection = service.createDBConnection();// Login feature
		if (connection != null) {
			boolean adminLogIn = service.adminLogIn();
			if (adminLogIn) {
				mainMenu();
			}
		}else {
			System.out.println("Database Connection not found");
		}
		mainMenu();
	}

	public static void mainMenu() {
		try {
			Scanner scan = new Scanner(System.in);
			System.out.println("*******************************************");
			System.out.println(
					"Mode:\n Create Account: 1\n Person Account Details: 2 "
					+ "\n All Account Details: 3\n Update Account: 4\n Delete Account: "
					+ " 5 \n LogOut: 6 \n Credit Amount: 7 \n Withdraw amount: 8 \n Exit press: 9");
			System.out.println("*******************************************");
			String selectedMode = scan.next();
			System.out.println("*******************************************");

			if (selectedMode.contentEquals("1")) {// Create
				service.createDBConnection();
				service.createAccount();
				mainMenu();
			} else if (selectedMode.contentEquals("2")) {// Read
				service.createDBConnection();

				System.out.println("Enter Id: ");
				Scanner id = new Scanner(System.in);
				int getOneId = id.nextInt();

				service.accountDetails(getOneId);
				mainMenu();
			} else if (selectedMode.contentEquals("3")) {// Read all
				service.createDBConnection();
				service.allAccountDetails();
				mainMenu();
			} else if (selectedMode.contentEquals("4")) {// Update
				service.createDBConnection();

				System.out.println("Enter Id: ");
				Scanner getOneId = new Scanner(System.in);
				int updateId = getOneId.nextInt();

				service.updateAccount(updateId);
				mainMenu();
			} else if (selectedMode.contentEquals("5")) {// Delete
				service.createDBConnection();

				System.out.println("Enter Id: ");
				Scanner getOneId = new Scanner(System.in);
				int deleteId = getOneId.nextInt();

				service.deleteAccountById(deleteId);
				mainMenu();
			} else if (selectedMode.contentEquals("6")) {// LogOut
				if (service.adminLogIn()) {
					mainMenu();
				}
			}else if (selectedMode.contentEquals("7")) {// Credit
				serviceCreditDebit.creditAmount();
			}
			else if (selectedMode.contentEquals("8")) {// Withdraw
				serviceCreditDebit.debitAmount();
			}
			else if (selectedMode.contentEquals("9")) {
				System.out.println("Thanks 🙏 for Using Rivet Bank application");
			} else {
				System.out.println("Choose correct Mode: ");
				mainMenu();
			}
		} catch (NullPointerException e) {
			System.out.println("You have to create account, User does not exist");
			mainMenu();
		}
	}
}