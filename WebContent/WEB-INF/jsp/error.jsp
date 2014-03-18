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

</style>
</head>
<body>
	<header>
	<img src="../images/Logo.png" alt="Nisum" style="margin: 10px 200px 10px 10px;">
	<font size="6">eventNames</font>
	</header>

	
	<h1> Oops!!!!! ${ErrorMessage} </h1>
	
	
	
	<footer>
		<p>Help?</p>
	</footer>
</body>
</html>