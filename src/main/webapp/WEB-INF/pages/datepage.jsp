<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- <meta http-equiv="refresh" content="1" /> -->
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js">
</script>
</head>
<body>
<p id="demo" style="font-size:20px; color:#909090" align="center" style="position:relative;">

</p>

<script>
 var myVar=setInterval(function () {myTimer()}, 1000);
 var counter = 0;
 function myTimer() {
     var date = new Date();
     document.getElementById("demo").innerHTML = date.toUTCString();
 }
</script>

</body>
</html>