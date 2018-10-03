<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="script.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register</title>
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

body {font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: border-box;}

/* Full-width input fields */
input[type=text], input[type=password] {
    width: 100%;
    padding: 15px;
    margin: 5px 0 22px 0;
    display: inline-block;
    border: none;
    background: #f1f1f1;
}

/* Full-width option fields */
select {
    width: 100%;
    padding: 15px;
    margin: 5px 0 22px 0;
    display: inline-block;
    border: none;
    background: #f1f1f1;
}

/* Add a background color when the inputs get focus */
input[type=text]:focus, input[type=password]:focus {
    background-color: #ddd;
    outline: none;
}

/* Set a style for all buttons */
button {
    background-color: #4682B4;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100%;
    opacity: 0.9;
}

button:hover {
    opacity:1;
}

/* Extra styles for the cancel button */
.cancelbtn {
    padding: 14px 20px;
    background-color: #f44336;
}

/* Float cancel and signup buttons and add an equal width */
.cancelbtn, .signupbtn {
  float: left;
  width: 50%;
}

/* Add padding to container elements */
.container {
    padding: 16px;
}

/* The Modal (background) */
.modal {
    display: none; /* Hidden by default */
    position: fixed; /* Stay in place */
    z-index: 1; /* Sit on top */
    left: 0;
    top: 0;
    width: 100%; /* Full width */
    height: 100%; /* Full height */
    overflow: auto; /* Enable scroll if needed */
    background-color: #474e5d;
    padding-top: 50px;
}

/* Modal Content/Box */
.modal-content {
    background-color: #fefefe;
    margin: 5% auto 15% auto; /* 5% from the top, 15% from the bottom and centered */
    border: 1px solid #888;
    width: 80%; /* Could be more or less, depending on screen size */
}

/* Style the horizontal ruler */
hr {
    border: 1px solid #f1f1f1;
    margin-bottom: 25px;
}
 
/* The Close Button (x) */
.close {
    position: absolute;
    right: 35px;
    top: 15px;
    font-size: 40px;
    font-weight: bold;
    color: #f1f1f1;
}

.close:hover,
.close:focus {
    color: #f44336;
    cursor: pointer;
}

/* Clear floats */
.clearfix::after {
    content: "";
    clear: both;
    display: table;
}

/* Change styles for cancel button and signup button on extra small screens */
@media screen and (max-width: 300px) {
    .cancelbtn, .signupbtn {
       width: 100%;
    }
}

/* The message box is shown when the user clicks on the password field */
#message {
    display:none;
    background: #f1f1f1;
    color: #000;
    position: relative;
    padding: 20px;
    margin-top: 10px;
}

#message p {
    padding: 10px 35px;
    font-size: 18px;
}

/* Add a green text color and a checkmark when the requirements are right */
.valid {
    color: green;
}

.valid:before {
    position: relative;
    left: -35px;
    content: "✔";
}

/* Add a red text color and an "x" when the requirements are wrong */
.invalid {
    color: red;
}

