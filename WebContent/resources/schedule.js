$(document).ready(function() {
	$("#schedular").hide();

	$("#schedulelater").click(function(event) {
		$("#schedular").fadeIn();
	});
});

$(function() {
	$("#tabs").tabs();
	var day = 0, expression = 0, hour, minute;
	var divVal = 0, val = 0;
	var monthNumber = 0, monthDate = 0, date = 0;

	$('.hello')
			.click(
					function() {

						divVal = $(this).attr("id");

						if (divVal == 0) {

							$('.radio')
									.click(
											function() {
												var val = this.value;

												if (val == 0) {
													document
															.getElementById('week').disabled = false;
													$('input.week')
															.keyup(
																	function() {

																		day = $(
																				'#week')
																				.val();
																		expression = day;
																		document
																				.getElementById("divValues").value = expression;
																	}).keyup();
												} else {
													document
															.getElementById("divValues").value = '';
													day = '';
													hour = '';
													minute = '';
												}
												function displayDaily() {
													hour = $('#hour').val();
													minute = $('#minute').val();
													if (day != '') {
														expression = "0 "
																+ minute + " "
																+ hour + " 1/"
																+ day
																+ " * ? *";

													}
													/*
													 * expression = "0 " +
													 * atMinuteInTheDay + " " +
													 * atHourInTheDay + " 1/" +
													 * days + " * ? *";
													 */
													// 0 30 11 1/1 * ? *
													else {
														expression = "0 "
																+ minute
																+ " "
																+ hour
																+ " ? * MON-SAT *";
														/*
														 * expression = "0 " +
														 * atMinuteInTheDay + " " +
														 * atHourInTheDay + " ? *
														 * MON-SAT *";
														 */

													}
													document
															.getElementById("divValues").value = expression;

												}
												$(".time").change(displayDaily);
											});
						} else if (divVal == 1) {

							function displayWeekly() {
								var exactDay = $('#weekly').val();
								var exactHour = $('#weeklyHours').val();
								var exactMinute = $('#weeklyMinutes').val();
								// expression=exactMinute+" "+exactHour+"
								// "+exactDay;
								var expression1 = "0 " + exactMinute + " "
										+ exactHour + " ? * " + exactDay + " *";
								document.getElementById("divValues1").value = expression1;

							}
							$('.weekly').change(displayWeekly);
						} else if (divVal == 2) {
							var expression2 = 0;
							$('.secondRadio')
									.click(
											function() {
												var val = this.value;

												if (val == "on") {
													document
															.getElementById('monthly').disabled = false;
													document
															.getElementById('exactMonth').disabled = false;
													$('input.monthlySchedule')
															.keyup(
																	function() {

																		monthNumber = $(
																				'#monthly')
																				.val();
																		monthDate = $(
																				'#exactMonth')
																				.val();
																		expression2 = monthDate
																				+ " "
																				+ monthNumber;
																		document
																				.getElementById("divValues2").value = expression2;
																	}).keyup();
													function displayMonthly() {
														hourOfDay = $(
																'#hourOfDay')
																.val();
														minuteOfDay = $(
																'#minuteOfDay')
																.val();
														// expression=minuteOfDay+"
														// "+hourOfDay+"
														// "+monthDate+"
														// "+monthNumber;
														// 0 0 12 1 1/1 ? * 0 3
														// 16 30 1/1 ? *
														expression2 = "0 "
																+ minuteOfDay
																+ " "
																+ hourOfDay
																+ " "
																+ monthNumber
																+ " 1/"
																+ monthDate
																+ " ? *";

														document
																.getElementById("divValues2").value = expression2;

													}
													$(".monthlyTime").change(
															displayMonthly);

												}
											});
						} else if (divVal == 3) {
							var expression3 = 0;
							function displayMonthly1() {
								date = $('.calender').val();

								expression3 = date;
								document.getElementById("divValues3").value = expression3;
							}
							$("input.calender").change(displayMonthly1);
							function displayMonthly() {
								var hourOfExactDay = $('#hourOfExactDay').val();
								var minuteOfExactDay = $('#minuteOfExactDay')
										.val();
								expression3 = minuteOfExactDay + " "
										+ hourOfExactDay + " " + date;

								var completeDate = date.split("-");
								var year = completeDate[0];
								var mon = completeDate[1];
								var todayDate = completeDate[2];
								/*
								 * alert(arr[0]); 0 0 12 1 1 ? * 0 13 16 1 7 ? *
								 */
								expression3 = "0 " + minuteOfExactDay + " "
										+ hourOfExactDay + " " + todayDate
										+ " " + mon + " ?  * ";

								document.getElementById("divValues3").value = expression3;

							}
							$(".exactMinutes").change(displayMonthly);

						}
						;

					});
});