<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body
	style="background-image: url('image/forgotpassword.jpg'); background-repeat: no-repeat; background-size: 500%;">
	>
	<div>
		<form action="forgotpassword.odc" method="post">

			<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
				<a class="navbar-brand" href="#">Temple Registration</a> <input
					type="reset" value="Register" id="done"
					onclick="window.location='Register.jsp'"> <input
					type="reset" value="Resend" id="done"
					onclick="window.location='Mail.jsp'"> <input
					type="reset" value="Login" id="done"
					onclick="window.location='Login.jsp'"> <input type="reset"
					value="ForgotPassword" id="forgot"
					onclick="window.location='ForgotPassword.jsp'"> <input
					type="reset" value="Logout" id="done"
					onclick="window.location='Logout.jsp'">
			</nav>
			<br>
			<h2>set your password through the registration mailId</h2>

			<label>Enter Email-Id: </label> <input type="text" name="emailId"
				placeholder=" email"><br>

			<div>
				<input type="submit" value="Forgot Password" id="forgot">
			</div>

			<h2>Details sent to registered email successfully</h2>

		</form>
	</div>

	<h5
		style="background: grey; color: white; padding: 10px; font-size: 20px">copyrights
		to X-workz</h5>
</body>
</body>
</html>