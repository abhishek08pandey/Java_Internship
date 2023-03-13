package com.rivetbankwithjsp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.rivetbankwithjsp.controller.DAOServiceImpl;
import com.rivetbankwithjsp.user.User;

@WebServlet("/update")
public class UpdateRecords extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userId = request.getParameter("id");
		int id = Integer.parseInt(userId);

		try {
			User user = DAOServiceImpl.idDetails(id);
			request.setAttribute("user", user);
			request.getRequestDispatcher("\\WEB-INF\\feature\\update.jsp").forward(request, response);

		} catch (Exception e) {
			System.out.println("update Exception");
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String userId = request.getParameter("id");
			int id = Integer.parseInt(userId);
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String password = request.getParameter("password");

			User user = new User();
			user.setId(id);
			user.setName(name);
			user.setEmail(email);
			user.setPassword(password);

			int status = DAOServiceImpl.update(user);
			if (status > 0) {
				
				response.sendRedirect("login");
// List of Data Show
//				ResultSet list = DAOServiceImpl.listOfRecords();
//
//// So here we Use setAttribute to send records on list.jsp			
//				request.setAttribute("list", list);
//				request.getRequestDispatcher("\\WEB-INF\\feature//list.jsp").include(request, response);

				response.setContentType("text/html");
				PrintWriter print = response.getWriter();

				print.println("\n" + user.getName() + " details Successfully update");
				System.out.println(status + " : reach in if checker");
			}
		} catch (Exception e) {
// If we don not insert it will through on create page
			//request.getRequestDispatcher("list.jsp").include(request, response);
			
			response.setContentType("text/html");
			PrintWriter print = response.getWriter();

			print.println("User Details not update!!!");

			
		}
	}

}
