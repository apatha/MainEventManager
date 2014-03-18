package com.nisum.eventmanager.testcase;


import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.nisum.eventmanager.controllers.EventManagerControllerScheduling;
import com.nisum.eventmanager.mail.MailSenders;
import com.nisum.eventmanager.model.SchedulingModel;
import com.nisum.eventmanager.schedular.CreateSchudule;

public class ScheduleTest {
EventManagerControllerScheduling controller;
SchedulingModel schedulingModel;
String eventName;
String toMail;
String subject;
String body;
String weeklyExpression;

	@Before
	public void setUp()
	{
		controller=new EventManagerControllerScheduling();
		schedulingModel=new SchedulingModel();
		CreateSchudule createSchudule=Mockito.mock(CreateSchudule.class);
		MailSenders mailSenders=Mockito.mock(MailSenders.class);
		controller.setCreateSchudule(createSchudule);
		controller.setMailSenders(mailSenders);
		eventName="cricket";
		toMail="spamulapati@nisum.com";
		subject="hello";
		body="hai";
		weeklyExpression="";
		schedulingModel.setBody(body);
		schedulingModel.setEventName(eventName);
		schedulingModel.setWeeklyExpreesion(weeklyExpression);
		schedulingModel.setToMail(toMail);
		
	}
	@Test
   public void testSchedule() throws IOException, SQLException
   {
	//controller.recevingValues(model);
	assertEquals("success",controller.recevingValues(schedulingModel, null).getViewName());
   }
}
