<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="drbook.css">
<title>Book an Appointment</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>

<script>
$(document).ready(function(){
	$('#lblHi').html("Hi " + $.cookie("username"));
	var d = new Date();
    n = d.getMonth();
    if(n==1 || n==3 || n==5 || n==8 || n==10) 
    {
    	$("#31").hide();
    }
    const monthNames = ["January", "February", "March", "April", "May", "June",
    	  "July", "August", "September", "October", "November", "December"
    	];
    $('#m').html(monthNames[d.getMonth()]);
    $(document).on("click",".row1", function (event) {
    	var doc = $('#docList').find(":selected").text();
    	if(doc=="Pick a Doctor")
    	{
    		alert("Pick a Doctor to Book an Appointment!");
    	}
    	else {
    		var day = event.target.id;
            var str = monthNames[d.getMonth()] + " - " + day;
            $('#d').html(str);
            modal.style.display = "block";
    	}
    });
    $( "#docList" ).change(function() {
    	var doc = $('#docList').find(":selected").text();
    	alert( "Booking for: " + doc );
    	$("#bookForm").click();
    	
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

<label id='lblDocPick'>Pick a Doctor:</label>

<form name="dlist" action="BookController" method="post">
<select id='docList' name ='docList'>
<option value="pick" selected>Pick a Doctor</option>
<option value="Doc1">Doc 1</option>
<option value="Doc2">Doc 2</option>
<option value="Doc3">Doc 3</option>
</select>
<input id="bookForm" type="submit" name="submitDoc" value="dlist" style="display:none;">

</form>


<header id='calHdr'><b>Pick a Date: </b><b id='m'></b></header>

<section id='cal' class='groove'>
<section id='1' class = 'row1'>1</section>
<section id='2' class = 'row1'>2</section>
<section id='3' class = 'row1'>3</section>
<section id='4' class = 'row1'>4</section>
<section id='5' class = 'row1'>5</section>
<section id='6' class = 'row1'>6</section>
<section id='7' class = 'row1'>7</section>
<section id='8' class = 'row1'>8</section>
<section id='9' class = 'row1'>9</section>
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

<!-- The Modal -->
<div id="myModal" class="modal">

  <!-- Modal content -->
  <div class="modal-content">
    <span class="close">&times;</span>
    <b>Pick a Slot for Day:</b><b id='d'></b>
    <p>Available:
    <select id='slotList'>
    	<option value="choose" selected>Choose</option>
		<option value="Slot1">Slot 1</option>
		<option value="Slot2">Slot 2</option>
		<option value="Slot3">Slot 3</option>
	</select>
    </p>
    <button id="bk"> Book!</button>
    <button id="cls"> Close</button>
  </div>

</div>

<script type="text/javascript">
//Get the modal
var modal = document.getElementById('myModal');

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks on <span> (x), close the modal
span.onclick = function() {
    modal.style.display = "none";
}

bk.onclick = function() {
	var sel = $('#slotList').find(":selected").text();
	if (sel=="Choose")
		{
		alert("Choose a slot!");
		}
	else {
		alert("Booked for:" + sel);
	    modal.style.display = "none";
	}
}

cls.onclick = function() {
    modal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}
</script>
</body>
</html>
