package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;


@WebServlet("/secondGenericServlet")
public class SecondGenericServlet extends GenericServlet {

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("userName");
		System.out.println(name);
		
		
		response.setContentType("text/html");
	        PrintWriter pw = response.getWriter();
	        pw.println("<html>");
	        pw.println("<head><title>My first Servlet</title></head>");
	        pw.println("<body>");
	        pw.println("<h2>Welcome To Servlet World!</h2>");
	        pw.println("</body>");
	        pw.println("</html>");
	        pw.close(); 
	}
}
