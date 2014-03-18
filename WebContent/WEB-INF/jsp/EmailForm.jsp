<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Schedule Events</title>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<script src="../resources/schedule.js"></script>
<link rel="stylesheet" type="text/css" href="../resources/all.css">

<style>
#tabs {
	background: -webkit-gradient(linear, center top, center bottom, from(#fff),
		to(#fff));
	background-image: linear-gradient(#fff, #CAE6E6);
	box-shadow: inset 0px 0px 1px 1px rgba(0, 0, 0, 1);
	font-size: 15px;
	text-shadow: 1px 0px 1Px #663300;
	text-align:left;
}

.hello {
	font-size: 15px;
	text-shadow: 1px 0px 1Px #663300;
	background-image: linear-gradient(#CAE6E6, #fff);
}


.textbox, .time, .weekly, .monthlyTime, .exactMinutes, .calender {
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

.textbox:hover, .time:hover, .weekly:hover, .monthlyTime:hover, .exactMinutes:hover, .calender:hover {
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

</style>
</head>
<body>
	<header> <img src="../images/Logo.png"
		style="margin: 10px 100px 10px 10px;"> <font size="6">Event
		Manager Scheduling Interface</font> </header>
	<center>
		<form:form id="main"
			action="/MainEventManager/schedulingEvents/welcome" method="post"
			modelAttribute="model">

			<div class="inner1">
				<table>
					<tr>
						<td>
							<div class="input">
								Event Name:
								<form:select path="eventName" name="${eventName}"
									class="textbox" id="fromDb">
									<form:options items="${arrayList}" itemName="${eventName}" />
								</form:select>
							</div>
						</td>
					</tr>
					<tr>
						<td>To: <form:input path="toMail"
								placeholder="name@example.com" required="multiple" size="18" />
						</td>
					</tr>
					<tr>
						<td>Subject: <form:input path="subject"
								placeholder="subject" size="12" required="required" />
						</td>
					</tr>
					<tr>
						<td><form:textarea class="textbox" path="body" rows="20"
								placeholder="    body" cols="30" /></td>
					</tr>

					<tr>

						<td><form:hidden path="dailyExpression" id="divValues" /> <form:hidden
								path="weeklyExpreesion" id="divValues1" /> <form:hidden
								path="monthlyExpreesion" id="divValues2" /> <form:hidden
								path="yearlyExpreesion" id="divValues3" /> <input type="button"
							id="schedulelater" class="button" name="schedulelater"
							value="Schedule Later" /> <input type="submit" value="Submit"
							name="submit" class="button"> <input type="reset"
							name="reset" class="button" value="Reset"></td>
					</tr>
				</table>
				<div id="schedular">
					<div id="tabs">

						<ul>
							<li><a class="hello" id="4" href="#tabs-2">>></a></li>
							<li><a class="hello" id="0" href="#tabs-3">Daily</a></li>
							<li><a class="hello" id="1" href="#tabs-4">Weekly</a></li>
							<li><a class="hello" id="2" href="#tabs-5">Monthly</a></li>
							<li><a class="hello" id="3" href="#tabs-6">Exact</a></li>
						</ul>
						<div id="tabs-3" class="tabs">
							<p>
								<input type="radio" name="daily" class="radio" id="specific"
									value="0">Every <input type="text" class="week"
									id="week" name="days" value="" disabled="disabled" size=10/> day(s)
							</p>
							<p>
								<input type="radio" name="daily" class="radio" id="everyday"
									value="1">Every week day
							</p>
							<p>
								Hour <select name="atHourInTheDay" class="time" id="hour">
									<option value="" selected="selected"></option>
									<option value="0">0</option>
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
									<option value="6">6</option>
									<option value="7">7</option>
									<option value="8">8</option>
									<option value="9">9</option>
									<option value="10">10</option>
									<option value="11">11</option>
									<option value="12">12</option>
									<option value="13">13</option>
									<option value="14">14</option>
									<option value="15">15</option>
									<option value="16">16</option>
									<option value="17">17</option>
									<option value="18">18</option>
									<option value="19">19</option>
									<option value="20">20</option>
									<option value="21">21</option>
									<option value="22">22</option>
									<option value="23">23</option>
								</select> Minutes <select name="minutes" class="time" id="minute">
									<option value="" selected="selected"></option>
									<option value="0">0</option>
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
									<option value="6">6</option>
									<option value="7">7</option>
									<option value="8">8</option>
									<option value="9">9</option>
									<option value="10">10</option>
									<option value="11">11</option>
									<option value="12">12</option>
									<option value="13">13</option>
									<option value="14">14</option>
									<option value="15">15</option>
									<option value="16">16</option>
									<option value="17">17</option>
									<option value="18">18</option>
									<option value="19">19</option>
									<option value="20">20</option>
									<option value="21">21</option>
									<option value="22">22</option>
									<option value="23">23</option>
									<option value="24">24</option>
									<option value="25">25</option>
									<option value="26">26</option>
									<option value="27">27</option>
									<option value="28">28</option>
									<option value="29">29</option>
									<option value="30">30</option>
									<option value="31">31</option>
									<option value="32">32</option>
									<option value="33">33</option>
									<option value="34">34</option>
									<option value="35">35</option>
									<option value="36">36</option>
									<option value="37">37</option>
									<option value="38">38</option>
									<option value="39">39</option>
									<option value="40">40</option>
									<option value="41">41</option>
									<option value="42">42</option>
									<option value="43">43</option>
									<option value="44">44</option>
									<option value="45">45</option>
									<option value="46">46</option>
									<option value="47">47</option>
									<option value="48">48</option>
									<option value="49">49</option>
									<option value="50">50</option>
									<option value="51">51</option>
									<option value="52">52</option>
									<option value="53">53</option>
									<option value="54">54</option>
									<option value="55">55</option>
									<option value="56">56</option>
									<option value="57">57</option>
									<option value="58">58</option>
									<option value="59">59</option>
								</select>
						</div>
						<div id="tabs-4" class="tabs">
							<p>
								Weekly<select name="weekName" class="weekly" id="weekly">
									<option value="" selected="selected"></option>
									<option value="MON">monday</option>
									<option value="TUE">tuesday</option>
									<option value="WED">wednesday</option>
									<option value="THU">thursday</option>
									<option value="FRI">friday</option>
									<option value="SAT">saturday</option>
									<option value="SUN">sunday</option>
								</select>
							</p>
							<p>
								Hour <select name="weeklyHours" class="weekly" id="weeklyHours">
									<option value="" selected="selected"></option>
									<option value="0">0</option>
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
									<option value="6">6</option>
									<option value="7">7</option>
									<option value="8">8</option>
									<option value="9">9</option>
									<option value="10">10</option>
									<option value="11">11</option>
									<option value="12">12</option>
									<option value="13">13</option>
									<option value="14">14</option>
									<option value="15">15</option>
									<option value="16">16</option>
									<option value="17">17</option>
									<option value="18">18</option>
									<option value="19">19</option>
									<option value="20">20</option>
									<option value="21">21</option>
									<option value="22">22</option>
									<option value="23">23</option>
								</select> Minutes <select name="weeklyMinutes" class="weekly"
									id="weeklyMinutes">
									<option value="" selected="selected"></option>
									<option value="0">0</option>
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
									<option value="6">6</option>
									<option value="7">7</option>
									<option value="8">8</option>
									<option value="9">9</option>
									<option value="10">10</option>
									<option value="11">11</option>
									<option value="12">12</option>
									<option value="13">13</option>
									<option value="14">14</option>
									<option value="15">15</option>
									<option value="16">16</option>
									<option value="17">17</option>
									<option value="18">18</option>
									<option value="19">19</option>
									<option value="20">20</option>
									<option value="21">21</option>
									<option value="22">22</option>
									<option value="23">23</option>
									<option value="24">24</option>
									<option value="25">25</option>
									<option value="26">26</option>
									<option value="27">27</option>
									<option value="28">28</option>
									<option value="29">29</option>
									<option value="30">30</option>
									<option value="31">31</option>
									<option value="32">32</option>
									<option value="33">33</option>
									<option value="34">34</option>
									<option value="35">35</option>
									<option value="36">36</option>
									<option value="37">37</option>
									<option value="38">38</option>
									<option value="39">39</option>
									<option value="40">40</option>
									<option value="41">41</option>
									<option value="42">42</option>
									<option value="43">43</option>
									<option value="44">44</option>
									<option value="45">45</option>
									<option value="46">46</option>
									<option value="47">47</option>
									<option value="48">48</option>
									<option value="49">49</option>
									<option value="50">50</option>
									<option value="51">51</option>
									<option value="52">52</option>
									<option value="53">53</option>
									<option value="54">54</option>
									<option value="55">55</option>
									<option value="56">56</option>
									<option value="57">57</option>
									<option value="58">58</option>
									<option value="59">59</option>
									<!-- <option value="" selected="selected">null</option> -->
								</select>
							</p>
						</div>
						<div id="tabs-5" class="tabs">
							<p>
								<input type="radio" class="secondRadio" name="monthly">
								Day <input type="text" name="exactDay" class="monthlySchedule"
									value="" id="monthly" size=10 disabled="disabled"
									pattern="^(3[01]|[12][0-9]|0?[1-9])$" /> of every <input
									type="text" size=10 name="exactMonth" class="monthlySchedule"
									disabled="disabled" id="exactMonth" value=""
									pattern="^(1[0-2]|0?[1-9])$" /> month(s)
							</p>
							<p>
								Hour <select name="hourOfDay" class="monthlyTime" id="hourOfDay">
									<option value="" selected="selected"></option>
									<option value="0">0</option>
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
									<option value="6">6</option>
									<option value="7">7</option>
									<option value="8">8</option>
									<option value="9">9</option>
									<option value="10">10</option>
									<option value="11">11</option>
									<option value="12">12</option>
									<option value="13">13</option>
									<option value="14">14</option>
									<option value="15">15</option>
									<option value="16">16</option>
									<option value="17">17</option>
									<option value="18">18</option>
									<option value="19">19</option>
									<option value="20">20</option>
									<option value="21">21</option>
									<option value="22">22</option>
									<option value="23">23</option>
								</select> Minutes <select name="minuteOfDay" class="monthlyTime"
									id="minuteOfDay">
									<option value="" selected="selected"></option>
									<option value="0">0</option>
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
									<option value="6">6</option>
									<option value="7">7</option>
									<option value="8">8</option>
									<option value="9">9</option>
									<option value="10">10</option>
									<option value="11">11</option>
									<option value="12">12</option>
									<option value="13">13</option>
									<option value="14">14</option>
									<option value="15">15</option>
									<option value="16">16</option>
									<option value="17">17</option>
									<option value="18">18</option>
									<option value="19">19</option>
									<option value="20">20</option>
									<option value="21">21</option>
									<option value="22">22</option>
									<option value="23">23</option>
									<option value="24">24</option>
									<option value="25">25</option>
									<option value="26">26</option>
									<option value="27">27</option>
									<option value="28">28</option>
									<option value="29">29</option>
									<option value="30">30</option>
									<option value="31">31</option>
									<option value="32">32</option>
									<option value="33">33</option>
									<option value="34">34</option>
									<option value="35">35</option>
									<option value="36">36</option>
									<option value="37">37</option>
									<option value="38">38</option>
									<option value="39">39</option>
									<option value="40">40</option>
									<option value="41">41</option>
									<option value="42">42</option>
									<option value="43">43</option>
									<option value="44">44</option>
									<option value="45">45</option>
									<option value="46">46</option>
									<option value="47">47</option>
									<option value="48">48</option>
									<option value="49">49</option>
									<option value="50">50</option>
									<option value="51">51</option>
									<option value="52">52</option>
									<option value="53">53</option>
									<option value="54">54</option>
									<option value="55">55</option>
									<option value="56">56</option>
									<option value="57">57</option>
									<option value="58">58</option>
									<option value="59">59</option>
								</select>
							</p>
						</div>


						<div id="tabs-6" class="tabs">
							<p>
								<input type="date" name="calender" class="calender" />
							</p>
							<p>
								Hour <select name="hourOfExactDay" class="exactMinutes"
									id="hourOfExactDay">
									<option value="" selected="selected"></option>
									<option value="0">0</option>
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
									<option value="6">6</option>
									<option value="7">7</option>
									<option value="8">8</option>
									<option value="9">9</option>
									<option value="10">10</option>
									<option value="11">11</option>
									<option value="12">12</option>
									<option value="13">13</option>
									<option value="14">14</option>
									<option value="15">15</option>
									<option value="16">16</option>
									<option value="17">17</option>
									<option value="18">18</option>
									<option value="19">19</option>
									<option value="20">20</option>
									<option value="21">21</option>
									<option value="22">22</option>
									<option value="23">23</option>
								</select> Minutes <select name="minuteOfExactDay" class="exactMinutes"
									id="minuteOfExactDay">
									<option value="" selected="selected"></option>
									<option value="0">0</option>
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
									<option value="6">6</option>
									<option value="7">7</option>
									<option value="8">8</option>
									<option value="9">9</option>
									<option value="10">10</option>
									<option value="11">11</option>
									<option value="12">12</option>
									<option value="13">13</option>
									<option value="14">14</option>
									<option value="15">15</option>
									<option value="16">16</option>
									<option value="17">17</option>
									<option value="18">18</option>
									<option value="19">19</option>
									<option value="20">20</option>
									<option value="21">21</option>
									<option value="22">22</option>
									<option value="23">23</option>
									<option value="24">24</option>
									<option value="25">25</option>
									<option value="26">26</option>
									<option value="27">27</option>
									<option value="28">28</option>
									<option value="29">29</option>
									<option value="30">30</option>
									<option value="31">31</option>
									<option value="32">32</option>
									<option value="33">33</option>
									<option value="34">34</option>
									<option value="35">35</option>
									<option value="36">36</option>
									<option value="37">37</option>
									<option value="38">38</option>
									<option value="39">39</option>
									<option value="40">40</option>
									<option value="41">41</option>
									<option value="42">42</option>
									<option value="43">43</option>
									<option value="44">44</option>
									<option value="45">45</option>
									<option value="46">46</option>
									<option value="47">47</option>
									<option value="48">48</option>
									<option value="49">49</option>
									<option value="50">50</option>
									<option value="51">51</option>
									<option value="52">52</option>
									<option value="53">53</option>
									<option value="54">54</option>
									<option value="55">55</option>
									<option value="56">56</option>
									<option value="57">57</option>
									<option value="58">58</option>
									<option value="59">59</option>
								</select>
							</p>

						</div>
					</div>
				</div>
			</div>
		</form:form>
	</center>
	<footer>
	<p>Help?</p>
	</footer>
</body>
</html>