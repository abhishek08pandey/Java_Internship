package com.servlets;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/normal")
public class Normal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String[] name =request.getParameterValues("userName");
		String name = request.getParameter("userName");
		System.out.println(name);
		
		int length = request.getContentLength();
		System.out.println(length);
		
		Enumeration<String> parameterNames = request.getParameterNames();
		System.out.println(parameterNames.toString());
		
		String serverName = request.getServerName();
		System.out.println(serverName);// Localhost
		
		int port = request.getServerPort();
		System.out.println(port);
		
		RequestDispatcher rd = request.getRequestDispatcher("demo.html");
		rd.forward(request, response);
	
		//response.sendRedirect("http://www.javatpoint.com");// It is work on client side 
		// It always sends a new request.	It can be used within and outside the server	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
	}

}
