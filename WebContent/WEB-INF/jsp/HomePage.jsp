<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.6.1.min.js"></script>
<script type="text/javascript"
	src="http://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
<title>Insert title here</title>

<script type="text/javascript">
	function myFunction() {
		$("#div1").hide();
		$("#div2").hide();
		$("#div3").hide();
		$("#div4").hide();
	}
	function GREF() {
		$("#div1").fadeIn();
		$("#div2").fadeOut();
		$("#div3").fadeOut();
		$("#div4").fadeOut();
	}

	function UEE() {
		$("#div2").fadeIn();
		$("#div1").fadeOut();
		$("#div3").fadeOut();
		$("#div4").fadeOut();
	}

	function SEE() {
		$("#div3").fadeIn();
		$("#div1").fadeOut();
		$("#div2").fadeOut();
		$("#div4").fadeOut();
	}
</script>
<link rel="stylesheet" type="text/css" href="../resources/all.css">
</head>
<body onload="myFunction()">
	<header> <img src="../images/Logo.png"
		style="margin: 10px 200px 10px 10px;"> <font size="6">Event
		Manager Interface</font> </header>
	<br>
	<br>
	<br>
	<table style="text-align: center; width: 100%;">
		<tr>
			<td width="30%"><a href="#" onclick="GREF()">Generate Report
					For Existing Event</a>
				<div id="div1">
				<form:form
						action="/MainEventManager/generateReportController/generateReports"
						modelAttribute="myModel">

						<br>
						<br>
						<form:select name="file" class="textbox" path="file"
							items="${files}" />
						<br>
						<br>
						<input type="submit" class="button" value="Submit">
					</form:form>
			
					<br> <br><br>
				</div></td>

			<td width="40%"><a href="#" onclick="UEE()">Update Existing
					Event</a>
				<div id="div2">
					<form:form
						action="/MainEventManager/controller/searchExistingEventFiles"
						modelAttribute="myModel">

						<br>
						<br>
						<form:select name="file" class="textbox" path="file"
							items="${files}" />
						<br>
						<br>
						<input type="submit" class="button" value="Submit">
					</form:form>
					<br><br>
				</div></td>

			<td width="30%"><a
				href="/MainEventManager/schedulingEvents/index" onclick="SEE()">Schedule
					Existing Event</a>
					<div id="div3">
					<br>
					Loading Scheduling Reports
					 <br></div></td>
		</tr>
	</table>
	<br>
	<br>
	<center>
		<a href="/MainEventManager/controller/eventManagerInterface">Click
			to Create new Event</a>
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