<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="com.rivetbankwithjsp.user.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Person Details</title>
</head>
<body>

	<a href="login">Home</a>
	<%
	User user = (User) request.getAttribute("user");
	%>
	<p>
	<%=user.getName()%> Details
	</p>
	<table border=1 width=10% height=10%>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Email</th>
			<th>Password</th>
		</tr>
		<tr>
			<td><%=user.getId()%></td>
			<td><%=user.getName()%></td>
			<td><%=user.getEmail()%></td>
			<td><%=user.getPassword()%></td>
		</tr>
	</table>
</body>
</html>