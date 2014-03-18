<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>UpdatePage</title>
<link rel="stylesheet" type="text/css" href="../resources/all.css">
</head>
<body>

	<header> <img src="../images/Logo.png"
		style="margin: 10px 100px 10px 10px;"> <font size="6">Event
		Manager  Update Entry Interface</font> </header>
	<br>
	<br>

	<form action="/MainEventManager/generateReportController/updateEntry">
		<table id="tablepaging" class="yui" align="center">
			<tr>
				<c:forEach var="columnName" items="${columnNames}">
					<th>${columnName}</th>
				</c:forEach>
			</tr>
			<%
				int i = 0;
			%>
			<tr>
				<c:forEach var="columnValue" items="${columnValues}">
					<%
						if (i == 0) {
					%>
					<td><input type="text" name="name<%=i%>"
						value="${columnValue}" readonly="readonly" /></td>
					<%
						} else {
					%>
					<td><input type="text" name="name<%=i%>"
						value="${columnValue}" /></td>
					<%
						}
							i++;
					%>
				</c:forEach>
				<td><input type="submit" class="button" value="update"></td>
				</tr>
			<tr>
				<td><input type="hidden" name="eventName"
					value="<%=session.getAttribute("file")%>"></td>
			</tr>
		</table>
	</form>

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
	<br>
	<br>
	<br>

	<footer>
	<p>Help?</p>
	</footer>
</body>
</html>