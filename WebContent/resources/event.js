$(function() {
	var rTCount = 0;
	var count = 0;

	$('.right .drag').draggable({
		revert : true,
		proxy : 'clone'
	});
	$('.left td.drop')
			.droppable(
					{
						onDragEnter : function() {
							$(this).addClass('over');
						},
						onDragLeave : function() {
							$(this).removeClass('over');
						},
						onDrop : function(e, source) {

							var s = $(source).attr('id');

							if (s == 'Radio') {

								$(this).removeClass('over');
								if ($(source).hasClass('assigned')) {
									$(this)
											.append(source)
											.html(
													"<div id="
															+ (++count)
															+ "><br><label for=\""
															+ s
															+ (count)
															+ "\"><input type=\"text\" name="
															+ "Label"
															+ (count)
															+ " class=\"label\" onkeypress=\"this.style.width = ((this.value.length + 2) * 8) + 'px';\" size=\"3\"/></label>"
															+ "    <input type=\"text\" class=\"textbox1\" size=1 id="
															+ s
															+ (count)
															+ ">   <input type=\"button\" value=\"Add\"  id=\"check\"  class=\"button1\" onClick = \"addRadioOption('"
															+ s
															+ "','"
															+ count
															+ "');\"><a href=\"#\" id=\"remcnt\"> <img src=\"../images/close.gif\" class=\"hidden\" alt=\"Close\" width=\"15\" height=\"15\"></a></div>");
								} else {
									c = $(source).clone().addClass('assigned');
									$(this)
											.empty()
											.append(c)
											.html(
													"<div id="
															+ (++count)
															+ "><br><label for=\""
															+ s
															+ (count)
															+ "\"><input type=\"text\" name="
															+ "Label"
															+ (count)
															+ " class=\"label\" onkeypress=\"this.style.width = ((this.value.length + 2) * 8) + 'px';\" size=\"3\"/></label>"
															+ "    <input type=\"text\" class=\"textbox1\" size=1 id="
															+ s
															+ (count)
															+ ">   <input type=\"button\" value=\"Add\"  id=\"check\"  class=\"button1\" onClick = \"addRadioOption('"
															+ s
															+ "','"
															+ count
															+ "');\"><a href=\"#\" id=\"remcnt\"> <img src=\"../images/close.gif\" class=\"hidden\" alt=\"Close\" width=\"15\" height=\"15\"></a></div>");
									c.draggable({
										revert : true
									});
								}

							}

							if (s == 'Text') {

								$(this).removeClass('over');
								if ($(source).hasClass('assigned')) {
									$(this)
											.append(source)
											.html(
													"<p><label for=\""
															+ s
															+ (++count)
															+ "\"><input type=\"text\" name="
															+ "Label"
															+ (count)
															+ " class=\"label\" onkeypress=\"this.style.width = ((this.value.length + 2) * 8) + 'px';\" size=\"3\"/></label>    <input type=\"text\" name="
															+ s
															+ (count)
															+ "\" id=\""
															+ s
															+ (count)
															+ "\" class=\"textbox\" size=\"10\"/><a href=\"#\" id=\"remScnt\"> <img src=\"../images/close.gif\" class=\"hidden\" alt=\"Close\" width=\"15\" height=\"15\"></a></p>");
								} else {
									c = $(source).clone().addClass('assigned');
									$(this)
											.empty()
											.append(c)
											.html(
													"<p><label for=\""
															+ s
															+ (++count)
															+ "\"><input type=\"text\" name="
															+ "Label"
															+ (count)
															+ " class=\"label\" onkeypress=\"this.style.width = ((this.value.length + 2) * 8) + 'px';\" size=\"3\"/></label>    <input type=\"text\" name="
															+ s
															+ (count)
															+ "\" id=\""
															+ s
															+ (count)
															+ "\" class=\"textbox\" size=\"10\"/><a href=\"#\" id=\"remScnt\"> <img src=\"../images/close.gif\" class=\"hidden\" alt=\"Close\" width=\"15\" height=\"15\"></a></p>");
									c.draggable({
										revert : true
									});
								}

							}

							if (s == 'Check') {

								$(this).removeClass('over');
								if ($(source).hasClass('assigned')) {
									$(this)
											.append(source)
											.html(
													"<div id="
															+ (++count)
															+ "><br><label for=\""
															+ s
															+ (count)
															+ "\"><input type=\"text\" name="
															+ "Label"
															+ (count)
															+ " class=\"label\" onkeypress=\"this.style.width = ((this.value.length + 2) * 8) + 'px';\" size=\"3\"/></label>    <input type=\"text\" class=\"textbox1\" size=1 id="
															+ s
															+ (count)
															+ ">   <input type=\"button\" value=\"Add\"  id=\"check\"  class=\"button1\" onClick = \"addCheckOption('"
															+ s
															+ "','"
															+ count
															+ "');\"> <a href=\"#\" id=\"remcnt\"> <img src=\"../images/close.gif\" class=\"hidden\" alt=\"Close\" width=\"15\" height=\"15\"></a></div>  ");
								} else {
									c = $(source).clone().addClass('assigned');
									$(this)
											.empty()
											.append(c)
											.html(
													"<div id="
															+ (++count)
															+ "><br><label for=\""
															+ s
															+ (count)
															+ "\"><input type=\"text\" name="
															+ "Label"
															+ (count)
															+ " class=\"label\" onkeypress=\"this.style.width = ((this.value.length + 2) * 8) + 'px';\" size=\"3\"/></label>    <input type=\"text\" class=\"textbox1\" size=1 id="
															+ s
															+ (count)
															+ ">   <input type=\"button\" value=\"Add\"  id=\"check\"  class=\"button1\" onClick = \"addCheckOption('"
															+ s
															+ "','"
															+ count
															+ "');\"> <a href=\"#\" id=\"remcnt\"> <img src=\"../images/close.gif\" class=\"hidden\" alt=\"Close\" width=\"15\" height=\"15\"></a></div>  ");
									c.draggable({
										revert : true
									});
								}

							}

							if (s == 'Date') {

								$(this).removeClass('over');
								if ($(source).hasClass('assigned')) {
									$(this)
											.append(source)
											.html(
													"<p><label for=\""
															+ s
															+ (++count)
															+ "\"><input type=\"text\" name="
															+ "Label"
															+ (count)
															+ " class=\"label\" onkeypress=\"this.style.width = ((this.value.length + 2) * 8) + 'px';\" size=\"3\"/></label>    <input type=\"date\" class=\"textbox\" id=\""
															+ s
															+ (count)
															+ "\" name="
															+ s
															+ (count)
															+ "'><a href=\"#\" id=\"remScnt\"> <img src=\"../images/close.gif\" class=\"hidden\" alt=\"Close\" width=\"15\" height=\"15\"></a></p>");
								} else {
									c = $(source).clone().addClass('assigned');
									$(this)
											.empty()
											.append(c)
											.html(
													"<p><label for=\""
															+ s
															+ (++count)
															+ "\"><input type=\"text\" name="
															+ "Label"
															+ (count)
															+ " class=\"label\" onkeypress=\"this.style.width = ((this.value.length + 2) * 8) + 'px';\" size=\"3\"/></label>    <input type=\"date\" class=\"textbox\" id=\""
															+ s
															+ (count)
															+ "\" name="
															+ s
															+ (count)
															+ "'><a href=\"#\" id=\"remScnt\"> <img src=\"../images/close.gif\" class=\"hidden\" alt=\"Close\" width=\"15\" height=\"15\"></a></p>");
									c.draggable({
										revert : true
									});
								}

							}

							if (s == 'Drop') {

								$(this).removeClass('over');
								if ($(source).hasClass('assigned')) {
									$(this)
											.append(source)
											.html(
													"<p><label for=\""
															+ s
															+ (++count)
															+ "\"><input type=\"text\" name="
															+ "Label"
															+ (count)
															+ " class=\"label\" onkeypress=\"this.style.width = ((this.value.length + 2) * 8) + 'px';\" size=\"3\"/></label>    <select id="
															+ s
															+ (count)
															+ " class=\"textbox\" name="
															+ s
															+ (count)
															+ "></select><span class=\"remove\">  <input type=\"text\" class=\"textbox\" name="
															+ s
															+ (++count)
															+ " id="
															+ s
															+ (count)
															+ " size=1 />   <input type=\"button\" value=\"Add\" class=\"button\" onclick=\"addCombo('"
															+ s
															+ "','"
															+ count
															+ "')\"/></span><a href=\"#\" id=\"remScnt\"> <img src=\"../images/close.gif\" class=\"hidden\" alt=\"Close\" width=\"15\" height=\"15\"></a></p> ");
								} else {
									c = $(source).clone().addClass('assigned');
									$(this)
											.empty()
											.append(c)
											.html(
													"<p><label for=\""
															+ s
															+ (++count)
															+ "\"><input type=\"text\" name="
															+ "Label"
															+ (count)
															+ " class=\"label\" onkeypress=\"this.style.width = ((this.value.length + 2) * 8) + 'px';\" size=\"3\"/></label>    <select id="
															+ s
															+ (count)
															+ " class=\"textbox\" name="
															+ s
															+ (count)
															+ "></select><span class=\"remove\">  <input type=\"text\" class=\"textbox\" name="
															+ s
															+ (++count)
															+ " id="
															+ s
															+ (count)
															+ " size=1 />   <input type=\"button\" value=\"Add\" class=\"button\" onclick=\"addCombo('"
															+ s
															+ "','"
															+ count
															+ "')\"/></span><a href=\"#\" id=\"remScnt\"> <img src=\"../images/close.gif\" class=\"hidden\" alt=\"Close\" width=\"15\" height=\"15\"></a></p> ");
									c.draggable({
										revert : true
									});
								}

							}

							if (s == 'Description') {

								$(this).removeClass('over');
								if ($(source).hasClass('assigned')) {
									$(this)
											.append(source)
											.html(
													"<p><input type=\"text\" name="
															+ s
															+ " class=\"label\" onkeypress=\"this.style.width = ((this.value.length + 2) * 8) + 'px';\" size=\"3\"/><a href=\"#\" id=\"remScnt\">   <img src=\"../images/close.gif\" class=\"hidden\" alt=\"Close\" width=\"15\" height=\"15\"></a></p>");
								} else {
									c = $(source).clone().addClass('assigned');
									$(this)
											.empty()
											.append(c)
											.html(
													"<p><input type=\"text\" name="
															+ s
															+ " class=\"label\" onkeypress=\"this.style.width = ((this.value.length + 2) * 8) + 'px';\" size=\"3\"/><a href=\"#\" id=\"remScnt\">   <img src=\"../images/close.gif\" class=\"hidden\" alt=\"Close\" width=\"15\" height=\"15\"></a></p>");
									c.draggable({
										revert : true
									});
								}

							}

						}
					});

	/* to remove any dragged item */
	$('#remScnt').live('click', function() {
		$(this).parents('p').remove();
	});

	$('#remcnt').live('click', function() {
		$(this).parent('div').remove();
	});

	$("#jspForm").submit(function checkForm() {
		
		var x=document.getElementById('eventName').value;
		
		if (x==null || x=="")
		  {
			Sexy.alert('<h1>Event Name Cannot Be Empty</h1>');
		  return false;
		  }
		else if (x.indexOf("?") != -1) {
				Sexy.alert('<h1>There cannot be question mark in event Name</h1>');
				return false;
		}
		
		
		var boxes = document.getElementsByClassName("label");

		for(var i = 0; i < boxes.length; i++)

		{
		var textBoxValues=boxes[i].value;
		if(textBoxValues.indexOf("?") != -1){
			Sexy.alert('<h1> Please remove question mark if you have used any where</h1>');
			return false;
		}

		};

		
		document.getElementById('lCount').value = count;
		document.getElementById('rTCount').value = rTCount;
		var sample = $('#myDiv').html();
		document.getElementById('hiddenText').value = sample;
	});

});

