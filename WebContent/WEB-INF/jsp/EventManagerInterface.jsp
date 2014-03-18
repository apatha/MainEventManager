<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.6.1.min.js"></script>
<script type="text/javascript"
	src="http://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>

<script type="text/javascript" src="../resources/easing.js"></script>
<script type="text/javascript" src="../resources/alertboxjquery.js"></script>

<link rel="stylesheet" type="text/css" media="all" href="../resources/alertbox.css"/>


<link rel="stylesheet" type="text/css" href="../resources/style.css">
<script src="../resources/event.js"></script>
<title>Main Interface</title>
</head>
<body>
	<header>
	<img src="../images/Logo.png" style="margin: 10px 200px 10px 10px;">
	<font size="6">Event Manager Interface</font>
	</header>

	<table id="Main">
		<tr>
			<td width="10%" height="100%" class="side"></td>

			<td width="80%" height="100%">

				<div id="myDiv" class="left">
					<form id="jspForm" method="post"
						action="/MainEventManager/controller2/afterSubmit"
						onsubmit="checkForm()">
						<table>
							<tr>
								<td class="td" style="text-align:center;"><label for="eventName">
										Event Name: </label><input type="text" class="textbox"
									name="eventName" id="eventName" /></td>
							</tr>
							<tr>
								<td class="drop"></td>
								
							</tr>
							<tr>
								<td class="drop"></td>
								
							</tr>
							<tr>
								<td class="drop"></td>
								
							</tr>
							<tr>
								<td class="drop"></td>
								
							</tr>
							<tr>
								<td class="drop"></td>
								

							</tr>
							<tr>
								<td class="drop"></td>
								

							</tr>
							<tr>
								<td class="drop"></td>
								
							</tr>
							<tr>
								<td class="drop"></td>
								
							</tr>
							<tr>
								<td class="drop"></td>
								

							</tr>
							<tr>
								<td class="drop"></td>
								

							</tr>
							<tr>
								<td class="drop"></td>
							

							</tr>
							<tr>
								<td class="drop"></td>
								
							</tr>
							<tr>
								<td class="drop"></td>
								
							</tr>
							<tr>
								<td class="drop"></td>
								
							</tr>
							<tr>
								<td class="drop"></td>
								
							</tr>
							<tr>
								<td colspan=4 class="td" style="text-align:center;"><input type="submit"
									value="Submit" class="button" id="button"></td>
							</tr>
							<tr>
								<td><input type="text" id="hiddenText"
									class="hiddenText" name="data" />
									<input type="text" name="hidden6" class="hiddenText"
									id="lCount" /> <input type="text" name="hidden7"
									class="hiddenText" id="rTCount" /></td>
							</tr>
						</table>
					</form>
				</div>
			</td>
			<td width="10%" height="100%" class="side">
				<div class="right">
					<h4>Drag Drop Items</h4>
					<table>
						<tr>
							<td><div id="Radio" class="drag">Radio</div></td>
						</tr>
						<tr>
							<td><div id="Text" class="drag">Text Box</div></td>
						</tr>
						<tr>
							<td><div id="Check" class="drag">Check Box</div></td>
						</tr>
						<tr>
							<td><div id="Date" class="drag">Date</div></td>
						</tr>
						<tr>
							<td><div id="Drop" class="drag">Drop Down List</div></td>
						</tr>
						<tr>
							<td><div id="Description" class="drag">Label</div></td>
						</tr>
					</table>
				</div>
			</td>
		</tr>
	</table>
	<footer>
		<p>Help?</p>
	</footer>
</body>
</html>