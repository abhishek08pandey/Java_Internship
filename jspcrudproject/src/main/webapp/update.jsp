<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.jspcrudproject.user.User"%>
<%@ page import="com.jspcrudproject.controller.DAOServiceImpl"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.io.PrintWriter" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>call query</title>
</head>
<body>
	<%
	try {
		String userId = request.getParameter("id");
		int id = Integer.parseInt(userId);
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		User user = new User();
		user.setId(id);
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		
// call update 
		int status = DAOServiceImpl.update(user);
		if (status > 0) {
		
			request.getRequestDispatcher("getallrecords.jsp").include(request, response);
		}
	} catch (Exception e) {
//If we don not insert it will through on getallrecords page
		request.getRequestDispatcher("getallrecords.jsp").include(request, response);
	}
	%>


</body>
</html>