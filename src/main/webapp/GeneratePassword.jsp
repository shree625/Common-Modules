<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body
	style="background-image: url('image/resetpassword.jpg'); background-repeat: no-repeat; background-size: 100%;">
	>
	<nav class="navbar navbar-dark bg-dark">
	<form class="form-inline">
		<nav class="navbar navbar-light bg-light"> Generate Password if
		login for first time<input type="reset" value="Register" id="done"
			onclick="window.location='Register.jsp'"> <input type="reset"
			value="Resend Mail" id="done" onclick="window.location='Mail.jsp'">
		<input type="reset" value="Login" id="done"
			onclick="window.location='Login.jsp'"> </nav>
	</form>
	</nav>
	<div>
		<form action="generatepassword.odc" method="post">
			<label>Enter Email-Id: </label> <input type="text" name="emailId"
				placeholder="email"><br>

			<div>
				<input type="submit" value="Generate Password" id="generate">
			</div>
		</form>
	</div>

	<h5
		style="background: grey; color: white; padding: 10px; font-size: 20px">Copy
		right to x-workz</h5>
</body>
</html>