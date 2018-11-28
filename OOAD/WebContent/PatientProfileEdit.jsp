<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
       <meta charset="utf-8">
       <title></title>
       <link rel="stylesheet" href="./client.css">
       <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="jquery.session.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
       
       <script type="text/javascript">
         function goHome() {
        	 $("#uname").attr("value",$.cookie("username"));
        	 $("#submit").click();

         }
       </script>
   </head>
<form name="loginform" action="PatientController" method="post" >
    <h1>Edit Profile</h1>
    
        Name <br>
        <input type="text" name="name" placeholder="Name"><br>
        Date of Birth(MM/DD/YYYY)
        <input type="text" name="birthday"  placeholder="(MM/DD/YYYY)"><br>
        Address: <input type="text" name="street" placeholder="Street">  City:<input type="text" name="city" placeholder="City"> <br>
        Gender: <input type="text" name="gender" placeholder="Gender"><br>
        Medical History <br>
        <input type="checkbox" name="sickness" value="cancer"> Cancer
        <input type="checkbox" name="sickness" value="fever"> Fever/Cold
        <input type="checkbox" name="sickness" value="diabetes"> Diabetes <br>
        <input type="checkbox" name="sickness" value="bleeding"> Bleeding Problems 
        <input type="checkbox" name="sickness" value="asthma"> Asthma
        <input type="checkbox" name="sickness" value="diabetes"> Diabetes <br>
        <input type="checkbox" name="sickness" value="heart"> Heart 
        <input type="checkbox" name="sickness" value="highBlood"> High Blood Pressure
        <input type="checkbox" name="sickness" value="Stroke"> Stroke <br>
        <input id="uname" name="uname" type="text" style="display:none;">
    <input id="submit" type="submit" name="submit" value="submit" style="display:none;">
    <button class="button" style="vertical-align:middle" onclick="goHome()">Submit</button>
   
    </form>
    
   
</html>
