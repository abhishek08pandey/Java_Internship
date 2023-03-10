package com.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/coockie")
public class Coockie extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
		Cookie ck=new Cookie("user","abhishek");//deleting value of cookie  
		ck.setMaxAge(0);//changing the maximum age to 0 seconds  
		response.addCookie(ck);//adding cookie in the response  
		System.out.println(ck.getName());
		
		Cookie[] cookies = request.getCookies();
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	
}
