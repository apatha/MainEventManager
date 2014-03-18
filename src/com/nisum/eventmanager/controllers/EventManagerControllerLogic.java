package com.nisum.eventmanager.controllers;


import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nisum.eventmanager.dao.AdminLoginDao;
import com.nisum.eventmanager.datacopying.DataCopying;
import com.nisum.eventmanager.datawriting.DataWriting;
import com.nisum.eventmanager.dynamiccompilation.DynamicCompilation;
import com.nisum.eventmanager.file.ListFiles;
import com.nisum.eventmanager.file.ModelFile;
import com.nisum.eventmanager.foldercreation.EventStructure;
import com.nisum.eventmanager.interfaces.DynamicTableCreationInterface;
import com.nisum.eventmanager.jsp.CreatingUpdateJsp;
import com.nisum.eventmanager.model.ExistingEventModel;


@Controller
@RequestMapping("/controller2")
public class EventManagerControllerLogic  {

	
	EventStructure eventStructure;
	

	DataCopying dataCopying;
	DataWriting dataWritting;
	DynamicCompilation dynamicCompilation;
	
	@Autowired
	DynamicTableCreationInterface dynamicTableCreationInterface;
	
	
	/**
	 * @param eventStructure the eventStructure to set
	 */
	@Autowired
	public  void setEventStructure(EventStructure eventStructure) {
		this.eventStructure = eventStructure;
	}


	/**
	 * @param dataCopying the dataCopying to set
	 */
	@Autowired
	public  void setDataCopying(DataCopying dataCopying) {
		this.dataCopying = dataCopying;
	}


	/**
	 * @param dataWritting the dataWritting to set
	 */
	@Autowired
	public  void setDataWritting(DataWriting dataWritting) {
		this.dataWritting = dataWritting;
	}

	 /**
	 * @param dynamicCompilation the dynamicCompilation to set
	 */
	@Autowired
	public final void setDynamicCompilation(DynamicCompilation dynamicCompilation) {
		this.dynamicCompilation = dynamicCompilation;
	}

	
	
	@Autowired
	AdminLoginDao adminLoginDao;
	
	
	/**
	 * @param dynamicTableCreationInterface the dynamicTableCreationInterface to set
	 */
	
	public final void setDynamicTableCreationInterface(
			DynamicTableCreationInterface dynamicTableCreationInterface) {
		this.dynamicTableCreationInterface = dynamicTableCreationInterface;
	}

	
	/*@Autowired 
	MailMail mail;
	
	public MailMail getMail() {
		return mail;
	}


	public void setMail(MailMail mail) {
		this.mail = mail;
	}*/


	
	
	
	
	/*
	 * this method creates the target project structure, dynamic db and 
	 * also takes values from jsp and stores into db
	 **/
	@RequestMapping(value="/afterSubmit", method = RequestMethod.POST)
	public ModelAndView afterSubmit(@RequestParam String data,
			@RequestParam String eventName,
			@RequestParam Map<String, String> allRequestParams,HttpServletRequest request) throws IOException, SQLException{
		
	
		CreatingUpdateJsp ab= new CreatingUpdateJsp();
		String path=request.getServletContext().getRealPath("/WEB-INF/jsp/");
		
		ab.Submit(data, eventName, allRequestParams,path);
		
		 System.out.println("allRequestParams"+allRequestParams);
		// String eventName= allRequestParams.get("eventName");
		 System.out.println(eventName);
		 data= allRequestParams.get("data");
		 Iterator<Entry<String, String>> it = allRequestParams.entrySet().iterator();
		 while (it.hasNext()) {
		    Entry<String, String> entry = it.next(); 
		    if (!(entry.getKey().contains("Label"))) {
		       it.remove(); // avoids a ConcurrentModificationException
		    }
		 
		 }
		 
		 

	 System.out.println(allRequestParams);
	 
	 System.out.println(dynamicTableCreationInterface);
	 try{
	boolean check=dynamicTableCreationInterface.checkTable(eventName,allRequestParams);
	 
	 if(check){
		
		 dynamicTableCreationInterface.createTable(eventName,allRequestParams);
		 }
	 }
		 catch (Exception e) {
			 return new ModelAndView("error","ErrorMessage","Enter Proper Details......");
			 
			
		}
		
		
		/*creation of dynamic root folder's Structure */
		eventStructure.eventRootStructure(eventName);
		
		
		/*creation of WebInf Structure inner */
		eventStructure.WebInfStructure(eventName);
		
		/*creation of WebInf  JSP 's Structure (Success,End ) */
		eventStructure.webInfJspStructure(eventName);
		
		/*creation of WebInf  classes Structure (packages and classes) */
		eventStructure.webInfClassesStructure(eventName);
			
		/* copying jars into the target library */ 
		dataCopying.copyingLibraries(eventName,request.getServletContext().getRealPath("/WEB-INF/lib/"));
		
		/* copying End jsp  into the target jsp folder */ 
		dataCopying.copyingEndJsp(eventName,request.getServletContext().getRealPath("/WEB-INF/jsp/EndJspOfTarget.jsp"));
		
		/* copying final jsp  into the target  success jsp folder */ 
		dataCopying.copyingSuccessJsp(eventName,request.getServletContext().getRealPath("/WEB-INF/jsp/Final/"+eventName+".jsp"));
		
		/* writing  into the target welcome jsp  */ 
		dataWritting.writingToWelcomePage(eventName);
		
		/* writing  into the target WEB.XML  */ 
		dataWritting.writingToWebxml(eventName);
		
		/* writing  into the target application context  */ 
		dataWritting.writingToApplicationContext(eventName);
		
		
		/*writing into target main controller*/
		dataWritting.writingToMainController(eventName);
		/*writing into target model */
		dataWritting.writingToModel(eventName);
		
		dataWritting.writingToDao(eventName);
		
/////////
		
		String sender="pathaalok@gmail.com";//write here your id
		String[] receiver={"apatha@nisum.com"};//write here receiver id
	/*	mail.sendMail(sender,receiver,"only checkinf our project ","http://192.168.18.107:2014/"+eventName+"/");*/
		
		///////////////
		

		
		dynamicCompilation.dynamicCompilation(eventName,request.getServletContext().getRealPath("/WEB-INF/lib/"));
		ListFiles ob = new ListFiles();

		path=path+"\\Events\\";
		String files[] = ob.getFiles(path);

		ModelAndView mv = new ModelAndView("HomePage", "myModel", new ModelFile());
		Map<String, String> sfile = new LinkedHashMap<String, String>();

		
		for(int i=0;i<files.length;i++)
		{
			files[i]=files[i].replaceAll(".jsp", "");
			files[i]=files[i].replaceAll(".txt", "");
		}
		ExistingEventModel eem=new ExistingEventModel();
		eem.setEventName(eventName);
		eem.setEventNumber(files.length);
		eem.setExpression("*****");
		adminLoginDao.insertEvents(eem);
		
		
		for (int i = 1; i < files.length; i++) {
			sfile.put(files[i], files[i]);
		}
		mv.addObject("files", sfile);
		return mv;
		
	}


	
	
	
	
}

