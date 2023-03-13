package com.rivetbankwithjsp.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rivetbankwithjsp.controller.DAOServiceImpl;
import com.rivetbankwithjsp.user.User;

@WebServlet("/getid")
public class GetDetailsById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userId = request.getParameter("id");
		int id =Integer.parseInt(userId);
		System.out.println(id);
		User user = DAOServiceImpl.idDetails(id);
		
		System.out.println(user.getId());
		System.out.println(user.getEmail());
		
		request.setAttribute("user", user);
		request.getRequestDispatcher("\\WEB-INF\\feature\\iddetails.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
	}

}
