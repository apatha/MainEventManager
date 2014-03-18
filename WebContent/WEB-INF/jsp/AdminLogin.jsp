<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Event Manager</title>

<style>
a {
	text-decoration: none;
}

a:hover {
	text-shadow: 0px 0px 4px #663300;
	font-weight: bold;
}

header,footer {
	text-align: center;
	background: #F0ECFF;
	border: 1px solid black;
	font-family: Tempus Sans ITC;
	text-shadow: 1px 2px 3px #5C5C3D;
	color: #123263;
	font-size: 20px;
	background: -webkit-gradient(linear, center top, center bottom, from(#F0E2F0),
		to(#fff) );
	background-image: linear-gradient(#F0E2F0, #fff);
	background: #F0ECFF;
}

body {
	margin-top: 1;
	margin-left: 1;
	margin-right: 1;
	margin-bottom: 1;
	border: 1px solid black;
	font-weight: bold;
	color: #6C1987;
	text-shadow: 1px 0px 1Px #663300;
	box-shadow: 0 0 3px 2px #FFE0E0;
	font-size: 18px;
	background: -webkit-gradient(linear, center top, center bottom, from(#fff),
		to(#CAE6E6) );
	box-shadow: inset 0px 0px 1px 1px rgba(0, 0, 0, 0.5);
}

.textbox {
	border: 2px outset #848484;
	-webkit-border-radius: 30px;
	-moz-border-radius: 30px;
	border-radius: 30px;
	padding-left: 10px;
	padding-right: 10px;
	box-shadow: 0 0 2px 2px #C6AEC6;
	background: -webkit-gradient(linear, center top, center bottom, from(#fff),
		to(#CDCFD2) );
	font-family: "Times New Roman", Georgia, Serif;
	text-shadow: 0px 0px 1px #663300;
}

.button {
	-webkit-border-radius: 5px;
	-moz-border-radius: 5px;
	border-radius: 5px;
	border: 2px solid #848484;
	box-shadow: 0 0 2px 2px #B2B2CC;
	font-family: Monotype Corsiva, Times, serif;
	font-weight: bold;
	padding-left: 10px;
	padding-right: 10px;
	background: -webkit-gradient(linear, center top, center bottom, from(#C3D7EB),
		to(#fff) );
	text-shadow: 0px 0px 1px #663300;
}

.textbox:hover {
	border: 2px outset #848484;
	-webkit-border-radius: 30px;
	-moz-border-radius: 30px;
	border-radius: 30px;
	padding-left: 10px;
	padding-right: 10px;
	box-shadow: 0 0 2px 2px #C6AEC6;
	background: -webkit-gradient(linear, center top, center bottom, from(#CDCFD2),
		to(#fff) );
	text-shadow: 0px 0px 2px #663300;
}

.button:hover {
	-webkit-border-radius: 5px;
	-moz-border-radius: 5px;
	border-radius: 5px;
	border: 2px solid #8585E0;
	box-shadow: 0 0 2px 2px #B2B2CC;
	font-family: Monotype Corsiva, Times, serif;
	font-weight: bold;
	padding-left: 10px;
	padding-right: 10px;
	background: -webkit-gradient(linear, center top, center bottom, from(#fff),
		to(#C3D7EB) );
	text-shadow: 0px 0px 4px #663300;
}
</style>
</head>

<body>
	<header> <font size="6">Event Manager Interface</font> </header>

	<center>
		<h2
			style="font-family: Tempus Sans ITC; text-shadow: 1px 0px 1Px #663300;">ADMIN
			LOGIN FORM</h2>

		<form:form action="/MainEventManager/controller/AfterLogin"
			modelAttribute="adminLoginModel">

<table align="center">

				<tr>

					<td>User Name:</td>

					<td><form:input class="textbox" path="userName" required="required"/></td>
					
				</tr>
				<tr>
				</tr>
				<tr></tr>
				<tr></tr>
				<tr>

					<td>Password:</td>


					<td><form:password class="textbox" path="password" required="required"/></td>

				</tr>
				<tr>
					<td><input type="submit" class="button" value="Submit" /></td>
					<td><input type="reset" class="button" value="Reset" /></td>
				</tr>
			</table>

		</form:form>
		${invalid }
	</center>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>


	<footer>
	<p>Help?</p>
	</footer>
</body>


</html>