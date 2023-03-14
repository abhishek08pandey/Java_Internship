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
<title>Insert title here</title>
</head>
<body>
	<a href="login.jsp">Logout</a>
	
	<%
	//Get all Records and send it with setAttribute
			ResultSet list = DAOServiceImpl.listOfRecords();
			request.setAttribute("list", list);

			// call list and create link
			request.getRequestDispatcher("list.jsp").forward(request, response);
	%>
</body>
</html>