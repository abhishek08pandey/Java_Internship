package com.rivetbankwithjsp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rivetbankwithjsp.controller.DAOServiceImpl;
import com.rivetbankwithjsp.user.User;

@WebServlet("/adduser")
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("\\WEB-INF\\feature//create.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//Get data from Create.jsp Form	
		try {
			//HttpSession session = request.getSession(false);
			//if(session!=null) {
			
			//session.getAttribute("userId");
			//}
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String password = request.getParameter("password");

			User user = new User();
			user.setName(name);
			user.setEmail(email);
			user.setPassword(password);
// Save method 
			int status = DAOServiceImpl.addUser(user);
			if (status > 0) {
				response.sendRedirect("login");
// List of Data Show
//			ResultSet list = DAOServiceImpl.listOfRecords();
//				
//// So here we Use setAttribute to send records on list.jsp			
//				request.setAttribute("list", list);
//				request.getRequestDispatcher("\\WEB-INF\\feature//list.jsp").include(request, response);

				response.setContentType("text/html");
				PrintWriter print = response.getWriter();

				print.println("\n"+user.getName() + " details Successfully add");
				System.out.println(status +" : reach in if checker");
			}else {
				ResultSet list = DAOServiceImpl.listOfRecords();
				
// So here we Use setAttribute to send records on list.jsp			
				request.setAttribute("list", list);
				request.getRequestDispatcher("\\WEB-INF\\feature//list.jsp").include(request, response);
				
				response.setContentType("text/html");
				PrintWriter print = response.getWriter();

				print.println("Please enter valid User Details!!!");
			}
		} catch (Exception e) {
// If we don not insert it will through on create page
			
			ResultSet list = DAOServiceImpl.listOfRecords();
			
// So here we Use setAttribute to send records on list.jsp			
			request.setAttribute("list", list);
			request.getRequestDispatcher("\\WEB-INF\\feature//list.jsp").include(request, response);
			
			response.setContentType("text/html");
			PrintWriter print = response.getWriter();

			print.println("User Details not inserted!!!");
		}
	}

}
