package com.nisum.eventmanager.model;

public class SchedulingModel {

String eventName;

String toMail;
String subject;
String body;
String dailyExpression;
String weeklyExpreesion;
String monthlyExpreesion;
String yearlyExpreesion;

public String getEventName() {
	return eventName;
}
public void setEventName(String eventName) {
	this.eventName = eventName;
}
public String getToMail() {
	return toMail;
}
public void setToMail(String toMail) {
	this.toMail = toMail;
}
public String getSubject() {
	return subject;
}
public void setSubject(String subject) {
	this.subject = subject;
}
public String getBody() {
	return body;
}
public void setBody(String body) {
	this.body = body;
}
public String getDailyExpression() {
	return dailyExpression;
}
public void setDailyExpression(String dailyExpression) {
	this.dailyExpression = dailyExpression;
}
public String getWeeklyExpreesion() {
	return weeklyExpreesion;
}
public void setWeeklyExpreesion(String weeklyExpreesion) {
	this.weeklyExpreesion = weeklyExpreesion;
}
public String getMonthlyExpreesion() {
	return monthlyExpreesion;
}
public void setMonthlyExpreesion(String monthlyExpreesion) {
	this.monthlyExpreesion = monthlyExpreesion;
}
public String getYearlyExpreesion() {
	return yearlyExpreesion;
}
public void setYearlyExpreesion(String yearlyExpreesion) {
	this.yearlyExpreesion = yearlyExpreesion;
}

}
