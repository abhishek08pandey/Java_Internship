package com.jspcrudproject.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.jspcrudproject.user.RivetBankAdmin;
import com.jspcrudproject.user.User;


public class DAOServiceImpl {

	static Connection connection = null;
	static Statement statement;
	static User user = new User();

// Return Connection object
	public static Connection dbConnection() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=rivetbank;encrypt=false",
					"sa", "Admin@123");
			System.out.println("connect DB Connection");
			return connection;

		} catch (Exception e) {
			System.out.println("database not connect");
			e.printStackTrace();
		}
		return connection;
	}

// Add new User and Insert query
	public static int addUser(User user) {
		int status = 0;

		try {
			connection = DAOServiceImpl.dbConnection();
			PreparedStatement prepareStatement = connection.prepareStatement("INSERT INTO jspusers VALUES(?, ?, ?)");
			prepareStatement.setString(1, user.getName());
			prepareStatement.setString(2, user.getEmail());
			prepareStatement.setString(3, user.getPassword());

			status = prepareStatement.executeUpdate();
			System.out.println("after executeUpdate : " + status);

		} catch (NumberFormatException e) {
			System.out.println("NumberFormatException");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("exception in addUser method");
			e.printStackTrace();
		}
		System.out.println("add user return: " + status);
		return status;
	}

// Login credential verify
	public static boolean verifyCredential(RivetBankAdmin admin) throws SQLException {
		try {
			connection = dbConnection();
			PreparedStatement prepareStatement = connection.prepareStatement("SELECT * FROM rivetbankadmin");
			ResultSet result = prepareStatement.executeQuery();

			while (result.next()) {
				System.out.println(result.getString(1));
				System.out.println(result.getString(2));
				if (result.getString(1).equals(admin.getUserId()) && result.getString(2).equals(admin.getPassword())) {

					return true;
				}
			}
		} catch (Exception e) {
			System.out.println("Not login exception");
			e.printStackTrace();
		}
		return false;
	}

// Return All Records in ResultSet 
	public static ResultSet listOfRecords() {
		try {
			connection = dbConnection();
			PreparedStatement prepareStatement = connection.prepareStatement("SELECT * FROM jspusers");
			ResultSet list = prepareStatement.executeQuery();

			return list;

		} catch (Exception e) {
			System.out.println("Veryfy exception");
			e.printStackTrace();
		}
		return null;
	}

	// Get perticuler Id Details
	public static User idDetails(int id) {
		try {
			
			connection = DAOServiceImpl.dbConnection();
			PreparedStatement prepareStatement = connection.prepareStatement("SELECT * FROM jspusers WHERE ID=?");

			prepareStatement.setInt(1, id);
			ResultSet idDetails = prepareStatement.executeQuery();

			while (idDetails.next()) {

				user.setId(idDetails.getInt(1));
				user.setName(idDetails.getString(2));
				user.setEmail(idDetails.getString(3));
				user.setPassword(idDetails.getString(4));
			}

			return user;

		} catch (Exception e) {
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
			PreparedStatement prepareStatement = connection.prepareStatement("UPDATE jspusers SET name=?, email=?, password=? WHERE id=? ");
			prepareStatement.setString(1, user.getName());
			prepareStatement.setString(2, user.getEmail());
			prepareStatement.setString(3, user.getPassword());
			prepareStatement.setInt(4, user.getId());
			
			status = prepareStatement.executeUpdate();
			System.out.println("check: "+ status);
			return status;
			
			}catch (Exception e) {
				System.out.println("exception in update method");
				e.printStackTrace();
			}
			return status;
		}
		// Delete By Id 
		public static boolean deleteRecord(int id) {
			try {
				connection = DAOServiceImpl.dbConnection();
				PreparedStatement prepareStatement = connection.prepareStatement("DELETE FROM jspusers WHERE ID=?");

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

}
