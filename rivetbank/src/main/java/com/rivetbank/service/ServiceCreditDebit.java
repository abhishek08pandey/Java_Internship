package com.rivetbank.service;

import com.rivetbank.User.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ServiceCreditDebit {

	static User user;
	static Statement statement;
	static Service service = new ServiceImpl();

	public void creditAmount() {
		double balance = 0;
		try {
			Connection connection = service.createDBConnection();
			statement = connection.createStatement();

			Scanner input = new Scanner(System.in);
			System.out.println("Enter id: ");
			int id = input.nextInt();
			
			System.out.println("ENTER credit Amount: ");
			double amount = input.nextDouble();
// Check before balance
			ResultSet user = statement.executeQuery("SELECT * FROM customer WHERE id='" + id + "' ");
			while (user.next()) {

				System.out.println("Customer Details \nUser Id:" + user.getInt(1) + "  Name:" + user.getString(2)
						+"  Account Number:" + user.getLong(6) + "  Balance:" + user.getDouble(7));
			
				balance=amount+user.getDouble(7);
			}
			System.out.println("*******************************************");
			
			

			System.out.println(amount);
			System.out.println("next not run");
			System.out.println(balance);
			
			statement.executeUpdate("UPDATE customer SET balance='" + balance + "' where id=" + id);

			while (user.next()) {

				System.out.println("Customer Details \nUser Id:" + user.getInt(1) + "  Name:" + user.getString(2)
						+"  Account Number:" + user.getLong(6) + "  Balance:" + user.getDouble(7));
			
			}
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void debitAmount() {

	}

}
