package com.rivetbankwithservlet.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.rivetbankwithservlet.user.RivetBankAdmin;
import com.rivetbankwithservlet.user.User;

public class DAOServiceImpl {

	static Connection connection = null;
	static Statement statement;

// Return Connection object
	public static Connection dbConnection() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connection = DriverManager.getConnection(
					"jdbc:sqlserver://localhost:1433;database=rivetbank;encrypt=false;", "sa", "Admin@123");
			System.out.println("connect DB Connection");
			return connection;

		} catch (Exception e) {
			System.out.println("database not connect");
			e.printStackTrace();
		}
		return connection;
	}

// Login credential verify
	public static boolean verifyCredential(RivetBankAdmin admin) throws SQLException {
		try {
			connection = dbConnection();
			PreparedStatement prepareStatement = connection.prepareStatement("SELECT * FROM rivetbankadmin");
			ResultSet result = prepareStatement.executeQuery();

			while (result.next()) {
				if (result.getString(1).equals(admin.getUserId()) && result.getString(2).equals(admin.getPassword())) {

					return true;
				}
			}
		} catch (Exception e) {
			System.out.println("Veryfy exception");
			e.printStackTrace();
		}
		return false;
	}

// Add new User and Insert query
	public static int addUser(User user) {
		int status = 0;

		try {
			connection = DAOServiceImpl.dbConnection();
			System.out.println("add user first: " + status);
			PreparedStatement prepareStatement = connection
					.prepareStatement("INSERT INTO servletuser VALUES(?, ?, ?, ?)");
			prepareStatement.setString(1, user.getName());
			prepareStatement.setString(2, user.getEmail());
			prepareStatement.setString(3, user.getCity());
			prepareStatement.setLong(4, user.getMobileNumber());

			status = prepareStatement.executeUpdate();
			System.out.println("add user last: " + status);

		} catch (NumberFormatException e) {
			System.out.println("NumberFormatException");
		} catch (Exception e) {
			System.out.println("exception in addUser method");
			e.printStackTrace();
		}
		System.out.println("add user return: " + status);
		return status;
	}

// Return All Records in ResultSet 
	public static ResultSet listOfRecords() {
		try {
			connection = dbConnection();
			PreparedStatement prepareStatement = connection.prepareStatement("SELECT * FROM servletuser");
			ResultSet result = prepareStatement.executeQuery();

			return result;

		} catch (Exception e) {
			System.out.println("Veryfy exception");
			e.printStackTrace();
		}
		return null;
	}
// Delete By Id 
	public static boolean deleteRecord(int id) {
		try {
			connection = DAOServiceImpl.dbConnection();
			PreparedStatement prepareStatement = connection.prepareStatement("DELETE FROM servletuser WHERE ID=?");

			prepareStatement.setInt(1, id);
			int status = prepareStatement.executeUpdate();

			if (status == 1) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			System.out.println("from delete method");
			e.printStackTrace();
		}

		return false;

	}
// Get perticuler Id Details	
	public static ResultSet idDetails(int id) {
		try {
		connection = DAOServiceImpl.dbConnection();
		PreparedStatement prepareStatement = connection.prepareStatement("SELECT * FROM servletuser WHERE ID=?");

		prepareStatement.setInt(1, id);
		ResultSet idDetails = prepareStatement.executeQuery();
		return idDetails;
		
		}catch (Exception e) {
			System.out.println("from delete method");
			e.printStackTrace();
		}
		return null;
	}
// Update Query 	
	public static int update(User user) {
		int status = 0;
		System.out.println(status);
		try {
		connection = DAOServiceImpl.dbConnection();
		PreparedStatement prepareStatement = connection.prepareStatement("UPDATE servletuser SET name=?, email=?, city=?, mobileNumber=? WHERE id=? ");
		prepareStatement.setString(1, user.getName());
		prepareStatement.setString(2, user.getEmail());
		prepareStatement.setString(3, user.getCity());
		prepareStatement.setLong(4, user.getMobileNumber());
		prepareStatement.setInt(5, user.getId());
		
		status = prepareStatement.executeUpdate();
		System.out.println("check: "+ status);
		return status;
		
		}catch (Exception e) {
			System.out.println("exception in update method");
			e.printStackTrace();
		}
		return status;
	}

}
