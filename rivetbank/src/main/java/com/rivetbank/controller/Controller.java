package com.rivetbank.controller;

import java.util.Scanner;

import com.rivetbank.service.Service;
import com.rivetbank.service.ServiceImpl;

public class Controller {
	
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
			System.out.println("*******************************************");
			String selectedMode = scan.next();
			System.out.println("*******************************************");
			
			if (selectedMode.contentEquals("1")) {// Create
				service.createDBConnection();
				service.createAccount();
				mainMenu();
			}
			else if (selectedMode.contentEquals("2")) {// Read
				service.createDBConnection();
				
				System.out.println("Enter Id: ");
				Scanner id = new Scanner(System.in);
				int getOneId = id.nextInt();
				
				service.accountDetails(getOneId);
				mainMenu();
			}
			else if(selectedMode.contentEquals("3")){// Read all
				service.createDBConnection();
				service.allAccountDetails();
				mainMenu();
			}
			else if(selectedMode.contentEquals("4")){// Update
				service.createDBConnection();
				
				System.out.println("Enter Id: ");
				Scanner getOneId = new Scanner(System.in);
				int updateId = getOneId.nextInt();
				
				service.updateAccount(updateId);
				mainMenu();
			}
			else if(selectedMode.contentEquals("5")){// Delete
				service.createDBConnection();
				
				System.out.println("Enter Id: ");
				Scanner getOneId = new Scanner(System.in);
				int deleteId = getOneId.nextInt();
				
				service.deleteAccountById(deleteId);
				mainMenu();
			}
			else if(selectedMode.contentEquals("6")){
				System.out.println("Thanks 🙏 for Using Rivet Bank application");
			}
			else {
				System.out.println("Choose correct Mode: ");
				mainMenu();
			}
		} catch (NullPointerException e) {
			System.out.println("You have to create account, User does not exist");
			mainMenu();
		}
	}
}