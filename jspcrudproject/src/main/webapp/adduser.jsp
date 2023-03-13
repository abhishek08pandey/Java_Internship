<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.jspcrudproject.user.User" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="com.jspcrudproject.controller.DAOServiceImpl" %>
<%@ page import="java.io.PrintWriter" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add User</title>
</head>
<body>
	<%
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	String password = request.getParameter("password");

	User user = new User();
	user.setName(name);
	user.setEmail(email);
	user.setPassword(password);
	//Save method 
	int status = DAOServiceImpl.addUser(user);
	
	if(status>0){
//Get all Records and send it with setAttribute
		ResultSet list = DAOServiceImpl.listOfRecords();
		request.setAttribute("user", list);
		
// call list and create link
		request.getRequestDispatcher("list.jsp").include(request, response);

		response.setContentType("text/html");
		PrintWriter print = response.getWriter();

		print.println("\n"+user.getName() + " details Successfully add");
		System.out.println(status +" : reach in if checker");
		
	}else{
		ResultSet list = DAOServiceImpl.listOfRecords();
// So here we Use setAttribute to send records on list.jsp			
		request.setAttribute("list", list);
		request.getRequestDispatcher("list.jsp").include(request, response);
						
		response.setContentType("text/html");
		PrintWriter print = response.getWriter();

		print.println("Please enter valid User Details!!!");
	
	%>
</body>
</html>