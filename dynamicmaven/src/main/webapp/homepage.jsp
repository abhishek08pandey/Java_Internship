<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="com.rivet.student.Student"%>
<%@ page import="com.rivet.dao.DAOServiceImpl"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="adduser?name=createRecords&id=0">Add Student</a>

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
		List<Student> list = DAOServiceImpl.getList();
		for (Student student : list) {
		%>
		<tr>
			<td><a href="adduser?name=getid&id=<%= student.getId() %>"><%=student.getId()%></a></td>
			<td><%=student.getName()%></td>
			<td><%=student.getEmail()%></td>
			<td><%=student.getPassword()%></td>
			<td><a href="adduser?name=update&id=<%= student.getId() %>">Update</a>
			<td><a href="adduser?name=delete&id=<%= student.getId() %>">Delete</a>
		</tr>
		<%
		}
		%>
	</table>

</body>
</html>