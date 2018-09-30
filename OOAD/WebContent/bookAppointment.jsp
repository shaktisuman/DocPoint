<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="drbook.css">
<title>Book an Appointment</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
	var d = new Date();
    n = d.getMonth();
    if(n==1 || n==3 || n==5 || n==8 || n==10) 
    {
    	$("#d31").hide();
    }
    
});
</script>
</head>
<body>

<label id='lblHi'>Hi ABC!</label>
<a id='logout' href="logout.jsp"> Logout</a>
<a id = 'home' href="welcome.jsp">Home </a>
<center><b><h2>Book an Appointment!</h2></b></center>
<label id='lblDocPick'>Pick a Doctor:</label>
<select id='docList'>
<option value="Doc1" selected>Doc 1</option>
<option value="Doc2">Doc 2</option>
<option value="Doc3">Doc 3</option>
</select>
<header id='calHdr'><h4>Pick a Date</h4></header>
<section id='cal' class='groove'>
<section id='d1' class = 'row1'>1</section>
<section id='d2' class = 'row1'>2</section>
<section id='d3' class = 'row1'>3</section>
<section id='d4' class = 'row1'>4</section>
<section id='d5' class = 'row1'>5</section>
<section id='d6' class = 'row1'>6</section>
<section id='d7' class = 'row1'>7</section>
<section id='d8' class = 'row1'>8</section>
<section id='d9' class = 'row1'>9</section>
<section id='d10' class = 'row1'>10</section>
<section id='d12' class = 'row1'>11</section>
<section id='d12' class = 'row1'>12</section>
<section id='d13' class = 'row1'>13</section>
<section id='d14' class = 'row1'>14</section>
<section id='d15' class = 'row1'>15</section>
<section id='d16' class = 'row1'>16</section>
<section id='d17' class = 'row1'>17</section>
<section id='d18' class = 'row1'>18</section>
<section id='d19' class = 'row1'>19</section>
<section id='d20' class = 'row1'>20</section>
<section id='d21' class = 'row1'>21</section>
<section id='d22' class = 'row1'>22</section>
<section id='d23' class = 'row1'>23</section>
<section id='d24' class = 'row1'>24</section>
<section id='d25' class = 'row1'>25</section>
<section id='d26' class = 'row1'>26</section>
<section id='d27' class = 'row1'>27</section>
<section id='d28' class = 'row1'>28</section>
<section id='d29' class = 'row1'>29</section>
<section id='d30' class = 'row1'>30</section>
<section id='d31' class = 'row1'>31</section>
</section>
</body>
</html>
