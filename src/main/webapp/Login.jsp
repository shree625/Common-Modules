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
<body
	style="background-image: url('image/loginbackgroundimage.jpg'); background-repeat: no-repeat; background-size: 500%;">
	>

	<nav class="navbar navbar-dark bg-dark">
	<form class="form-inline">
		<nav class="navbar navbar-light bg-light"> Login <input
			type="reset" value="Register" id="done"
			onclick="window.location='Register.jsp'"> <input type="reset"
			value="Resend Mail" id="done" onclick="window.location='Mail.jsp'">
		<input type="reset" value="Login" id="done"
			onclick="window.location='Login.jsp'"> </nav>
	</form>
	</nav>
	<div>
		<form action="login.odc" method="post">
			<label>Enter Email-Id: </label> <input type="text" name="emailId"
				placeholder="enter email"><br> <label>Enter
				Password: </label> <input type="text" name="password"
				placeholder="enter password"><br>
			<div>
				<button type="button" class="btn btn-link">Login</button>
				<input type="submit" value="Login" id="done"> <a
					href="GeneratePassword.jsp" value="Login for first time">Login
					for first time</a> <a href="HomePage.jsp">HomePage</a>
			</div>
		</form>
	</div>

	<h5
		style="background: grey; color: white; padding: 10px; font-size: 20px">Copy
		right to x-workz</h5>

</body>
</html>