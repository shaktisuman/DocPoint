<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
       <meta charset="utf-8">
       <title></title>
       <link rel="stylesheet" href="./client.css">
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
      <button onclick="location.href = 'bookAppointment.jsp';" id="bookApp">Book Appointment</button>
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
         
          <div class="box">
              <section>
              <h1>Appointments</h1>
              <div class="btngrp">
              <button>Reschedule</button>
              <button>Cancel</button>
              </div>
              
              <p>some text <br> </p>
              <p>some text</p>
              <p>some text</p>
              <p>some text</p>
          </section>
          </div>
      </div>
      
     
      
      
    </body>
</html>
