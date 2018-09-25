<%@page import="db.DbManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="script.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>
</head>
<body>
	<%-- <br/> --%>
	
	<form name="loginform" action="LoginController" method="post" onsubmit="return loginValidate()" >
	<%-- <br>
	${message}<br>
	${successMessage}<br> --%>
	<nav>
  		<a href="login.jsp">Login Page</a> |
  		<a href="/js/">Contact Us</a>
	</nav>
	<h1><font face="verdana"> Please login to to use Dr. Book </font></h1>
	
	<%-- Username: <input type="text" name="username" id="username"><br>
	Password: <input type="password" name="password" id="password"><br>
	<input type="submit" name="submit" value="login"><br>
	<a href="register.jsp">registration</a> --%>
	
	<table>
		<tr>
			<td>Username</td>
			<td><input type="text" name="username" id="username"/></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><input type="password" name="password" id="password"/></td>
		</tr>
		<tr>
			<td><button type="submit" name="submit" value="login">Login</button></td>
			<td><a href="register.jsp">registration</a></td>
		</tr>
	</table>
	<br>
	<%--<%out.print("Hello!"); %> 
	<%= new java.util.Date() %>
	
	
	<%! int number1, number2; %>
	
	<%
		DbManager db = new DbManager();
		Connection conn = (Connection) db.getConnection();
		if(conn == null)
			out.print("failed");
		else
			out.print("succeeded");
	
	%> --%>

	</form>
</body>
</html>