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

@WebServlet("/oneiddata")
public class OnePersonRecord extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter print = response.getWriter();
		
		print.println("<html>");
		print.println("<head><title>Find Records</title></head>");
		print.println("<body>");
		print.println("<form action=adduser method=get>");
		print.println("<pre><input type=submit value=MainMenu></pre>");
		print.println("</form>");
		print.println("<h2>Enter Id</h2>");
		
		print.println("<form action=oneiddata method=post>");
		print.println("Id<input type=text name=id>");
		print.println("<input type=submit name=find>");
		print.println("</form>");
		
		print.println("</body>");
		print.println("</html>");
		
}
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	String userId = request.getParameter("id");
	int id = Integer.parseInt(userId);

	ResultSet idDetails = DAOServiceImpl.idDetails(id);
	try {
	response.setContentType("text/html");

	PrintWriter print = response.getWriter();
	print.println("<html>");
	print.println("<head><title>Record</title></head>");
	print.println("<body>");
	print.println("<form action=adduser method=get>");
	print.println("<pre><input type=submit value=MainMenu></pre>");
	print.println("</form>");
	print.println("<h2>Id Details</h2>");

	print.println("<table border=1 width=10% height=10%>");
	print.println("<tr><th>Id</th><th>Name</th><th>Email</th><th>City</th><th>Contact Number</th><tr>");
	while (idDetails.next()) {
		int idUser = idDetails.getInt(1);
		String name = idDetails.getString(2);
		String email = idDetails.getString(3);
		String city = idDetails.getString(4);
		long mobile = idDetails.getLong(5);

		System.out.println(name + " " + mobile);
		System.out.println(idDetails.getString(2));
		
		print.println("<tr><td>" + idUser + "</td>");
		print.println("<td>" + name + "</td>");
		print.println("<td>" + email + "</td>");
		print.println("<td>" + city + "</td>");
		print.println("<td>" + mobile + "</td></tr>");
	}
	print.println("</table>");
	print.println("</body>");
	print.println("</html>");
} catch (SQLException e) {
	System.out.println("from sql in update servlet");
	e.printStackTrace();
}
	
	}
}
