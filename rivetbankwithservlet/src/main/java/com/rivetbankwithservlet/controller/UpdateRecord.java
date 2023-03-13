package com.rivetbankwithservlet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rivetbankwithservlet.user.User;

@WebServlet("/getidupdate")
public class UpdateRecord extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter print = response.getWriter();
// Main Menu
		print.println("<html>");
		print.println("<head><title>Records</title></head>");
		print.println("<body>");
		print.println("<form action=adduser method=get>");
		print.println("<pre><input type=submit value=Home></pre>");
		print.println("</form>");
		print.println("<h2>Enter Id for Update</h2>");
// Enter Update id
		print.println("<form action=getidupdate method=post>");
		print.println("Id<input type=text name=id required>");
		print.println("<input type=submit name=delete>");
		print.println("</form>");

		print.println("</body>");
		print.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userId = request.getParameter("id");
		int id = Integer.parseInt(userId);

		User user = DAOServiceImpl.idDetails(id);
		System.out.println(user.getId());
		try {
			response.setContentType("text/html");
			PrintWriter print = response.getWriter();
//we can change on Existing Records
			print.println("<html>");
			print.println("<head><title>Update</title></head>");
			print.println("<body>");
			print.println("<form action=adduser method=get>");
			print.println("<pre><input type=submit value=Home></pre>");
			print.println("</form>");

			print.println("<h2>Enter Update Details</h2>");
			
			print.println("<form action=update align=center>");
			print.println("<table border=1 width=10% height=10%>");
			print.println("<tr><th>Id</th><th>Name</th><th>Email</th><th>City</th><th>Contact Number</th></tr>");
			
			print.println("<tr><td><input type=text name=userId value="+user.getId()+" readonly></td>");
			print.println("<td><input type=text name=name value="+user.getName()+" required></td>");
			print.println("<td><input type=text name=email value="+user.getEmail()+" required></td>");
			print.println("<td><input type=text name=city value="+user.getCity()+" required></td>");
			print.println("<td><input type=text name= mobile value="+user.getMobileNumber()+" required></td>");
			print.println("<td><input type=submit value=update></td></tr>");
			print.println("</table>");
			print.println("</form>");
			print.println("</body>");
			print.println("</html>");

		} catch (IOException e) {
			System.out.println("from list");
			e.printStackTrace();
		}
	}
}
