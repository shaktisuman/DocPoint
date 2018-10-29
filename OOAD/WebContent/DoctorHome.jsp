<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
   <head>
       <meta charset="utf-8">
       <title>DoctorHome</title>
       <link rel="stylesheet" href="./client.css">
   </head>
    <body>
     <nav>
          <ul>
              <li><a href="#">logout</a></li>
              
              
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
         
          <div class="box">
              <section>
              <h1>Appointments</h1>
              
              
              <p>some text <br> </p>
              <p>some text</p>
              <p>some text</p>
              <p>some text</p>
          </section>
          </div>
      </div>
      
     
      
      
    </body>
</html>
