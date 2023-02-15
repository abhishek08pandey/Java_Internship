package com.rivetbank.service;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.sql.ResultSet;

import com.rivetbank.User.User;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class ServiceImpl implements Service {

	static User user;
	static Connection connection;
	static Statement statement;

	@Override
	public void createDBConnection() {
		try {
			connection = DriverManager.getConnection(
					"jdbc:sqlserver://localhost:1433;database=rivetbank;encrypt=true;trustServerCertificate=true;",
					"sa", "Admin@123");
			statement = connection.createStatement();

		} catch (SQLException e) {
			System.out.println("Connection not created");
		}
	}

	@Override
	public void createAccount() {
		try {
			Scanner insertedData = new Scanner(System.in);

			System.out.println("Enter id: ");
			int id = insertedData.nextInt();

			System.out.println("Enter Name: ");
			String name = insertedData.next();

			System.out.println("Enter Mobile Number: ");
			long mobileNumber = insertedData.nextLong();

			System.out.println("Enter City: ");
			String city = insertedData.next();

			System.out.println("Enter age: ");
			int age = insertedData.nextInt();

			statement.executeUpdate("insert into users values('" + id + "', '" + name + "', '" + mobileNumber + "', '"
					+ city + "', '" + age + "')");

			System.out.println("*******************************************");
			System.out.println(name + " 💆 Acoount created successfully");
			System.out.println("\nThanks for Using Bank application");
			connection.close();

		} catch (InputMismatchException e) {
			System.out.println("\nWrong input !!!");
			createAccount();
		} catch (SQLException e) {
			System.out.println("\nSQLException!!!");
			System.out.println("\nPlease enter unique id!!!");
			createAccount();
		}

	}

	@Override
	public void accountDetails(int getOneId) {
		try {
			ResultSet user = statement.executeQuery("SELECT * FROM users WHERE id='" + getOneId + "' ");
			while (user.next()) {

				System.out.println("User Id:" + user.getInt(1) + "  Name:" + user.getString(2) + "  Mobile Number:"
						+ user.getLong(3) + "  City:" + user.getString(4) + "  Age:" + user.getInt(5));
			}
			connection.close();
		} catch (SQLException e) {
			System.out.println("Records not found");
		}
	}

	@Override
	public void allAccountDetails() {
		try {
			ResultSet user = statement.executeQuery("SELECT * FROM users");
			System.out.println("Id  Name  Mobile  City  Age");
			while (user.next()) {

				System.out.println(user.getInt(1) + "  " + user.getString(2) + "  " + user.getLong(3) + "  "
						+ user.getString(4) + "  " + user.getInt(5));
			}
			connection.close();
		} catch (SQLException e) {
			System.out.println("Records not found");
		}
	}

	@Override
	public void updateAccount(int updateId) {
		try {
			// This Code will show existing details of that Id
			ResultSet user = statement.executeQuery("SELECT * FROM users WHERE id='" + updateId + "' ");
			while (user.next()) {

				System.out.println("Existing Details \nUser Id:" + user.getInt(1) + "  Name:" + user.getString(2)
						+ "  Mobile Number:" + user.getLong(3) + "  City:" + user.getString(4) + "  Age:"
						+ user.getInt(5));
			}
			System.out.println("*******************************************");
			// This code will update that User Id details
			Scanner updateRecord = new Scanner(System.in);
			System.out.println("Update Name: ");
			String name = updateRecord.next();

			System.out.println("Update Mobile Number: ");
			long mobileNumber = updateRecord.nextLong();

			System.out.println("Update City: ");
			String city = updateRecord.next();

			System.out.println("Update age: ");
			int age = updateRecord.nextInt();

			statement.executeUpdate("UPDATE users SET name='" + name + "', mobileNumber='" + mobileNumber + "', city='"
					+ city + "', age='" + age + "' where id=" + updateId);
			System.out.println("Id Number:" + updateId + ",  Name:" + name + " details update");

		} catch (Exception e) {
			System.out.println("User Id does not exist please select correct Id !");
			System.out.println();
		}
	}

	@Override
	public void deleteAccountById(int deleteId) {
		try {
			statement.executeUpdate("DELETE users WHERE id='" + deleteId + "' ");
			System.out.println("Your Id Number: " + deleteId + " deleted");
			connection.close();
		} catch (SQLException e) {
			System.out.println("Your Id is not in Database!!!");
			e.printStackTrace();
		}

	}

}
