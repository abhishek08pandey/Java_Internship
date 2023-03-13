package com.rivetbankwithjsp.servlets;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rivetbankwithjsp.controller.DAOServiceImpl;


@WebServlet("/delete")
public class DeleteRecords extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userId = request.getParameter("id");
		int id = Integer.parseInt(userId);
		
		boolean status = DAOServiceImpl.deleteRecord(id);
		if(status) {
			
			response.sendRedirect("login");
//			ResultSet list = DAOServiceImpl.listOfRecords();
//// So here we Use setAttribute to send records on list.jsp			
//			request.setAttribute("list", list);
//			RequestDispatcher rd = request.getRequestDispatcher("\\WEB-INF\\feature\\list.jsp");
//			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
	}

}
