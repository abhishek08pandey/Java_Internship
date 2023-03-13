package com.rivetbankwithjsp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
		//HttpSession session = request.getSession();
		//session.getAttribute("userId");
		//session.invalidate();
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();

		request.getRequestDispatcher("login.html").include(request, response);

		pw.println("<h2>You have successfully logout</h2>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	

}
