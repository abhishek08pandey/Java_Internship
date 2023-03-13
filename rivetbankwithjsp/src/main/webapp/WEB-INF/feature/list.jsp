<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.ResultSet"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body>
	<a href="login">Home</a>
	<a href="adduser">Create New</a>
	<!--<a href="logout">Logout</a>  -->

	<h1>Welcome in Admin</h1>
	<table border=1 width=10% height=10%>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Email</th>
			<th>Password</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>
		<%
		ResultSet list = (ResultSet) request.getAttribute("list");
		while (list.next()) {
		%>
		<tr>
			<td><a href="getid?id=<%=list.getInt(1)%>"> <%=list.getInt(1)%>
			</a></td>
			<td><%=list.getString(2)%></td>
			<td><%=list.getString(3)%></td>
			<td><%=list.getString(4)%></td>
			<td><a href="update?id=<%= list.getInt(1)%>">Update</a>
			<td><a href="delete?id=<%= list.getInt(1)%>">Delete</a>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>