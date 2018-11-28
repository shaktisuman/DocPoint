<%@page import="db.DbManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
       <meta charset="utf-8">
       <title>PatientHome</title>
       <link rel="stylesheet" href="./client.css">
   </head>
    <body>
     <nav>
          <ul>
              <li><a href="logout.jsp">logout</a></li>
             
              
          </ul>
      </nav> 
     <header>
     <h1>CLIENT  INFORMATION</h1>
     </header>
     
      <h2>${message} </h2> 
      <button class="button" style="vertical-align:middle" onclick="location.href = 'bookAppointment.jsp';" id="bookApp">Book Appointment</button>
      <button class="button" style="vertical-align:middle" onclick="location.href = 'doctorregister.jsp';" id="doctorreg">Doctor Register</button>
      <div class="row1">
            
              <div class="box">
              <section>
              <h1>Profile</h1>
              
              <p >Name : ${name}  </p>
              
          </section>
          </div>
         
          
      </div>
      
     
      
      
    </body>
</html>
