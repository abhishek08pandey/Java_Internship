package com.servlets;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
 
@WebServlet("/First")
public class FirstServlet implements Servlet{
	public ServletConfig config=null;  
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		this.config=config;
		System.out.println("Servlet Initialized");
	}
/* 2. public abstract javax.servlet.ServletContext getServletContext()
 * This method will simply return ServletContext Object. Web container creates one
 *  ServletContext object for every web application
 */
	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		  String username=config.getInitParameter("userName"); // not run?
	        //String password=config.getInitParameter("password"); // welcome@123
       System.out.println(username);
	        //System.out.println(password);
	        
		String name =request.getParameter("userName");
		System.out.println("Nmae from getParameter:  "+name);

//		String servletName =config.getServletName();
//		System.out.println(servletName);
		
		//Other Example
//		response.setContentType("text/html");  
//		PrintWriter out=response.getWriter();  
//		out.print("<html><body>");  
//		out.print("<b>hello simple servlet</b>");  
//		out.print("</body></html>");  
		}  
	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public String getServletInfo() {
		return config.getClass().getName();
	}

	@Override
	public void destroy() {// Que:- why this destroy method execute?
		System.out.println("Servlet will destroyed");		
	}

}
