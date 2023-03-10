package com.servlet.coockie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet1")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			response.setContentType("text/html");
			PrintWriter out = response.getWriter();

			String uname = request.getParameter("name");
			String ucity = request.getParameter("city");
			out.print("Welcome " + uname);

			Cookie name = new Cookie("uname", uname);// creating cookie object
			Cookie city = new Cookie("ucity", ucity );
			
			response.addCookie(name);// adding cookie in the response
			response.addCookie(city);
			name.setMaxAge(1);
			city.setMaxAge(1);
			// creating submit button
			out.print("<form action=servlet2 method=post>");
			out.print("<input type='submit' value='go'>");
			out.print("</form>");


		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
