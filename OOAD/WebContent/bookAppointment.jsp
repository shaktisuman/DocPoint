<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="drbook.css">
<title>Book an Appointment</title>
</head>
<body>

<label id='lblHi'>Hi ABC!</label>
<a id = 'home' href="welcome.jsp">Home</a>
<a id='logout' href="logout.jsp">Logout</a>
<label id='lblDocPick'>Pick a Doctor:</label>
<select id='docList'>
<option value="Doc1" selected>Doc 1</option>
<option value="Doc2">Doc 2</option>
<option value="Doc3">Doc 3</option>
</select>
<header id='calHdr'><h3>Pick a Date</h3></header>
<section id='cal' class='groove'>
Calander goes here...
<section id='d1' class = 'days'>1</section>
<section id='d2' class = 'days'>2</section>
<section id='d3' class = 'days'>3</section>
</section>
</body>
</html>