//adding option to radio
function addRadioOption(s, count) {
	var label = document.createElement("label");
	var sam = document.getElementById("" + s + (count) + "").value;
	var description = document.createTextNode(sam);
	var radio = document.createElement("input");
	radio.type = "radio";
	radio.name = "" + s + count + "";
	radio.value = sam;
	label.appendChild(radio);
	label.appendChild(description);
	document.getElementById(count).appendChild(label);
	document.getElementById("" + s + (count) + "").value = '';
}

var check=0;
/* adding option to check box */
function addCheckOption(s, count) {
	var label = document.createElement("label");
	var sam = document.getElementById("" + s + (count) + "").value;
	var description = document.createTextNode(sam);
	var checkbox = document.createElement("input");
	checkbox.type = "checkbox";
	checkbox.name = s + count + (++check);
	checkbox.value = sam;
	label.appendChild(checkbox);
	label.appendChild(description);
	document.getElementById(count).appendChild(label);
	document.getElementById("" + s + (count) + "").value = '';
}
/* adding a option to drop down */
function addCombo(s, count) {
	var textb = document.getElementById("" + s + (count) + "");
	var combo = document.getElementById("" + s + (count - 1) + "");
	var option = document.createElement("option");
	option.text = textb.value;
	option.value = textb.value;
	try {
		combo.add(option, null);
	} catch (error) {
		combo.add(option);
	}
	textb.value = "";
}