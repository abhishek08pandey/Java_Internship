package com.practiceServlet;

import javax.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;


@WebServlet("/first")
public class DemoServlet extends HttpServlet{
	
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");// setting the content type
		PrintWriter pw = res.getWriter();// get the stream to write the data

//writing html in the stream  
		pw.println("<html><body>");
		pw.println("Welcome to servlet");
		pw.println("</body></html>");
		System.out.println("before close");
		pw.close();// closing the stream
		System.out.println("After close");
		
		
	}


}