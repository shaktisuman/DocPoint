<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
   <head>
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="jquery.session.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
   
   <style type="text/css">
/* Change the link color to #111 (black) on hover */
.link-lookalike: hover {
    background-color: #111;
}
 
   </style>
       <meta charset="utf-8">
       <title>DoctorHome</title>
       <link rel="stylesheet" href="./client.css">
   </head>
    <body>
     <nav>
          <ul>
          
              <li><a href="doctorlogin.jsp">logout</a></li>
              
              
          </ul>
      </nav> 
     <header>
     <h1>DOCTOR INFORMATION</h1>
     </header>
     
      <h2>${message} </h2> 
     
      <div class="row1">
            
              <div class="box">
              <section>
              <h1>Profile</h1>
              
              <p >Name :  ${name}  </p>
              <p>Specialty : ${specialty}</p>
              <p>Info: ${info}</p>
          </section>
          </div>
          <script type="text/javascript">
         function seeApps() {
        	 //alert("java Script");
        	 	$("#uname").attr("value",$.cookie("username"));
        	 	//alert("java Script");
        		getAppt.click();
        		//alert("out");
         }
         
         </script>
          <div class="box">
              <section>
              <h1>Appointments</h1>
              <div class="btngrp">
              <button class="button" style="vertical-align:middle" onclick="seeApps()" id="seeApp">See Appointments</button>
              <form name="seeAppt" action="DoctorController" method="post">
              <input id="uname" name="uname" type="text" style="display:none;">
				<input id="getAppt" type="submit" name="submit" value="seeAppt" style="display:none;">
				</form>
              </div>
          </section>
          </div>
      </div>
      
     
      
    </body>
</html>
