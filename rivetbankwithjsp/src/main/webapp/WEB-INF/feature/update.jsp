<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.rivetbankwithjsp.user.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update</title>
</head>
<body>
	<a href="login">Home</a>
	<a href="adduser">Create New</a>

	<h1>Welcome in Admin</h1>
	<form action="update" method="post" >
	<table border=1 width=10% height=10%>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Email</th>
			<th>Password</th>
		</tr>
		<%
		User user = (User) request.getAttribute("user");
		%>
		<tr>
			<td><input type="text" name="id" value="<%= user.getId()%>" readonly></td>
			<td><input type="text" name="name" value="<%= user.getName()%>" required ></td>
			<td><input type="text" name="email" value="<%= user.getEmail()%>" required ></td>
			<td><input type="text" name="password" value="<%= user.getPassword()%>" required ></td>
			<td><input type="submit" value=update"></td>
		</tr>
	</table>
	</form>
</body>
</html>