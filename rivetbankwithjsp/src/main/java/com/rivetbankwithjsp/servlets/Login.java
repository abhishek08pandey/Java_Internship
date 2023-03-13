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
import javax.servlet.http.HttpSession;

import com.rivetbankwithjsp.controller.DAOServiceImpl;
import com.rivetbankwithjsp.user.RivetBankAdmin;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ResultSet list = DAOServiceImpl.listOfRecords();

// So here we Use setAttribute to send records on list.jsp			
		request.setAttribute("list", list);
		RequestDispatcher rd = request.getRequestDispatcher("\\WEB-INF\\feature\\list.jsp");
		rd.forward(request, response);
	}

// Pass credential details in Select query  	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		String userId = request.getParameter("userid");
		String password = request.getParameter("password");

		RivetBankAdmin admin = new RivetBankAdmin();
		admin.setUserId(userId);
		admin.setPassword(password);

		try {
			boolean verifyCredential = DAOServiceImpl.verifyCredential(admin);
			System.out.println("in login " + verifyCredential);

			if (verifyCredential) {
				
				//HttpSession session = request.getSession(true);
				//session.setAttribute("userId", userId);
				
				response.sendRedirect("login");
// If login done than we get result(in the form of all Records)
//				ResultSet list = DAOServiceImpl.listOfRecords();
//
//// So here we Use setAttribute to send records on list.jsp			
//				request.setAttribute("list", list);
//				RequestDispatcher rd = request.getRequestDispatcher("\\WEB-INF\\feature\\list.jsp");
//				rd.forward(request, response);

			} else {
				response.setContentType("text/html");
				PrintWriter pw = response.getWriter();

				request.getRequestDispatcher("login.html").include(request, response);

				pw.println("<h2>Please insert valid Id and Password!!!</h2>");
			}
		} catch (Exception e) {
			System.out.println("login exception");
			e.printStackTrace();
		}

	}
}
