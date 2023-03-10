package com.rivetbank.service;

import java.util.InputMismatchException;
import java.util.Scanner;

import java.sql.ResultSet;

import com.rivetbank.User.User;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class ServiceImpl implements Service {

	static User user;
	static Connection connection = null;
	static Statement statement;

	@Override
	public Connection createDBConnection() {// encrypt=true;trustServerCertificate=true;
		try { // encrypt=false;trustServerCertificate=true/false; connected
			connection = DriverManager.getConnection(// check SSL/TLS by JVM
					"jdbc:sqlserver://localhost:1433;database=rivetbank;encrypt=true;trustServerCertificate=true;",
					"sa", "Admin@123");
			//System.out.println(connection);
			//System.out.println(statement);
			return connection;
		} catch (SQLException e) {

			System.out.println("Database Connection not found");
		}
		return connection;
	}

	@Override
	public boolean adminLogIn() {
		try {
			Scanner verifyAdmin = new Scanner(System.in);
			System.out.println("WELCOME TO ADMIN LOGIN");
			System.out.println("\nEnter Admin Username: ");
			String userId = verifyAdmin.next();
			System.out.println("\nEnter Password: ");
			String password = verifyAdmin.next();
			
			String sql = "SELECT * FROM rivetBankAdmin where userId=? ";
			
//			statement = connection.createStatement();
//			ResultSet verifyUserIdPassword = statement.executeQuery(sql);
			
			PreparedStatement prepaireStatement = connection.prepareStatement(sql);
			prepaireStatement.setString(1, userId);
			ResultSet verifyUserIdPassword = prepaireStatement.executeQuery();
			
			while (verifyUserIdPassword.next()) { 
				if (verifyUserIdPassword.getString(2).equalsIgnoreCase(password) && verifyUserIdPassword.getString(1).equalsIgnoreCase(userId)) {
					return true;
				} else {
					throw new SQLException();
					// System.out.println("Enter valid UserId and Password");
					// adminLogIn();
				}
			}
		} catch (SQLException e) {
			System.out.println("Enter valid Username and Password");
			boolean adminLogIn = adminLogIn();
			return adminLogIn;
		}
		return false;
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

			System.out.println("Enter Account type: ");
			String accountType = insertedData.next();

			System.out.println("Enter Account Number: ");
			long accountNumber = insertedData.nextLong();

			System.out.println("Enter Balance");
			double balance = insertedData.nextDouble();

			System.out.println("Enter age: ");
			int age = insertedData.nextInt();
			
			insertedData.nextLine();
			
			System.out.println("Enter Gender M/F");
	        String gender = insertedData.nextLine();
	        
	        connection.setAutoCommit(false);
	        
	        PreparedStatement statement = connection.prepareStatement("INSERT INTO customer values(?,?,?,?,?,?,?,?,?)");
			
//	        String string = "insert into customer values('" + id + "', '" + name + "', '" + mobileNumber
//					+ "', '" + city + "', l'" + accountType + "', '" + accountNumber + "', '" + balance + "' , '" + age
//					+ "', '" + gender + "')";
//			
			//System.out.println(string);
			//statement.executeUpdate(string);
			
	        statement.setInt(1, id);
	        statement.setString(2, name);
	        statement.setLong(3, mobileNumber);
	        statement.setString(4, city);
	        statement.setString(5, accountType);
	        statement.setLong(6, accountNumber);
	        statement.setDouble(7, balance);
	        statement.setInt(8, age);
	        statement.setString(9, gender);
	        
	        int executeUpdate = statement.executeUpdate();
	        
	        System.out.println("Commit ? Y/N:  ");
	        String commit = insertedData.next();
	        
//	        System.out.println("Rollback ? Y/N: ");
//	        String rollback = insertedData.next();
	        
	        if(commit.equalsIgnoreCase("y")) {
	        	connection.commit();
	        }else {
	        	connection.rollback();
	        }
	        
	        System.out.println(executeUpdate);

			System.out.println("*******************************************");
			System.out.println(name + " ???? Acoount created successfully");
			System.out.println("\nThanks for Using Bank application");
			connection.close();

		} catch (InputMismatchException e) {
			System.out.println("\nWrong input !!!");
			createAccount();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("\nSQLException!!!");
			System.out.println("\nPlease enter unique id!!!");
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				System.out.println("Through Finally Block");
			}
		}

	}

	@Override
	public void accountDetails() {
		try {
			Scanner id = new Scanner(System.in);
			System.out.println("Enter Id: ");
			int getOneId = id.nextInt();

			ResultSet user = statement.executeQuery("SELECT * FROM customer WHERE id='" + getOneId + "' ");
			while (user.next()) {

				System.out.println("\nUser Id:" + user.getInt(1) + "  Name:" + user.getString(2) + "  Mobile Number:"
						+ user.getLong(3) + "  City:" + user.getString(4) + "  Account type:" + user.getString(5)
						+ "  Account Number:" + user.getLong(6) + "  Balance:" + user.getDouble(7) + "  age:"
						+ user.getInt(8) + "  Gender:" + user.getString(9));
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Records not found");
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Through Finally Block");
			}
		}
	}

	@Override
	public void allAccountDetails() {
		try {
			ResultSet user = statement.executeQuery("SELECT * FROM customer");
			System.out.println("Id  Name  Mobile  City  AccountType  Balance  Age  Gender");
			while (user.next()) {

				System.out.println(user.getInt(1) + "  " + user.getString(2) + "  " + user.getLong(3) + "  "
						+ user.getString(4) + "  " + user.getString(5) + "  " + user.getLong(6) + "  "
						+ user.getDouble(7) + "  " + user.getInt(8) + "  " + user.getString(9));
			}
			connection.close();
		} catch (SQLException e) {
			System.out.println("Records not found");
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				System.out.println("Through Finally Block");
			}
		}
	}

	@Override
	public void updateAccount() {
		try {
			System.out.println("Enter Id: ");
			Scanner getOneId = new Scanner(System.in);
			int updateId = getOneId.nextInt();

// This Code will show existing details of that Id
			ResultSet user = statement.executeQuery("SELECT * FROM customer WHERE id='" + updateId + "' ");
			while (user.next()) {

				System.out.println("Existing Details \nUser Id:" + user.getInt(1) + "  Name:" + user.getString(2)
						+ "  Mobile Number:" + user.getLong(3) + "  City:" + user.getString(4) + "  Account type:"
						+ user.getString(5) + "  Account Number:" + user.getLong(6) + "  Balance:" + user.getDouble(7)
						+ "  age:" + user.getInt(8) + "  Gender:" + user.getString(9));
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

			//connection.prepareStatement("UPDATE customer SET name=?, mobileNumber=?, city=? where id=? ");
			statement.executeUpdate("UPDATE customer SET name='" + name + "', mobileNumber='" + mobileNumber
					+ "', city='" + city + "'  where id=" + updateId);

			System.out.println("Id Number:" + updateId + ",  Name:" + name + " details update");
			connection.close();
		} catch (Exception e) {
			System.out.println("User Id does not exist please select correct Id !");
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				System.out.println("Through Finally Block");
			}
		}
	}


	@Override
	public void deleteAccountById() {
		try {
			System.out.println("Enter Id: ");
			Scanner getOneId = new Scanner(System.in);
			int deleteId = getOneId.nextInt();

			int isUpdated = statement.executeUpdate("DELETE customer WHERE id='" + deleteId + "' ");
			System.out.println("\nYour Id Number: " + deleteId + " deleted");
			connection.close();

		} catch (SQLException e) {
			System.out.println("Your Id is not in Database!!!");
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				System.out.println("Through Finally Block");
			}
		}

	}

}
