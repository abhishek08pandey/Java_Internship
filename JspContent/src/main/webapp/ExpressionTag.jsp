<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body align="center">


	<!-- <%	String name = request.getParameter("name"); %> -->
	<!--  <%= "welcome in "  %> <%  out.println(name); %>  -->
	
	<%= "Welcome "+request.getParameter("name") %>  
</body>  
	
</body>
</html>