<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Main Interface</title>
<style type="text/css"> /* specifying css */
body {
	margin-top: 1;
	margin-left: 1;
	margin-right: 1;
	margin-bottom: 1;
	border: 1px solid black;
}

header,footer {
	text-align: center;
	border: 1px solid black;
	font-family: Tempus Sans ITC;
	text-shadow: 1px 2px 3px #5C5C3D;
	font-size: 20px;
	position: relative;
	background: -webkit-gradient(linear, center top, center bottom, from(#F0E2F0),
		to(#fff));
	background-image: linear-gradient(#F0E2F0, #fff);
	box-shadow: inset 0px 0px 1px 1px rgba(0, 0, 0, 1);
	color: #222;
}

a {
	text-decoration: none;
}

a:hover {
	text-shadow: 0px 0px 4px #663300;
	font-weight: bold;
}

/* properties for table inside body */
#Main {
	border: 1px solid black;
	font-weight: bold;
	color: #6C1987;
	text-shadow: 0px 0px 1px #663300;
	font-size: 18px;
	box-shadow: inset 0px 0px 1px 1px rgba(0, 0, 0, 1);
	color: #222;
}

.radio {
	border: 2px outset #848484;
}
/* properties for drag elements div */
.right {
	text-align: center;
	color: #194719;
}
/* properties for droppable area */
.left {
	width: 100%;
	height: 100%;
	border: 1px solid black;
}

.left table {
	width: 100%;
}

.left td {
	text-align: left;
	padding: 2px;
	height: 30px;
	background: #E0ECFF;
}

.left td.drop {
	background: white;
	width: 150px;
	text-align: left;
}

.left td.over {
	background: #DDDDD9;
}
/* properties for draggable items */
.drag {
	text-align: center;
	background: #EaEaEa;
	width: 150px;
	border-top: #ccc 3px solid;
	border-right: #ccc 3px solid;
	border-bottom: #777 2px solid;
	border-left: #777 2px solid;
	font-family: Tempus Sans ITC;
	margin-bottom: 5px;
	background: -webkit-gradient(linear, center top, center bottom, from(#ededed),
		to(#fff));
	background-image: linear-gradient(#ededed, #fff);
	border-radius: 12px;
	box-shadow: inset 0px 0px 1px 1px rgba(0, 0, 0, 3);
	color: #222;
}

.drag:hover {
	text-align: center;
	width: 150px;
	text-shadow: 0px 0px 3px #663300;
	font-family: Tempus Sans ITC;
	margin-bottom: 5px;
	border-radius: 12px;
	box-shadow: inset 0px 0px 1px 1px rgba(0, 0, 0, 0);
	color: #222;
}

.assigned {
	border: 1px solid black;
	box-shadow: 0 2px 1px 1px #C2C2FF;
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
		to(#CDCFD2));
	font-family: "Times New Roman", Georgia, Serif;
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
		to(#fff));
	text-shadow: 0px 0px 2px #663300;
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
		to(#fff));
	text-shadow: 0px 0px 1px #663300;
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
		to(#C3D7EB));
	text-shadow: 0px 0px 4px #663300;
}

#remScnt {
	text-decoration: none;
}

.hidden:hover {
	content: url('../images/close1.gif');
}

#hidden {
	visibility: hidden;
}

.hiddenText {
	visibility: hidden;
}

.side {
	background: -webkit-gradient(linear, center top, center bottom, from(#fff),
		to(#CAE6E6));
	box-shadow: inset 0px 0px 1px 1px rgba(0, 0, 0, 0.5);
}

.label {
	border: 0px none;
	border-radius: 30px;
	padding-left: 10px;
	padding-right: 10px;
	font-weight: bold;
	color: #6C1987;
	text-shadow: 0px 0px 1px #663300;
	font-family: "Times New Roman", Times, serif;
	font-size: 18px;
	text-shadow: 1px 0px 1Px #5C5C3D;
	outline: none;
	width:100px;
}

.label:hover {
	outline: none;
	width:100px;
}


.remove, .textbox1, .button1{
	visibility: hidden;
}


p { margin: 0; }
</style>
</head>
<body>
	<header>
	<img src="../images/Logo.png" alt="Nisum" style="margin: 10px 200px 10px 10px;">
	</header>
	Thank you..... for your valuable time
	</body>
</html>