package com.nisum.eventmanager.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nisum.eventmanager.dao.RetreivingEvents;
import com.nisum.eventmanager.file.ListFiles;
import com.nisum.eventmanager.file.ModelFile;
import com.nisum.eventmanager.mail.MailSenders;
import com.nisum.eventmanager.model.SchedulingModel;
import com.nisum.eventmanager.schedular.CreateSchudule;


@Controller
@RequestMapping("/schedulingEvents")
public class EventManagerControllerScheduling {

	final Logger LOGGER = Logger.getLogger(
		    Thread.currentThread().getStackTrace()[0].getClassName() );
	/*@Autowired
	SchedulesFromDb db;*/
	@Autowired
	SchedulingModel schedulingModel;
	/*public SchedulesFromDb getDb() {
		return db;
	}

	public void setDb(SchedulesFromDb db) {
		this.db = db;
	}*/
	@Autowired
	RetreivingEvents retreivingEvents;
	public RetreivingEvents getRetreivingEvents() {
		return retreivingEvents;
	}

	public void setRetreivingEvents(RetreivingEvents retreivingEvents) {
		this.retreivingEvents = retreivingEvents;
	}
	@Autowired
	CreateSchudule createSchudule;// Reference for The class
									// com.nisum.schudule.schuduling.CreateSchudule
	@Autowired
	MailSenders mailSenders;// Reference for The class
							// com.nisum.schudule.mail.MailSenders

	public MailSenders getMailSenders() {
		return mailSenders;
	}

	public void setMailSenders(MailSenders mailSenders) {
		this.mailSenders = mailSenders;
	}

	public CreateSchudule getCreateSchudule() {
		return createSchudule;
	}

	public void setCreateSchudule(CreateSchudule createSchudule) {
		this.createSchudule = createSchudule;
	}
	

