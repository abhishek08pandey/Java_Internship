<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.rivet.student.Student"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update</title>
</head>
<body>
	<a href="homepage.jsp">Home</a>
	<%
	Student student = (Student) request.getAttribute("idDetails");
	%>
	<form action="adduser?work=update" method="post">
	<table border=1 width=10% height=10%>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Email</th>
			<th>Password</th>
		</tr>
		<tr>
			<td><input type="text" name="id" value="<%= student.getId()%>" readOnly></td>
			<td><input type="text" name="name" value="<%=student.getName()%>" required></td>
			<td><input type="text" name="email" value="<%=student.getEmail()%>" required></td>
			<td><input type="text" name="password" value="<%=student.getPassword()%>" required></td>
			<td><input type="submit" value=update"></td>
		</tr>
		</table>
	</form>
</body>
</html>