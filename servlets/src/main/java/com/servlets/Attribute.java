package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/attribute")
public class Attribute extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext context=getServletContext();  
		
		String attribute = (String)context.getAttribute("name");
		System.out.println(attribute);
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("name");
		String city = request.getParameter("city");
		
		ServletContext context=getServletContext();  
		
		context.setAttribute("name", name);
		
		response.setContentType("text/html");
		PrintWriter print = response.getWriter();
		
		print.println("<a href=attribute >click</a>");
	
	}

}
