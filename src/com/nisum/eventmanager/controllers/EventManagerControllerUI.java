package com.nisum.eventmanager.controllers;


import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nisum.eventmanager.dao.AdminLoginDao;
import com.nisum.eventmanager.file.ListFiles;
import com.nisum.eventmanager.file.ModelFile;
import com.nisum.eventmanager.file.ReadFile;
import com.nisum.eventmanager.jsp.CreateFinalJsp;
import com.nisum.eventmanager.model.AdminLoginModel;
import com.nisum.eventmanager.model.ExistingEventModel;
import com.nisum.eventmanager.validation.Validation;



/*
 * this class deals with the login credentials and the home page of the admin 
 * 
 */
@Controller
@RequestMapping("/controller")
public class EventManagerControllerUI {
	
	ReadFile ob ;
	CreateFinalJsp cj=new CreateFinalJsp();
	
	@Autowired
	AdminLoginDao adminLoginDao ;

	
	Validation validation ;
	
	@Autowired
	public void setValidation(Validation validation) {
		this.validation = validation;
	}
	
	/* 
	 * This method sends an object to AdminLogin Jsp which is used for 
	 * binding the values in spring forms
	 */
	@RequestMapping("/adminLogin")
	public ModelAndView adminLogin() {
		return new ModelAndView("AdminLogin", "adminLoginModel", new AdminLoginModel());
	}
	
	
	/* * This method receives the values from login page and checks with
	 *  the db for correct credentials and sends the view to home page 
	 */
	@RequestMapping(value = "/AfterLogin", method = RequestMethod.POST)
	public ModelAndView processForm(
			@ModelAttribute("adminLoginModel") AdminLoginModel adminLoginModel, BindingResult result,HttpServletRequest request) throws SQLException {
		validation.validate(adminLoginModel, result);
		ModelAndView mv = new ModelAndView("AdminLogin");
		if (!result.hasErrors()) {
			boolean check = adminLoginDao.checkUser(adminLoginModel);
			if (check == true) {
				ListFiles ob = new ListFiles();

				String files[] = ob.getFiles(request.getServletContext().getRealPath("/WEB-INF/jsp/Events/"));

				mv.addObject("myModel", new ModelFile());
				Map<String, String> sfile = new LinkedHashMap<String, String>();

				for(int i=0;i<files.length;i++)
				{
					if(files.length==1)
					{
						adminLoginDao.insertEvents(null);
					}
					files[i]=files[i].replaceAll(".jsp", "");
					files[i]=files[i].replaceAll(".txt", "");
					ExistingEventModel eem=new ExistingEventModel();
					eem.setEventName(files[i]);
					eem.setEventNumber(i);
					eem.setExpression("*****");
					adminLoginDao.insertEvents(eem);
				}
				
				for (int i = 1; i < files.length; i++) {
					sfile.put(files[i], files[i]);
				}
				mv.addObject("files", sfile);
				mv.setViewName("HomePage");
				
			} else {
				mv.addObject("invalid", "Invalid Credentials");
			}
		}
		return mv;
	}

	/*used to search the Events which already exists*/
	@RequestMapping(value = "/searchExistingEventFiles")
	public ModelAndView searchFile(String file,HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("UpdateEvent");
	 ob = new ReadFile();
		String fileContent = ob.findFile(file,request.getServletContext().getRealPath("/WEB-INF/jsp/Events/"));
		mv.addObject("model", fileContent);
		return mv;
	}
	
	@RequestMapping(value = "/eventManagerInterface")
	public ModelAndView EventManagerInterface() {

		return new ModelAndView("EventManagerInterface");
	}

}
