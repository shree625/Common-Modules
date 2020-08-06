<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Xworkz</title>
</head>
<body>
	<jsp:include page="header.html" />
	<div>
		<h2>Personal Information</h2>
		<form action="register.odc" method="post">

			<label> Name: </label>
			<input type="text" name="name" placeholder=" name"><br>
			<label> Mobile number: </label>
			<input type="text" name="mobileNumber" placeholder=" mobile number"><br>
			<label>Enter Address: </label>
			<input type="text" name="address" placeholder=" address"><br>
			<label>Enter age: </label> 
			<input type="text" name="age" placeholder="age"><br>
			<label>Enter Email-Id: </label>
			<input type="text" name="emailId" placeholder=" email"><br>
			<label>Enter State: </label>
			<input type="text" name="state" placeholder="enter state"><br>
			<hr>

			<h2>Visiting Details</h2><br>
			<label>Date of visiting: </label>
			<input type="date" name="date" placeholder="visiting date"><br><br>
			
				<!-- for(AppPropertyDTO seList:specialEntryList){
						seList.getPropertyName();
				} -->
			<label>Select Entrance Type : </label> <select name="selist" id="sel" style="width: 50px;">
				<c:forEach var="selist" items="${specialList}">
					<option value="${selist.propValue}">${selist.propName}</option>
				</c:forEach>
			</select> <br> 
				<label>Select number of people:</label>
			<input type="text" name="numberOfPersons" placeholder="number of persons"><br>
			 
			<label>Select Prasada type: </label> <select name="prasada" id="sel"  style="width: 50px;">
				<c:forEach var="prList" items="${prasadList}"
				>
					<option value="${prList.propValue}">${prList.propName}</option>
				</c:forEach>
			</select> <br> 
			<label>Select valid ID Type : </label> <select name="idCard" id="sel"  style="width: 50px;">
				<c:forEach var="idList" items="${identityList}">
					<option value="${idList.propValue}">${idList.propName}</option>
				</c:forEach>
			</select> <br> 
			<label>Enter Id card number: </label>
			<input type="text" name="idNumber" placeholder=" Id card number"><br>
			
			<label>Select Pooja Type : </label> <select name="ptList" id="sel" style="width: 50px;">
				<c:forEach var="ptList" items="${poojaList}" >
					<option value="${ptList.propValue}">${ptList.propName}</option>
				</c:forEach>
			</select>

			<div>
				<input type="submit" value="Submit" id="done"> 
				<input type="reset" value="Reset" id="done">	
			</div>
			</form>
			<form action="Request.jsp" method="post">
		<input type="submit" value="request details">
		</form>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>