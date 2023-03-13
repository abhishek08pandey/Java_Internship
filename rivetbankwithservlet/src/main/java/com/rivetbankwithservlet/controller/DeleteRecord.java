package com.rivetbankwithservlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class DeleteRecord extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
// Id form  for delete and Main Menu
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter print = response.getWriter();
		
		print.println("<html>");
		print.println("<head><title>Records</title></head>");
		print.println("<body>");
		print.println("<form action=adduser method=get>");
		print.println("<pre><input type=submit value=Home></pre>");
		print.println("</form>");
		print.println("<h2>Enter Id</h2>");
			print.println("<form action=delete method=post>");
			print.println("Id<input type=text name=id required >");
			print.println("<input type=submit value=delete>");
			print.println("</form>");
		print.println("</body>");
		print.println("</html>");
	}
// Pass Id in Delete Query in DAOServiceImpl class 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter print = response.getWriter();
		
		String userId = request.getParameter("id");
		int id = Integer.parseInt(userId);
		
		boolean status = DAOServiceImpl.deleteRecord(id);
		
		if(status) {
			RequestDispatcher rd = request.getRequestDispatcher("\\WEB-INF\\features\\create.html");
			rd.forward(request, response);
		}else {
		
		print.println("<html>");
		print.println("<head><title>Records</title></head>");
		print.println("<body>");
		print.println("<h2>Enter Id Does not exist</h2>");
		print.println("<a href=delete>GO TO DELETE PAGE</a>");
		print.println("</body>");
		print.println("</html>");
		}
	}

}
