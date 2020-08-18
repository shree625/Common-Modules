<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<body
	style="background-image: url('image/Homepage.jpg'); background-repeat: no-repeat; background-size: 100%;">
	>
	<h2 align="center">Welcome,${emailId }</h2>
	<!--  h1 align="left">Welcome to IskonTemple</h1>-->
	<p class="text-success"></p>
	<div class="p-3 mb-2 bg-gradient-danger text-white">Welcome to
		iskon temple</div>


	<form action="homePage.doc" method="post">

		<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="BookingVisit.jsp"><span class="glyphicon glyphicon-user"></span>Book</a></li>
				<li><a href="BookingVisit.jsp"><span class="glyphicon glyphicon-log-in"></span>Search</a></li>
			</ul>
		</div>
		</nav>
		<h5
			style="background: grey; color: white; padding: 10px; font-size: 20px">Copy
			right to x-workz</h5>
	</form>

</body>
</html>