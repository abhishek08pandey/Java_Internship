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
	<a href="getallrecords.jsp">Home</a>
	<a href="create.jsp">Add User</a>
	<a href="login.jsp">Logout</a>

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
			<td><a href="getid.jsp?id=<%=list.getInt(1)%>"><%=list.getInt(1)%></a>
			<td><%=list.getString(2)%></td>
			<td><%=list.getString(3)%></td>
			<td><%=list.getString(4)%></td>
			<td><a href="getupdaterecords.jsp?id=<%= list.getInt(1)%>">Update</a>
			<td><a href="deleteid.jsp?id=<%= list.getInt(1)%>">Delete</a>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>