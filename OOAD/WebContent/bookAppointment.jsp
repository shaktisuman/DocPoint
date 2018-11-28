<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="drbook.css">
<title>Book an Appointment</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="jquery.session.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>

<script>
$(document).ready(function(){
	//pre-fetch list of doctors
	<%
	try {
		if(request.getAttribute("confMSG")=="success") {
			%> alert("Success");<%
		}
	}
	catch(Exception e) {
		
	}
	
	%>
	
	<%
	try {
		//code to hide book div unless showBookDiv is sent
		if((Boolean)request.getAttribute("showBookDiv")) {%>
		$("#book").show();
	<%}
		else {%>
			$("#book").hide();
		<%}
		
	}
	catch(Exception e) {%>
	$("#book").hide();
<%}
	try {
		if((String)request.getAttribute("firstLoad") == "done") {
			System.out.println("Loaded already.");
		}
		else {%>
			$("#getDoc").click();
		<%}
	}
	catch(Exception e) {
		
	}
	%>
	
	$('#lblHi').html("Hi " + $.cookie("username"));

	var d = new Date();
    n = d.getMonth();
    y = d.getFullYear();
    if(n==1 || n==3 || n==5 || n==8 || n==10) 
    {
    	$("#31").hide();
    }
    const monthNames = ["January", "February", "March", "April", "May", "June",
    	  "July", "August", "September", "October", "November", "December"
    	];
    $('#m').html(monthNames[d.getMonth()]);
    $(document).on("click",".row1", function (event) {
    	//var doc = $('#docList').find(":selected").text();
    	var doc = $.session.get("doc");
    	if(doc=="Pick a Doctor" || doc=="undefined" )
    	{
    		alert("Pick a Doctor to Book an Appointment!");
    	}
    	else {
    		var day = event.target.id;
            var str = monthNames[d.getMonth()] + " - " + day;
            $('#d').html(str);
            alert( "Booking for: " + $.session.get("doc").split("_")[1]);
          	//getting date here:
        	var dt = new Date();
    		m = dt.getMonth();
    		var s;
    		if(m+1<=9) {
   			s = "0"+ (m+1).toString();
    		}
    		else {
    		s = (m+1).toString();
    		}
    		var finalDt = dt.getFullYear() + "-" + s + "-" + day;
    		$.session.set("finalDt", finalDt);
            $("#selDate").attr("value",finalDt);
            $("#selDoc").attr("value",doc);
            $("#getSlot").click();
            $.session.set("dId",$.session.get("doc").split("_")[0])
            $.session.set("doc", "undefined");
            book.style.display = "block";
    	}
    });
    $( "#docList" ).change(function() {
    	var doc = $('#docList').find(":selected").val();
    	$.session.set("doc", doc);
    	});
    $("#bk").click(function(){
    	var sel = $('#slotList').find(":selected").text();
    	var sendSlot = $('#slotList').find(":selected").val().split("_")[0];
    	if (sel=="Choose")
    		{
    		alert("Choose a slot!");
    		}
    	else {
    		alert("Booked for:" + sel);
    		$("#sId").attr("value",sendSlot);
    		$("#pId").attr("value",$.cookie("username"));
    		$("#dId").attr("value",$.session.get("dId"));
    		$("#saveDt").attr("value",$.session.get("finalDt"));
    		$("#save").click();
    		alert("Booking Success!");
    	    book.style.display = "none";
    	}
    });
    $("#cls").click(function(){
    	    book.style.display = "none";
    });
    
});
</script>
<style>
body {
	font-family: Arial, Helvetica, sans-serif;
	background-image: url("img.svg");
    
	}

/* The Modal (background) */
.modal {
    display: none; /* Hidden by default */
    position: fixed; /* Stay in place */
    z-index: 1; /* Sit on top */
    padding-top: 100px; /* Location of the box */
    left: 0;
    top: 0;
    width: 100%; /* Full width */
    height: 100%; /* Full height */
    overflow: auto; /* Enable scroll if needed */
    background-color: rgb(0,0,0); /* Fallback color */
    background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
}

/* Modal Content */
.modal-content {
    background-color: #fefefe;
    margin: auto;
    padding: 20px;
    border: 1px solid #888;
    width: 75%;
}

