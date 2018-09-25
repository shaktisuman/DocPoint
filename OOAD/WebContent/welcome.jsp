<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome Page</title>
</head>
<body>
	<nav>
  		<a href="login.jsp">Login Page</a> |
  		<a href="register.jsp">Register</a> |
  		<a href="/js/">Contact Us</a> |
	</nav>
<h1><font face="verdana"> ${message} Welcome!!! </font></h1>
	<button type="submit" name="submit" value="bookappt">Book Appointment</button><br>
	<br>
	<a href="logout.jsp">Logout</a>

</body>
</html>