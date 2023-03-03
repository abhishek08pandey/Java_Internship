package com.rivetbankwithservlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.rivetbankwithservlet.user.User;

@WebServlet("/adduser")
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("\\WEB-INF\\features\\create.html");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//Get data from Create.html Form	
		try {
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String city = request.getParameter("city");
			String mobile = request.getParameter("mobile");
			long mobileNumber = Long.parseLong(mobile);

			User user = new User();
			user.setName(name);
			user.setEmail(email);
			user.setCity(city);
			user.setMobileNumber(mobileNumber);
// Save method 
			int status = DAOServiceImpl.addUser(user);

			if (status > 0) {
// Inserted Data Show
				response.setContentType("text/html");
				PrintWriter print = response.getWriter();
				
				print.println("<html>");
				print.println("<head><title>Records</title></head>");
				print.println("<body>");
				print.println("<h2><a href=adduser>CREATE</a></h2>");
				print.println("<h2>List Of Records</h2>");
				print.println("<table border=1 width=10% height=10%>");  
				print.println("<tr><th>Name</th><th>Email</th><th>City</th><th>Contact Number</th><tr>");
	            print.println("<tr><td>"+ name +"</td><td>" + email + "</td><td>" + city + 
	                		"</td><td>" + mobileNumber + "</td></tr>");
				print.println("</table>");
				print.println("</body>");
				print.println("</html>");
			}
		}catch (NumberFormatException e) {
// If we don not insert it will through on create page
			
			response.setContentType("text/html");
	        PrintWriter print = response.getWriter();
	        
	        print.println("<html>");
	        print.println("<head><title></title></head>");
	        print.println("<body>");
	        print.println("<h2>Please insert valid inputs!!!</h2>");
	        print.println("<h2><a href=adduser>GO TO CREATE PAGE</a></h2>");
	        print.println("</body>");
	        print.println("</html>");
	        print.close(); 
		}
	}

}
