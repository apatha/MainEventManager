package com.nisum.eventmanager.custom.context;

import javax.servlet.ServletContextEvent;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.nisum.eventmanager.schedular.BootstrapClass;

public class MyContextLoaderListerner extends ContextLoaderListener {

	private static Log log = LogFactory.getLog(MyContextLoaderListerner.class);

	@Override
	public void contextInitialized(ServletContextEvent event) {
		super.contextInitialized(event);
		log.debug("My web app  Loaded.......");
		BootstrapClass bootstrapClass = (BootstrapClass) WebApplicationContextUtils
				.getRequiredWebApplicationContext(event.getServletContext())
				.getBean("bootstrap");
		
		try {
			bootstrapClass.alertServiceStartup();
			bootstrapClass.dbCall();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		super.contextDestroyed(event);
		log.debug("My web app  Destroyed.......");
	}

}