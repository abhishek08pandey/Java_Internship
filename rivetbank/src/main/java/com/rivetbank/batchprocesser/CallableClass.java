package com.rivetbank.batchprocesser;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CallableClass {

	public static void main(String[] args) throws SQLException {
		
		Connection con = DriverManager.getConnection(
				"jdbc:sqlserver://localhost:1433;database=rivetbank;encrypt=true;trustServerCertificate=true", "sa",
				"Admin@123");
		
		CallableStatement statement = con.prepareCall("{call list}");
		ResultSet rs = statement.executeQuery();
		
//		boolean execute = statement.execute();// it is just check execution happen or not 
//		System.out.println(execute);
		
		while(rs.next()) {
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" ");
		}
		con.close();
	}

}
