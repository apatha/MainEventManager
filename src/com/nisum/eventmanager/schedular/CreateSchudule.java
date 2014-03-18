package com.nisum.eventmanager.schedular;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.CronTriggerBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;

import com.nisum.eventmanager.mail.MailSenders;


/**
 * @author Harsha
 * 
 *  This class is  useful for creating the Schedule...
 *  I am calling this class methods from com.nisum.schudule.controller.MainController.......
 *  This  
 */
public class CreateSchudule {

	
	
	private Scheduler scheduler;
	
	
	
	public Scheduler getScheduler() {
		return scheduler;
	}
	public void setScheduler(Scheduler scheduler) {
		this.scheduler = scheduler;
	}
	@Autowired
	private MailSenders mailSenders;
	
	public MailSenders getMailSenders() {
		return mailSenders;
	}
	public void setMailSenders(MailSenders mailSenders) {
		this.mailSenders = mailSenders;
	}
	public void mailDeta(String expression,String methodName,String beanName) {
		// TODO Auto-generated method stub
		try{
		    // create JOB
			
		    MethodInvokingJobDetailFactoryBean jobDetail = new MethodInvokingJobDetailFactoryBean();
		    jobDetail.setTargetObject(mailSenders);
		   	jobDetail.setTargetMethod("performAction");
		    jobDetail.setName(methodName);
		    jobDetail.setConcurrent(false);
		    jobDetail.afterPropertiesSet();

		     // create CRON Trigger
		    	CronTriggerBean cronTrigger = new CronTriggerBean();
		    	cronTrigger.setBeanName(beanName);
			    cronTrigger.setCronExpression(expression);
			    cronTrigger.afterPropertiesSet();
			    scheduler.scheduleJob((JobDetail) jobDetail.getObject(), cronTrigger);
			    scheduler.start();
			    jobDetail=null;
			    System.out.println(jobDetail);
			    } catch (Exception e) {                      
			        e.printStackTrace();
			    } 
	}		    
		    

	}
		


		
	
