<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="../resources/all.css">

<style type="text/css">

.pg-normal {
	color: #000000;
	font-size: 15px;
	cursor: pointer;
	background: #D0B389;
	padding: 2px 4px 2px 4px;
}

.pg-selected {
	color: #fff;
	font-size: 15px;
	background: #000000;
	padding: 2px 4px 2px 4px;
}

table.yui {
	font-family: arial;
	border-collapse: collapse;
	border: solid 3px #7f7f7f;
	font-size: small;
}

table.yui td {
	padding: 5px;
	border-right: solid 1px #7f7f7f;
}

table.yui .even {
	background-color: #EEE8AC;
}

table.yui .odd {
	background-color: #F9FAD0;
}

table.yui th {
	border: 1px solid #7f7f7f;
	padding: 5px;
	height: auto;
	background: #D0B389;
}

table.yui th a {
	text-decoration: none;
	text-align: center;
	padding-right: 20px;
	font-weight: bold;
	white-space: nowrap;
}

table.yui tfoot td {
	border-top: 1px solid #7f7f7f;
	background-color: #E1ECF9;
}

table.yui thead td {
	vertical-align: middle;
	background-color: #E1ECF9;
	border: none;
}

table.yui thead .tableHeader {
	font-size: larger;
	font-weight: bold;
}

table.yui thead .filter {
	text-align: right;
}

table.yui tfoot {
	background-color: #E1ECF9;
	text-align: center;
}

table.yui .tablesorterPager {
	padding: 10px 0 10px 0;
}

table.yui .tablesorterPager span {
	padding: 0 5px 0 5px;
}

table.yui .tablesorterPager input.prev {
	width: auto;
	margin-right: 10px;
}

table.yui .tablesorterPager input.next {
	width: auto;
	margin-left: 10px;
}

table.yui .pagedisplay {
	font-size: 10pt;
	width: 30px;
	border: 0px;
	background-color: #E1ECF9;
	text-align: center;
	vertical-align: top;
}
</style>
<script src="../resources/report.js"></script>
<title>Insert title here</title>
</head>
<body>
	<header> <img src="../images/Logo.png"
		style="margin: 10px 100px 10px 10px;"> <font size="6">Event
		Manager Report Generation Interface</font> </header>


	<br>
	<br>

	<form>
		<table id="tablepaging" class="yui" align="center">
			<tr>
				<th>Delete</th>
				<th>Update</th>
				<c:forEach var="columnName" items="${columnNames}">
					<th>${columnName}</th>
				</c:forEach>
			</tr>
			<%
				int i = 0;
				int length = (Integer) session.getAttribute("length");
			%>

			<c:forEach var="columnValue" items="${columnValues}">

				<%
					if ((i % length) == 0) {
				%>
				<tr class="tr">
				<td><a
					href="/MainEventManager/generateReportController/deleteEntry?empid=${columnValue}&file=<%=session.getAttribute("file")%>">Delete</a></td>
				<td><a
					href="/MainEventManager/generateReportController/getEntry?empid=${columnValue}&file=<%=session.getAttribute("file")%>">Update</a></td>
				<%
					}
				%>

				<td class="each"><c:out value="${columnValue}"/></td>
				<%
					i++;
				%>
				<%
					if ((i % length) == 0) {
				%>
				</tr>
				<%
					}
				%>
			</c:forEach>


		</table>
		<div id="pageNavPosition" style="padding-top: 20px" align="center">
			</div>
		<br> <br>
		<center>
			<input type="text" id="toSearch" /><br>
			<br> <input type="button" class="button" onClick="sample()"
				value="Search" /> <br> <br> <a
				href="/MainEventManager/generateReportController/pdfGeneration?file=<%=session.getAttribute("file")%>"><img
				src="../images/pdf.png" alt="Pdf Download" width="50px"
				height="50px"></a> <a
				href="/MainEventManager/generateReportController/excelGeneration?file=<%=session.getAttribute("file")%>"><img
				src="../images/excel.png" alt="Pdf Download" width="50px"
				height="50px"></a> 
				
				<br>Download <br>

			<input type="hidden" name="eventName" id="hidden"
					value="<%=session.getAttribute("length")%>">
			<script type="text/javascript">
			<!--
				var pager = new Pager('tablepaging', 5);
				pager.init();
				pager.showPageNav('pager', 'pageNavPosition');
				pager.showPage(1);
			</script>
		</center>
	</form>
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