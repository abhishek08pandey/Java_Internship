<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.jspcrudproject.user.User"%>
<%@ page import="com.jspcrudproject.controller.DAOServiceImpl" %>
<%@ page import="java.sql.ResultSet"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="create.jsp">Add User</a>

	<h1>Welcome in Admin</h1>
	<table border=1 width=10% height=10%>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Email</th>
			<th>Password</th>
		</tr>
		<%
		ResultSet list = (ResultSet) request.getAttribute("user");
		while (list.next()) {
		%>
		<tr>
			<td><%=list.getInt(1)%>
			<td><%=list.getString(2)%></td>
			<td><%=list.getString(3)%></td>
			<td><%=list.getString(4)%></td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>