.invalid:before {
    position: relative;
    left: -35px;
    content: "✖";
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

<div class="container">
<form name="regform" action="LoginController" method="post" onsubmit="return regValidate()">
	  <h1>Sign Up</h1>
      <p>Please create an account in order to use Dr. Book.</p>
      <hr>
      
      <label for="name"><b>Name</b></label>
      <input type="text" placeholder="Enter Name" name="name" required>
      
      <label for="username"><b>Username</b></label>
      <input type="text" placeholder="Enter Username" name="username" required><div id="username_error"></div>

      <label for="password"><b>Password</b></label>
      <input type="password" placeholder="Enter Password" name="password" id="password" required>

      <label for="retry-passsword"><b>Repeat Password</b></label>
      <input type="password" placeholder="Repeat Password" name="retry-password" id="retry-password" required><div id="password_error"></div>
      
      <label for="secretquestion"><b>Secret Question</b></label>
      <br><select>
			<option value="select">------------- Make a Selection -------------</option>
  			<option value="father">What is your father's middle name?</option>
  			<option value="mother">What is your mother's maiden name?</option>
  			<option value="street">What street did you grow up on?</option>
  			<option value="city">In what city were you born?</option>
		</select></br>
		<br>
		
	<label for="secretanswer"><b>Secret Answer</b></label>
	<input type="text" placeholder="Enter Your Secret Answer" name="secretanswer" id="secretanswer" required>
      
      <%--<label>
        <input type="checkbox" checked="checked" name="remember" style="margin-bottom:15px"> Remember me
      </label>--%>

    <p>By creating an account you agree to our <a href="#" style="color:dodgerblue">Terms & Privacy</a>.</p>

    <div class="clearfix">
        <button type="reset" name="reset" class="cancelbtn">Reset</button>
        <button type="submit" name="submit" value="register" class="signupbtn">Sign Up</button>
    </div>
      
    <div class="container signin">
    	<p>Already have an account? <a href="login.jsp">Sign in</a>.</p>
  	</div>
</form>
</div>

<div id="message">
  <h3>Password must contain the following:</h3>
  <p id="letter" class="invalid">A <b>lowercase</b> letter</p>
  <p id="capital" class="invalid">A <b>capital (uppercase)</b> letter</p>
  <p id="number" class="invalid">A <b>number</b></p>
  <p id="length" class="invalid">Minimum <b>8 characters</b></p>
</div>
				
<script>
var myInput = document.getElementById("password");
var letter = document.getElementById("letter");
var capital = document.getElementById("capital");
var number = document.getElementById("number");
var length = document.getElementById("length");

// When the user clicks on the password field, show the message box
myInput.onfocus = function() {
    document.getElementById("message").style.display = "block";
}

// When the user clicks outside of the password field, hide the message box
myInput.onblur = function() {
    document.getElementById("message").style.display = "none";
}

// When the user starts to type something inside the password field
myInput.onkeyup = function() {
  // Validate lowercase letters
  var lowerCaseLetters = /[a-z]/g;
  if(myInput.value.match(lowerCaseLetters)) {  
    letter.classList.remove("invalid");
    letter.classList.add("valid");
  } else {
    letter.classList.remove("valid");
    letter.classList.add("invalid");
  }
  
   //Validate capital letters
  var upperCaseLetters = /[A-Z]/g;
  if(myInput.value.match(upperCaseLetters)) {  
    capital.classList.remove("invalid");
    capital.classList.add("valid");
  } else {
    capital.classList.remove("valid");
    capital.classList.add("invalid");
  }

  // Validate numbers
  var numbers = /[0-9]/g;
  if(myInput.value.match(numbers)) {  
    number.classList.remove("invalid");
    number.classList.add("valid");
  } else {
    number.classList.remove("valid");
    number.classList.add("invalid");
  }
  
  // Validate length
  if(myInput.value.length >= 8) {
    length.classList.remove("invalid");
    length.classList.add("valid");
  } else {
    length.classList.remove("valid");
    length.classList.add("invalid");
  }
}
</script>

<%-- <form name="regform" action="LoginController" method="post" onsubmit="return regValidate()">
	<nav>
  		<a href="login.jsp">Login Page</a> |
  		<a href="/js/">Contact Us</a>
	</nav>
	<br>	
	<font size="5", face="verdana"> Looks like you haven't used Dr. Book before! </font><br>
	<font size="5", face="verdana"> Please register below </font>
	<br>${message}<br>
	<br>--%>	
	<%-- Username: <input type="text" name="username"> <br>
	<div id="username_error"></div><br>
	Customer name: <input type="text" name="name"><br>
	
	Password: <input type="password" name="password" id="password"> 
	<br>
	Re-Type Password: <input type="password" name="retry-password" id="retry-password"> 
	<br>
	<div id="password_error"></div><br>
	<input type="submit" name="submit" value="register" >
	<input type="reset" name="reset">--%>
	
	<%-- <table>
		<tr>
			<td>UserName</td>
			<td><input type="text" name="username"/><div id="username_error"></div></td>
		</tr>
		<tr>
			<td>Customer name</td>
			<td><input type="text" name="name"/></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><input type="password" name="password" id="password"/></td>
		</tr>
		<tr>
			<td>Re-Type Password</td>
			<td><input type="password" name="retry-password" id="retry-password"/><div id="password_error"></div></td>
		</tr>
		<tr>
			<td>Secret Question</td>
			<td><select>
			  		<option value="select">------------- Make a Selection -------------</option>
  					<option value="father">What is your father's middle name?</option>
  					<option value="mother">What is your mother's maiden name?</option>
  					<option value="street">What street did you grow up on?</option>
  					<option value="city">In what city were you born?</option>
				</select></td>
		</tr>
		<tr>
			<td>Secret Answer</td>
			<td><input type="text" name="secretanswer" id="secretanswer"/></td>
		</tr>
		<tr>
			<td><button type="submit" name="submit" value="register">Register</button>
			<button type="reset" name="reset">Reset</button></td>
		</tr>
	</table>
	<br>	
	<a href="TermsandConditions.jsp">Terms & Conditions</a>
	
	</form> --%>
	
</body>
</html>
