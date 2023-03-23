package com.onerivet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class FirstServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		System.out.println("in servlet");
		PrintWriter out = response.getWriter();
		
		ServletConfig cg = getServletConfig();
		String name = cg.getInitParameter("name");
		out.print(" welcome "+name);
		
		ServletContext sct = getServletContext();
		String city = sct.getInitParameter("city");
		out.println(" in "+city);
		
		String num1 = request.getParameter("num1");
		String num2 = request.getParameter("num2");
		
		int id1 = Integer.parseInt(num1);
		int id2 = Integer.parseInt(num2);
		
		out.println("total of both: "+ (id1+id2));
	}
}
