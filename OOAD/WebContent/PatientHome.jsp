<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
       <meta charset="utf-8">
       <title>PatientHome</title>
       <link rel="stylesheet" href="./client.css">
       <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="jquery.session.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
   </head>
    <body>
     <nav>
          <ul>
              <li><a href="logout.jsp">logout</a></li>
              <li><a href="PatientProfileEdit.jsp">Edit Profile</a></li>
              
          </ul>
      </nav> 
     <header>
     <h1>CLIENT  INFORMATION</h1>
     </header>
     
      <h2>${message} </h2> 
      <button class="button" style="vertical-align:middle" onclick="location.href = 'bookAppointment.jsp';" id="bookApp">Book Appointment</button>
      <div class="row1">
            
              <div class="box">
              <section>
              <h1>Profile</h1>
              
              <p >Name : ${name}  </p>
              <p>Birthdate : ${birthdate}</p>
              <p>Address : ${address} City : ${city} </p>
              <p>Medicalhistory : ${medicalhistory}</p>
              <p>Gender: ${Gender}</p>
          </section>
          </div>
         <script type="text/javascript">
         function seeApps() {
        	 $("#uname").attr("value",$.cookie("username"));
        	 $("#getAppt").click();

         }
         
         </script>
          <div class="box">
              <section>
              <h1>Appointments</h1>
              <div class="btngrp">
              <button class="button" style="vertical-align:middle" onclick="seeApps()" id="seeApp">See Appointments</button>
              <form name="seeAppt" action="PatientController" method="post">
              <input id="uname" name="uname" type="text" style="display:none;">
				<input id="getAppt" type="submit" name="submit" value="seeAppt" style="display:none;">
				</form>
              </div>
          </section>
          </div>
      </div>
      
     
      
      
    </body>
</html>