	public SchedulingModel getModel() {
		return schedulingModel;
	}
	public void setModel(SchedulingModel schedulingModel) {
		this.schedulingModel = schedulingModel;
	}


	
	@RequestMapping("/index")
	public ModelAndView indexMethod(ModelMap map) throws SQLException
	{
		
		
		LOGGER.info("from Controller.....");
		List arrayList=new ArrayList<SchedulingModel>();
		try {
			
			arrayList=retreivingEvents.retrive();
			map.addAttribute("arrayList",arrayList);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//ArrayList arrayList2=db.exExpressions();
		return new ModelAndView("EmailForm","model",new SchedulingModel());
	}	

@RequestMapping(value="/welcome" ,method=RequestMethod.POST)
	public ModelAndView recevingValues(@ModelAttribute(value="emailForm") SchedulingModel schedulingModel,HttpServletRequest request) throws IOException, SQLException
	{
	//	retreivingEvents.retrivingAll();
		
		String eventName=schedulingModel.getEventName();
		LOGGER.info(eventName);
		String to=schedulingModel.getToMail();
		StringTokenizer stringTokenizer = new StringTokenizer(to, ",");
		int n = stringTokenizer.countTokens();
		String[] toMail = new String[n];
		int i=0;
		while (stringTokenizer.hasMoreElements())// If we wants to send Multiple
													// ones.....
		{
			toMail[i] = stringTokenizer.nextToken();
			i++;
		}
		
		//String events=model.getEventName();
		StringTokenizer stringTokenizer2=new StringTokenizer(eventName,",");
		int m=stringTokenizer2.countTokens();
		String[] toEvents = new String[m];
		int j=0;
		while (stringTokenizer2.hasMoreElements())// If we wants to send Multiple
													// ones.....
		{
			toEvents[j] = stringTokenizer2.nextToken();
			j++;
		}
		
		


	
		mailSenders.createMethod(toMail, schedulingModel.getSubject(),schedulingModel.getBody(),schedulingModel.getEventName());
		if(schedulingModel.getDailyExpression()!="")
		{
			
			LOGGER.info("The Event Name is:"+toEvents);
			LOGGER.info("The Daily Expression is:"+schedulingModel.getDailyExpression());
			//mailSenders.createMethod(toMail, schedulingModel.getSubject(),schedulingModel.getBody(),schedulingModel.getEventName());
			for (String string : toEvents) {
				System.out.println("The eventName is:"+string);
				
				try {
					retreivingEvents.insertExpression(toMail, schedulingModel.getSubject(),schedulingModel.getBody(),schedulingModel.getEventName(),schedulingModel.getDailyExpression());
					//retreivingEvents.insertExpression();
					//getDbClass.getDbMethod();
					createSchudule.mailDeta(schedulingModel.getDailyExpression(),"string11","string11");

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				
			
		}


if(schedulingModel.getWeeklyExpreesion()!="")
		{
			
			LOGGER.info("The Weekly Expreesion is:"+schedulingModel.getWeeklyExpreesion());
			LOGGER.info("The Event Name is:"+toEvents);
			//mailSenders.createMethod(toMail, schedulingModel.getSubject(),schedulingModel.getBody(),schedulingModel.getEventName());
			for (String string : toEvents) {
				System.out.println("The eventName is:"+string);
				
				try {
					

					retreivingEvents.insertExpression(toMail, schedulingModel.getSubject(),schedulingModel.getBody(),schedulingModel.getEventName(),schedulingModel.getWeeklyExpreesion());
					//retreivingEvents.insertExpression(schedulingModel.getWeeklyExpreesion(),string);
					createSchudule.mailDeta(schedulingModel.getWeeklyExpreesion(),"string","string");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}			
			
		}


		if(schedulingModel.getMonthlyExpreesion()!="")
		{
			LOGGER.info("The Monthly Expression is:"+schedulingModel.getMonthlyExpreesion());
			LOGGER.info("The Event Name is:"+toEvents);
			//mailSenders.createMethod(toMail, schedulingModel.getSubject(),schedulingModel.getBody(),schedulingModel.getEventName());
			for (String string : toEvents) {
				System.out.println("The eventName is:"+string);
				
				try {
					retreivingEvents.insertExpression(toMail, schedulingModel.getSubject(),schedulingModel.getBody(),schedulingModel.getEventName(),schedulingModel.getMonthlyExpreesion());
					createSchudule.mailDeta(schedulingModel.getMonthlyExpreesion(),"string1","string1");
					//retreivingEvents.insertExpression(schedulingModel.getMonthlyExpreesion(),string);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
		}
		
		if(schedulingModel.getYearlyExpreesion()!="")
		{
			LOGGER.info("The Yearly Expression is:"+schedulingModel.getYearlyExpreesion());
			LOGGER.info("The Event Name is:"+toEvents);
			//mailSenders.createMethod(toMail, schedulingModel.getSubject(),schedulingModel.getBody(),schedulingModel.getEventName());
			for (String string : toEvents) {
				System.out.println("The eventName is:"+string);
				
				try {
					retreivingEvents.insertExpression(toMail, schedulingModel.getSubject(),schedulingModel.getBody(),schedulingModel.getEventName(),schedulingModel.getYearlyExpreesion());
					createSchudule.mailDeta(schedulingModel.getYearlyExpreesion(),"string22","string22");					
					//retreivingEvents.insertExpression(schedulingModel.getWeeklyExpreesion(),string);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
		
		}

		if((schedulingModel.getDailyExpression()=="") && (schedulingModel.getWeeklyExpreesion()=="") && (schedulingModel.getMonthlyExpreesion()=="") && (schedulingModel.getYearlyExpreesion()==""))
		{
			LOGGER.info("You Scheduled the event now......");
			mailSenders.sendMail(toMail, schedulingModel.getSubject(), schedulingModel.getBody(),schedulingModel.getEventName());
		}
		
		String path = null;
		
		ListFiles ob = new ListFiles();
		 path=request.getServletContext().getRealPath("/WEB-INF/jsp/Events/")+"\\";
		String files[] = ob.getFiles(path);

		ModelAndView mv = new ModelAndView("HomePage", "myModel", new ModelFile());
		Map<String, String> sfile = new LinkedHashMap<String, String>();
	
		for (int i1 = 1; i1 < files.length; i1++) {
			sfile.put(files[i1], files[i1]);
		}
		mv.addObject("files", sfile);
		return mv;
		
	}
}
