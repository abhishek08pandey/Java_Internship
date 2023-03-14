<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.jspcrudproject.user.User"%>
<%@ page import="com.jspcrudproject.controller.DAOServiceImpl"%>
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
		<%
// Get id details
	String userId = request.getParameter("id");
	int id = Integer.parseInt(userId);
	
	User user = DAOServiceImpl.idDetails(id);
	%>
	<p>
	<%=user.getName()%> Details
	</p>
<!-- form for enter update details -->

	<form action="update.jsp" method="post" >
	<table border=1 width=10% height=10%>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Email</th>
			<th>Password</th>
		</tr>
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