/* The Close Button */
.close {
    color: #aaaaaa;
    float: right;
    font-size: 28px;
    font-weight: bold;
}

.close:hover,
.close:focus {
    color: #000;
    text-decoration: none;
    cursor: pointer;
}
</style>

</head>
<body>

<label id='lblHi'></label>

<a id='logout' href="logout.jsp"> Logout</a>

<a id = 'home' href="PatientHome.jsp">Home </a>

<center><b><h2>Book an Appointment!</h2></b></center>

<form name="fetchDList" action="BookController" method="post">
<input id="getDoc" type="submit" name="submit" value="fetchDList" style="display:none;">
</form>

<form name="slotList" action="BookController" method="post">
<input id="selDate" name="selDate" type="text" style="display:none;">
<input id="selDoc" name="selDoc" type="text" style="display:none;">
<input id="getSlot" type="submit" name="submit" value="slotList" style="display:none;">
</form>

<label id='lblDocPick'>Pick a Doctor:</label>

<select id='docList' name ='docList'>
<option value="pick" selected>Pick a Doctor</option>
<% 
try {
	List<String> doctors = (List<String>)request.getAttribute("names"); 
	for(int i = 0; i< doctors.size();i++) { %>
		<option value=<%=(doctors.get(i))%>><%=(doctors.get(i)).split("_")[1]%> </option> <%
}
}
	catch(Exception e) {
		
	}
%>
</select>


<header id='calHdr'><b>Pick a Date: </b><b id='m'></b></header>

<section id='cal' class='groove'>
<section id='01' class = 'row1'>1</section>
<section id='02' class = 'row1'>2</section>
<section id='03' class = 'row1'>3</section>
<section id='04' class = 'row1'>4</section>
<section id='05' class = 'row1'>5</section>
<section id='06' class = 'row1'>6</section>
<section id='07' class = 'row1'>7</section>
<section id='08' class = 'row1'>8</section>
<section id='09' class = 'row1'>9</section>
<section id='10' class = 'row1'>10</section>
<section id='12' class = 'row1'>11</section>
<section id='12' class = 'row1'>12</section>
<section id='13' class = 'row1'>13</section>
<section id='14' class = 'row1'>14</section>
<section id='15' class = 'row1'>15</section>
<section id='16' class = 'row1'>16</section>
<section id='17' class = 'row1'>17</section>
<section id='18' class = 'row1'>18</section>
<section id='19' class = 'row1'>19</section>
<section id='20' class = 'row1'>20</section>
<section id='21' class = 'row1'>21</section>
<section id='22' class = 'row1'>22</section>
<section id='23' class = 'row1'>23</section>
<section id='24' class = 'row1'>24</section>
<section id='25' class = 'row1'>25</section>
<section id='26' class = 'row1'>26</section>
<section id='27' class = 'row1'>27</section>
<section id='28' class = 'row1'>28</section>
<section id='29' class = 'row1'>29</section>
<section id='30' class = 'row1'>30</section>
<section id='31' class = 'row1'>31</section>
</section>

<div id="book" style="position:absolute; top:550px; left:25px;">
    <b>Pick a Slot for Day:</b><!-- <b id='d'><%=request.getAttribute("dt") %></b> -->
    <p>Available:
    <select id='slotList'>
    	<option value="Pick a Slot" selected>Choose</option>
		<% 
try {
	List<String> slots = (List<String>)request.getAttribute("slots"); 
	for(int i = 0; i< slots.size();i++) { %>
		<option value=<%=(slots.get(i))%>><%=(slots.get(i)).split("_")[1]%> </option> <%
}
}
	catch(Exception e) {
		
	}
%>
	</select>
    </p>
    <form name="finishAppt" action="BookController" method="post">
    <input id="sId" name="selSlotId" type="text" style="display:none;">
    <input id="pId" name="selPatId" type="text" style="display:none;">
    <input id="dId" name="dId" type="text" style="display:none;">
    <input id="saveDt" name="saveDt" type="text" style="display:none;">
    <button id="bk">Finish</button>
<input id="save" type="submit" name="submit" value="finishAppt" style="display:none;">
</form>
    <button id="cls" style="position:absolute;top:70px;left:60px;width:100px;"> Start Over!</button>
  </div>
</body>
</html>
