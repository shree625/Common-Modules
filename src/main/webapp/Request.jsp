<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
	<form action="request.doc" method="post">
	<div align="center">
		<h2 align="center">Enter Email to receive Details:</h2>
		<label>Enter Email-Id: </label> 
		<input type="text" name="emailId" placeholder="enter email">
		<button type="submit" class="btn btn-info">Request</button>
	</div>
	</form>
</body>
</html>
