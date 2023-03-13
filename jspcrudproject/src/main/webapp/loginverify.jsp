<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.jspcrudproject.user.RivetBankAdmin" %>
<%@ page import="com.jspcrudproject.user.User" %>
<%@ page import="com.jspcrudproject.controller.DAOServiceImpl" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.sql.ResultSet"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login verify</title>
</head>
<body><!-- response.sendRedirect("list.jsp") -->

	<%! RivetBankAdmin admin = new RivetBankAdmin(); %>
	<%
	String userId = request.getParameter("userid");
	String password = request.getParameter("password");
	
	admin.setUserId(userId);
	admin.setPassword(password);
try{
	boolean status = DAOServiceImpl.verifyCredential(admin);
	System.out.println(status);
	if(status){
//Get all Records and send it with setAttribute
		ResultSet list = DAOServiceImpl.listOfRecords();
		request.setAttribute("user", list);
		
		request.getRequestDispatcher("list.jsp").forward(request, response);
		//response.sendRedirect("list.jsp");
		
	}else{
// Return in login page	if insert Wrong inputs	
		response.setContentType("text/html");
		PrintWriter print = response.getWriter();
		
		request.getRequestDispatcher("login.jsp").include(request, response);
//      response.sendRedirect("login.jsp");

		out.println("Wrong input inserted");
	}
}catch(Exception e){
	System.out.println("in login verify exception");
}
	%>
</body>
</html>