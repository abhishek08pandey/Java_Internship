<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add User</title>
</head>
<body>
	<a href="login">Home</a>

	<h1 align="center">Enter Customer Details</h1>
	<form action="adduser" method="post">
		<table align="center">
			<tr>
				<th>Name <input type="text" name="name" required></th>
			</tr>
			<tr>
				<th>Email <input type="text" name="email" required></th>
			</tr>
			<tr>
				<th>Password <input type="text" name="password" required></th>
			</tr>
			<tr>
				<th><input type="submit" name="save"></th>
			</tr>
		</table>
	</form>
</body>
</html>