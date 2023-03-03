package com.rivetbankwithservlet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rivetbankwithservlet.user.User;

@WebServlet("/listofrecords")
public class ListOfRecords extends HttpServlet {
	private static final long serialVersionUID = 1L;

// Get all Details by calling DAOServiceImpl for run Select Query and Main Menu
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ResultSet list = DAOServiceImpl.listOfRecords();
		try {
			response.setContentType("text/html");
			PrintWriter print = response.getWriter();
// Main Menu			
			print.println("<html>");
			print.println("<head><title>Records</title></head>");
			print.println("<body>");
			print.println("<form action=adduser method=get>");
			print.println("<pre><input type=submit value=MainMenu></pre>");
			print.println("</form>");
			print.println("<h2>List Of Records</h2>");
//Print table of List
			print.println("<table border=1 width=10% height=10%>");  
			print.println("<tr><th>Id</th><th>Name</th><th>Email</th><th>City</th><th>Contact Number</th><tr>");
            
			while (list.next()) {
				
                print.println("<tr><td>"+ list.getInt(1) +"</td><td>" + list.getString(2) + "</td><td>" + list.getString(3) + 
                		"</td><td>" + list.getString(4) + "</td><td>" + list.getLong(5) + "</td></tr>");
			}
			print.println("</table>");
			print.println("</body>");
			print.println("</html>");
			
		} catch (SQLException | IOException e) {
			System.out.println("from list");
			e.printStackTrace();
		}

	}
}
