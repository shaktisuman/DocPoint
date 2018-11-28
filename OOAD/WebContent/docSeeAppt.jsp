<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="box">
              <section>
              <h1>Appointments</h1>
              <div class="btngrp">
              <button class="button" style="vertical-align:middle">Cancel</button>
              <select id='appList' name ='appList' style="width:500px;">
				<% 
			try {
				List<String> apps = (List<String>)request.getAttribute("allApptStr"); 
				for(int i = 0; i< apps.size();i++) { %>
					<option value=<%=(apps.get(i).split("_")[0])%>><%=(apps.get(i)).split("_")[1]%> </option> <%
				}
			}
				catch(Exception e) {
		
					
				}
			%>
</select>
              </div>
          </section>
          </div>
</body>
</html>
