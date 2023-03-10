package com.rivetbank.service;

import com.rivetbank.User.User;
import com.rivetbank.controller.Controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ServiceCreditDebit {

	static User user;
	static Statement statement;
	static Service service = new ServiceImpl();
	static Controller controller;
	static Connection connection;

	public void creditAmount() throws SQLException {
		double balance = 0;
		try {
			connection = service.createDBConnection();
			statement = connection.createStatement();

			Scanner input = new Scanner(System.in);
			System.out.println("Enter id: ");
			int id = input.nextInt();

			System.out.println("ENTER credit Amount: ");
			double amount = input.nextDouble();
// Check balance before credit Amount
			if (amount >= 0) {
				ResultSet user = statement.executeQuery("SELECT * FROM customer WHERE id='" + id + "' ");
				while (user.next()) {

					System.out.println("\nCustomer Details before credit Amount \nUser Id:" + user.getInt(1) + "  Name:"
							+ user.getString(2) + "  Account Number:" + user.getLong(6) + "  Balance:"
							+ user.getDouble(7));
					balance = amount + user.getDouble(7);
				}
			} else {
				System.out.println("\nEnter valid amount ! ");
				creditAmount();
			}
			System.out.println("*******************************************");
// 	Enter credit amount		
			int isUpdated = statement.executeUpdate("UPDATE customer SET balance='" + balance + "' where id='" + id + "' ");
			
			if(isUpdated !=0) {
				System.out.println("\nAmount succesfully credited: " + amount);
				System.out.println("*******************************************");
			}
			else{
				System.out.println("Enter valid id!!!");
				creditAmount();
			}
			
// Check balance After credit Amount
			ResultSet getBalanceUpdate = statement.executeQuery("SELECT * FROM customer WHERE id='" + id + "' ");
			while (getBalanceUpdate.next()) {

				System.out.println("\nCustomer Details After credit Amount \nUser Id:" + getBalanceUpdate.getInt(1)
						+ "  Name:" + getBalanceUpdate.getString(2) + "  Account Number:" + getBalanceUpdate.getLong(6)
						+ "  Balance:" + getBalanceUpdate.getDouble(7));
			}
// Again call Main Menu				
			controller.mainMenu();
			connection.close();

		} catch (InputMismatchException input) {
			// input.printStackTrace();
			connection.close();
			System.out.println("\nEnter valid Details ! by InputMismatchException");
			creditAmount();

		} catch (SQLException e) {
			connection.close();
			e.printStackTrace();
			System.out.println("\nEnter valid Details SQL! ");
			creditAmount();
		}
	}

	public void debitAmount() throws SQLException {

		double balance = 0;
		try {
			connection = service.createDBConnection();
			statement = connection.createStatement();

			Scanner input = new Scanner(System.in);
			System.out.println("Enter id: ");
			int id = input.nextInt();

			System.out.println("ENTER Withdraw Amount: ");
			double amount = input.nextDouble();
// Check balance before credit Amount
			if (amount >= 0) {

				ResultSet user = statement.executeQuery("SELECT * FROM customer WHERE id='" + id + "' ");
				while (user.next()) {

					System.out.println("\nCustomer Details before Withdraw Amount \n \nUser Id:" + user.getInt(1)
							+ "  Name:" + user.getString(2) + "  Account Number:" + user.getLong(6) + "  Balance:"
							+ user.getDouble(7));
					if (user.getDouble(7) < amount) {
						System.out.println("\nInsufficient Balance !");
						controller.mainMenu();
					} else {
						balance = user.getDouble(7) - amount;
					}
				}
			} else {
				System.out.println("\nEnter valid amount ! ");
				debitAmount();
			}
			System.out.println("*******************************************");
// 	Enter credit amount		
			int isUpdated = statement.executeUpdate("UPDATE customer SET balance='" + balance + "' where id='" + id + "' ");
			if(isUpdated !=0) {
				System.out.println("\nAmount succesfully withdraw: " + amount);
				System.out.println("*******************************************");
			}
			else{
				System.out.println("Enter valid id!!!");
			}
// Check balance After credit Amount
			ResultSet getBalanceUpdate = statement.executeQuery("SELECT * FROM customer WHERE id='" + id + "' ");
			while (getBalanceUpdate.next()) {

				System.out.println("\nCustomer Details After Withdraw Amount \nUser Id:" + getBalanceUpdate.getInt(1)
						+ "  Name:" + getBalanceUpdate.getString(2) + "  Account Number:" + getBalanceUpdate.getLong(6)
						+ "  Balance:" + getBalanceUpdate.getDouble(7));
			}
// Again call Main Menu			
			controller.mainMenu();
			connection.close();
		} catch (SQLException e) {
			connection.close();
			System.out.println("\nEnter valid amount ! ");
			creditAmount();
		}
	}

}
