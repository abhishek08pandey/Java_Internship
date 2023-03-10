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

@WebServlet("/update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int status=0;
		try {
			response.setContentType("text/html");
			PrintWriter print = response.getWriter();

			String userId = request.getParameter("userId");
			System.out.println(userId);
			int id = Integer.parseInt(userId);
			System.out.println(id);
			String name = request.getParameter("name");	
			String email = request.getParameter("email");
			String city = request.getParameter("city");
			String mobile = request.getParameter("mobile");
			long mobileNumber = Long.parseLong(mobile);

			User user = new User();
			user.setId(id);
			user.setName(name);
			user.setEmail(email);
			user.setCity(city);
			user.setMobileNumber(mobileNumber);

			status = DAOServiceImpl.update(user);
			System.out.println("check in update: " +status);
			if (status > 0) {
				print.println("Records Update");
				RequestDispatcher rd = request.getRequestDispatcher("\\WEB-INF\\features\\create.html");
				rd.include(request, response);
			} else {
				print.println("Records not found for update");
				RequestDispatcher rd = request.getRequestDispatcher("\\WEB-INF\\features\\create.html");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			System.out.println("exception in update servlet");
			response.setContentType("text/html");
			PrintWriter print = response.getWriter();
			print.println("Wrong inputs !!!");
			
			print.println("<form action=adduser method=get>");
			print.println("<pre><input type=submit value=MainMenu></pre>");
			print.println("</form>");
			e.printStackTrace();
		}
	}

}
