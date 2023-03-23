<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



	<%
	String num1 = request.getParameter("num1");
		String num2 = request.getParameter("num2");
		
		int id1 = Integer.parseInt(num1);
		int id2 = Integer.parseInt(num2);
		
		
		out.println("total of both: "+ (id1+id2));
		%>
</body>
</html>