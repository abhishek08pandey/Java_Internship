package com.rivetbank.batchprocesser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchProcess {

	public static void main(String[] args) throws SQLException, IOException {// Instead of executing a single query, we
																				// can execute a batch (group) of
																				// queries. It makes the performance
																				// fast.

		Connection con = DriverManager.getConnection(
				"jdbc:sqlserver://localhost:1433;database=rivetbank;encrypt=true;trustServerCertificate=true", "sa",
				"Admin@123");

// 1st Batch
		// Statement st = con.createStatement();
		// st.addBatch("INSERT INTO jdbc values(1, 'abhi','vapi')");
		// st.addBatch("INSERT INTO jdbc values(2, 'abhishek', 'valsad')");

		// int[] executeBatch = st.executeBatch();
		// System.out.println(executeBatch);

// 2nd Batch
		PreparedStatement ps = con.prepareStatement("INSERT INTO jdbc VALUES(?,?,?)");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {

			System.out.println("enter id");
			String s1 = br.readLine();
			int id = Integer.parseInt(s1);

			System.out.println("enter name");
			String name = br.readLine();

			System.out.println("enter city");
			String city = br.readLine();

			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setString(3, city);

			ps.addBatch();
			System.out.println("Want to add more records y/n");
			String ans = br.readLine();
			
			if (ans.equals("n")) {
				break;
			}

		}
		ps.executeBatch();// for executing the batch return type array	

		System.out.println("record successfully saved");

		con.close();
	}

}
