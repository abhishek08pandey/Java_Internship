<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">Welcome to Admin Login </h1>
	<form action="loginverify.jsp" method="post" align="center">
		<pre>
			UserId:<input type="text" name="userid" required>
			Password:<input type="password" name="password" required>
			<input type="submit" name="login">
		</pre>
	</form>
</body>
</html>