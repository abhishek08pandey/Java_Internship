<%@page import="org.apache.jasper.tagplugins.jstl.core.Catch"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.jspcrudproject.user.User"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="com.jspcrudproject.controller.DAOServiceImpl"%>
<%@ page import="java.io.PrintWriter"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add User</title>
</head>
<body>

	<%!int status = 0;
	User user = new User();%>
	
	<%
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	String password = request.getParameter("password");

	user.setName(name);
	user.setEmail(email);
	user.setPassword(password);
	%>

	<%
	try {
		//Save method 
		int status = DAOServiceImpl.addUser(user);
		
		if (status > 0) {
			// call list and to all data
			request.getRequestDispatcher("getallrecords.jsp").forward(request, response);

		} else {
			request.getRequestDispatcher("getallrecords.jsp").forward(request, response);
		}
	} catch (Exception e) {
		request.getRequestDispatcher("getallrecords.jsp").forward(request, response);
	}
	%>

</body>
</html>