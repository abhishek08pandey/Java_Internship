<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body align="center">
	<% 
	String name = request.getParameter("name");
	out.println(name);
	out.println("\n From 1Rivet");
	%>
	
</body>
</html>