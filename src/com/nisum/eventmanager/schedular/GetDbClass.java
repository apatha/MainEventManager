package com.nisum.eventmanager.schedular;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.nisum.eventmanager.dao.RetreivingEvents;


public class GetDbClass {
	
	@Autowired
	RetreivingEvents retreivingEvents;
	@Autowired
	CreateSchudule createSchudule;
	
	public void getDbMethod()
	{
		System.out.println("from Db...");
		 ArrayList<String> aL = new ArrayList<String>();
		 System.out.println("befor try ");
		//List aL=new ArrayList<Model>();
		try {
			 System.out.println("in try ");
			//ModelAndView mv=new ModelAndView();
			 
			retreivingEvents.retriveExpression();
		//	map.addAttribute("arrayList",arrayList);
			/*System.out.println(aL);
			for (String object : aL) {
				System.out.println("Expression from DB"+object);
				createSchudule.mailDeta(object,object,object);
				
			}*/
			//return new ModelAndView("E","list",arrayList);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//return new ModelAndView("EmailForm","model",new Model());
	}

}

