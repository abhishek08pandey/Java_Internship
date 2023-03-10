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

	User idDetails = DAOServiceImpl.idDetails(id);
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

	print.println("<table border=1 width=10% height=10% aling=center>");
	print.println("<tr><th>Id</th><th>Name</th><th>Email</th><th>City</th><th>Contact Number</th></tr>");
		print.println("<tr><td>" + idDetails.getId() + "</td>");
		print.println("<td>" + idDetails.getName() + "</td>");
		print.println("<td>" + idDetails.getEmail() + "</td>");
		print.println("<td>" + idDetails.getCity() + "</td>");
		print.println("<td>" + idDetails.getMobileNumber() + "</td></tr>");
	print.println("</table>");
	print.println("</body>");
	print.println("</html>");
	
} catch (Exception e) {
	System.out.println("from sql in update servlet");
	e.printStackTrace();
}
	
	}
}
