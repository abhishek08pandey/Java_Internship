<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<!-- Declaration Tag -->
	<%!  int x = 10;
		public int y = 100;
	%>
	
	<!-- Scriplet Tag--> 
	<% 	out.println(x);
		out.println(y);
	%>
	
	<!-- Expression Tag -->
	<%= "It will print directly"
		
		%>
		
		<%=	
	Date.class
		%>
	
	
</body>
</html>