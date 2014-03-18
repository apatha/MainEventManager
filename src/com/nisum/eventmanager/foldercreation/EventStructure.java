package com.nisum.eventmanager.foldercreation;

import java.io.File; 
import java.io.IOException;



/* 
 * This class is user for creating the folders,files and xml's of the 
 * event which admin creates
 */

public class EventStructure {

	File file;
	String eventMainJsp="ReDirectingToController.jsp";
	String[] eventRootStructure = { "WEB-INF", "META-INF" };
	String[] subWebInfStructure = { "classes", "jsp", "lib" };
	String[] subWebInfjsps = { "Success.jsp","End.jsp" };
	String[] subClassesStructure = { "controller", "aop", "dozer", "interfaces", "mail", "validator", "model" ,"dao"};
	String[] classes = { "MainController", "Aop", "Dozer", "Interfaces", "Mail", "Validator", "Model","Dao" };
	
	
	/*
	 * creating the main root Structure of project like 
	 * 	WEB-INF,META-INF,ReDirectingToController 
	 */
	public void eventRootStructure(String eventManager) throws IOException{
		
		/*creation of WEB-INF & META-INF folders 
		 *D:/Tomcat 7.0*/
		for ( String eventRootStructureCopy : eventRootStructure)
			new File(
					"C:/Program Files/Apache Software Foundation/Tomcat 7.0/webapps/"
							+  eventManager +"/"
							+ eventRootStructureCopy).mkdirs();
	
	/*creation of ReDirectingToController jsp*/
		file= new File("C:/Program Files/Apache Software Foundation/Tomcat 7.0/webapps/"
						+ eventManager + "/" + eventMainJsp);
		
		file.createNewFile();

	}
	
	/*
	 * creating the WEB-INF internal structure which has "classes", "jsp", "lib" folders
	 */
	public void WebInfStructure(String eventManager) throws IOException{
		
		/* this is for creating  classes,jsp,lib folder  */ 
		for (String subWebInfStructureCopy : subWebInfStructure)
			new File(
					"C:/Program Files/Apache Software Foundation/Tomcat 7.0/webapps/"
							+ eventManager +"/"
							+ eventRootStructure[0] + "/"
							+ subWebInfStructureCopy).mkdirs(); 

		
		String[] xmlOfWebInf = { "web.xml",eventManager+ "-servlet.xml" };
		
		for (String xmlOfWebInfCopy : xmlOfWebInf) {
			file = new File("C:/Program Files/Apache Software Foundation/Tomcat 7.0/webapps/" + eventManager + "/"
					+ eventRootStructure[0] + "/" + xmlOfWebInfCopy); // // for
																		// web-inf
																		// xml

			file.createNewFile();
		}
		
	}
	
	/* 
	 * creating the jsp folder structure which has Start and End jsp files
	 */
	public void webInfJspStructure(String eventManager) throws IOException{
		
		for (String subWebInfjspsCopy : subWebInfjsps)
		{	file = new File(
					"C:/Program Files/Apache Software Foundation/Tomcat 7.0/webapps/"
							+  eventManager +"/"
							+ eventRootStructure[0] + "/"
							+ subWebInfStructure[1] + "/" + subWebInfjspsCopy);
		file.createNewFile();
		}
	}
	
	/*
	 *creating the packages and .java classes of Classes folder  
	 */
	public void webInfClassesStructure(String eventManager) throws IOException{
		int i = 0;
		/* creation the packages */
		for (String subClassesStructureCopy : subClassesStructure) {
			new File(
					"C:/Program Files/Apache Software Foundation/Tomcat 7.0/webapps/"
							+ eventManager + "/"
							+ eventRootStructure[0] + "/"
							+ subWebInfStructure[0] + "/com/nisum/"
							+ eventManager + "/"
							+ subClassesStructureCopy).mkdirs();

			/* creation the .java files in corresponding packages */
			file = new File(
					"C:/Program Files/Apache Software Foundation/Tomcat 7.0/webapps/"
							+ eventManager + "/"
							+ eventRootStructure[0] + "/"
							+ subWebInfStructure[0] + "/com/nisum/"
							+ eventManager + "/"
							+ subClassesStructureCopy + "/" + classes[i]
							+ ".java");
			file.createNewFile();

			/* creation of xml in dozer */
			if (i == 2) {
				file = new File(
						"C:/Program Files/Apache Software Foundation/Tomcat 7.0/webapps/"
								+ eventManager + "/"
								+ eventRootStructure[0] + "/"
								+ subWebInfStructure[0] + "/com/nisum/"
								+ eventManager + "/"
								+ subClassesStructureCopy + "/" + classes[i]
								+ ".xml");
				file.createNewFile();
			}
			i++;

		}
	}
	
}
