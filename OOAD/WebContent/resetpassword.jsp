<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="script.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Reset Password</title>
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
input[type=text], input[type=password], input[type=date] {
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

/* Float cancel and signup buttons and add an equal width */
.signupbtn {
  float: left;
  width: 100%;
}

/* Add padding to container elements */
.container {
    padding: 16px;
}

</style>
</head>




<body>
<a href="login.jsp">
  <img src="http://i1383.photobucket.com/albums/ah307/yaygreat/logo_zpshutgkrz5.png" alt="Dr. Book" style="width:150px">
</a>

${message}
${successMessage}
<div class="container">
<form name="forgotpassform" action="ResetPasswordController" method="post">
	  <h1>Password Reset</h1>
      <hr>
      
      <p >Secret Question : ${secretquestion}  </p>
      <%--<p id="demo"></p> --%>
      <%--<display:column>
	    <c:choose>
	        <c:when test="${secretquestion.equals('fmiddle')}">What is your father's middle name?</c:when>
	        <c:when test="${secretquestion.equals('mothermaiden')}">What is your mother's maiden name?</c:when>
	        <c:when test="${secretquestion.equals('homestreet')}">What street did you grow up on?</c:when>
	       	<c:when test="${secretquestion.equals('homecity')}">In what city were you born?</c:when>
	        <c:otherwise>undefined</c:otherwise>
	    </c:choose>
	  </display:column> --%>
      
      <label for="secretanswer"><b>Secret Answer</b></label>
	  <input type="text" placeholder="Enter Your Secret Answer" name="secretanswer" id="secretanswer" required>
	  
      <label for="password"><b>Password</b></label>
      <input type="password" placeholder="Enter Password" name="password" id="password" required>

      <label for="retry-passsword"><b>Repeat Password</b></label>
      <input type="password" placeholder="Repeat Password" name="retry-password" id="retry-password" required><div id="password_error"></div>

    <div class="clearfix">
        <button type="submit" name="submit" value="submit" class="signupbtn">submit</button>
    </div>
      
</form>
</div>

<script>
var text;
var sq = ${secretquestion};
switch(sq){
	case "fathermiddle":
		text = "What is your father's middle name?";
		break;
	case "mothermaiden":
		text = "What is your mother's maiden name?"
		break;
	case "homestreet":
		text = "What street did you grow up on?";
		break;
	case "homecity":
		text = "In what city were you born?";
		break;
}
document.getElementById("demo").innerHTML = text;
</script>


</body>
</html>
