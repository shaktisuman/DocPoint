<%@page import="db.DbManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<script type="text/javascript" src="script.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Patient Login</title>
<style>
/*Style image*/
img {
	display: block;
    margin-left: auto;
    margin-right: auto;
    border: 0px solid #ddd;
    border-radius: 4px;
    padding: 5px;
    width: 150px;
}

img:hover {
    box-shadow: 0 0 2px 1px rgba(0, 140, 186, 0.5);
}
/* Style all input fields */
@import url(https://fonts.googleapis.com/css?family=Montserrat:400,700);
html{
font-family: 'Montserrat', Arial, sans-serif;
}
input {
    width: 100%;
    padding: 12px;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
    margin-top: 6px;
    margin-bottom: 16px;
}

/* Style the submit button */
input[type=submit] {
    background-color: #4682B4;
    color: white;
}

/* Style the container for inputs */
.container {
    background-color: #f1f1f1;
    padding: 20px;
}

/* Set a grey background color and center the text of the "sign in" section */
.signin {
    background-color: #f1f1f1;
    text-align: center;
}
</style>
</head>



<body>

<a href="login.jsp">
  <img src="http://i1383.photobucket.com/albums/ah307/yaygreat/logo_zpshutgkrz5.png" alt="Dr. Book" style="width:150px">
</a>

${message}
${successMessage}
<h3>Welcome to Dr. Book!</h3>
<p>Please Login</p>

<div class="container">
  <form name="loginform" action="AdminLoginController" method="post" onsubmit="return loginValidate()" >
    <label for="username">Username</label>
    <input type="text" name="username" id="username" required>

    <label for="password">Password</label>
    <input type="password" name="password" id="password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" required>
    
    <input type="submit" name="submit" value="login">
    <a href="register.jsp">Register</a>
  </form>
</div>

<b><font color="white">New Line</font></b>

<div class="container signin">
	<p>Not Admin? <a href="doctorlogin.jsp">Doctor Sign in</a>  <a href="login.jsp">Patient Sign in</a>.</p>
</div>
				
</body>
</html>
