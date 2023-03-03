package com.rivetbankwithservlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rivetbankwithservlet.user.RivetBankAdmin;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("reach post method");
		RequestDispatcher rd = request.getRequestDispatcher("\\login.html");
		rd.forward(request, response);
	}
	
// Pass credential details in Select query  	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		
		RivetBankAdmin admin = new RivetBankAdmin();
		admin.setUserId(userid);
		admin.setPassword(password);
		
		try {
			boolean verifyCredential = DAOServiceImpl.verifyCredential(admin);
			System.out.println("in login "+ verifyCredential);
			
			if(verifyCredential) {
				RequestDispatcher rd = request.getRequestDispatcher("\\WEB-INF\\features\\create.html");
				rd.forward(request, response);
			}else {
				response.setContentType("text/html");
		        PrintWriter pw = response.getWriter();
				pw.println("<html>");
		        pw.println("<head></head>");
		        pw.println("<body>");
		        pw.println("</body>");
		        pw.println("</html>");
				pw.println("<h2>Please insert valid Id and Password!!!</h2>");
				pw.println("<h1><a href=login>GO TO LOGIN PAGE</a></h1>");
		        pw.println("</body>");
		        pw.println("</html>");
			}
		}catch (Exception e) {
			System.out.println("login exception");
			e.printStackTrace();
		}
		
	}
}
