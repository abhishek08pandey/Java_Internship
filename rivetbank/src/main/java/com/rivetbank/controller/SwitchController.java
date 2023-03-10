package com.rivetbank.controller;

import java.util.Scanner;

import com.rivetbank.service.Service;
import com.rivetbank.service.ServiceImpl;

public class SwitchController {

	static Service service = new ServiceImpl();

	public static void main(String[] args) {
		mainMenu();
	}

	public static void mainMenu() {
		try {
			Scanner scan = new Scanner(System.in);
			System.out.println("*******************************************");
			System.out.println(
					"Mode:\n Create Account 1\n Person Account Details 2 \n All Account Details 3\n Update Account 4\n Delete Amount 5 \n Exit press: 6");
			String selectedMode = scan.next();
			System.out.println("*******************************************");

			switch (selectedMode) {
			case "1":
				service.createDBConnection();// Create
				service.createAccount();
				mainMenu();
				break;

			case "2":
				service.createDBConnection();

				System.out.println("Enter Id: ");
				Scanner id = new Scanner(System.in);
				int getOneId = id.nextInt();

				//service.accountDetails(getOneId);// Read One Record
				mainMenu();
				break;

			case "3":
				service.createDBConnection(); //Read All Records
				service.allAccountDetails();
				mainMenu();
				break;

			case "4":
				service.createDBConnection();

				System.out.println("Enter Id: ");
				Scanner updateOneId = new Scanner(System.in);
				int updateId = updateOneId.nextInt(); // Update One Record

				//service.updateAccount(updateId);
				mainMenu();
				break;

			case "5":
				service.createDBConnection();

				System.out.println("Enter Id: ");
				Scanner deleteOneId = new Scanner(System.in);
				int deleteId = deleteOneId.nextInt();

				//service.deleteAccountById(deleteId); // Delete One Record
				mainMenu();
				break;

			case "6":
				System.out.println("Thanks 🙏 for Using Rivet Bank application");// Exit 
				break;
			default:
				System.out.println("Choose correct Mode: ");
				mainMenu();
				break;
			}

		} catch (NullPointerException e) {
			System.out.println("You have to create account, User does not exist");
			mainMenu();
		}
	}
}
