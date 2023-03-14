<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.jspcrudproject.controller.DAOServiceImpl"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete</title>
</head>
<body>

	<%
	String userId = request.getParameter("id");
	int id = Integer.parseInt(userId);
		
	boolean status = DAOServiceImpl.deleteRecord(id);
		if(status) {
			
			response.sendRedirect("getallrecords.jsp");
		}
		 %>
</body>
</html>