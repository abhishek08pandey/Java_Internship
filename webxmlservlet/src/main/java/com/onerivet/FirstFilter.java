package com.onerivet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebFilter("/adds")
public class FirstFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("In filetr");
		PrintWriter out = response.getWriter();

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		int id1 = Integer.parseInt(request.getParameter("num1"));
		int id2 = Integer.parseInt(request.getParameter("num2"));

		if (id1 >= 0 && id2 >= 0) {
			
			// try name varify
			chain.doFilter(request, response);// it will call next servlet which is same as url
		} else {
			System.out.println("INVALID");

			request.getRequestDispatcher("first.html").include(req, res);

			out.println("invalid inputs");
			// res.sendRedirect("first.html");
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
