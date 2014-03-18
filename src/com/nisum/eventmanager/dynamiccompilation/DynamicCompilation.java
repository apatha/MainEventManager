package com.nisum.eventmanager.dynamiccompilation;

import java.io.File; 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import javax.tools.Diagnostic;
import javax.tools.DiagnosticListener;
import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

/*
 * this class is used for dynamic compilation of the target project which will be created
 */
public class DynamicCompilation {

	String eventMainJsp = "ReDirectingToController.jsp";
	String[] eventRootStructure = { "WEB-INF", "META-INF" };
	String[] subWebInfStructure = { "classes", "jsp", "lib" };
	String[] subWebInfjsps = { "Success.jsp", "End.jsp" };
	String[] subClassesStructure = { "controller", "aop", "dozer",
			"interfaces", "mail", "validator", "model" ,"dao"};
	String[] classes = { "Controller", "Aop", "Dozer", "Interfaces", "Mail",
			"Validator", "Model" ,"Dao"};

	
	/*will dynamically compile the target project*/
	public void dynamicCompilation(String eventManager,String libPath) {

		
System.out.println("libpaTH "+libPath);
		
		System.setProperty("java.home", "C:/Program Files/Java/jdk1.6.0_37"); // setting the jdk path for dynamic compilation
				
				StringBuilder builder = new StringBuilder();
				builder.append(System.getProperty("java.class.path")).append(";");
				File folder = new File(libPath);
				File[] files = folder.listFiles();
		                //read all the files in WEB-INF/lib and add it to classpath
			        for (File file : files) {
			    	 builder.append(file).append(";");
				}
			        
				JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();// getting tthe compiler tool from the system
				List<String> optionList = new ArrayList<String>();
				optionList.addAll(Arrays.asList("-cp", builder.toString()));
				
				MyDiagnosticListener listener = new MyDiagnosticListener(); // used for detectign the errors and printing it in console

				StandardJavaFileManager fileManager = compiler.getStandardFileManager(
						listener, null, null); // appending the lister to the filemanager 

				//System.out.println(System.getProperty("java.class.path"));

				
				String[] fileToCompile = {
						"C:/Program Files/Apache Software Foundation/Tomcat 7.0/webapps/" + eventManager+ "/WEB-INF/classes/com/nisum/" + eventManager+ "/controller/MainController.java",						
						"C:/Program Files/Apache Software Foundation/Tomcat 7.0/webapps/" + eventManager+ "/WEB-INF/classes/com/nisum/" + eventManager	+ "/dao/Dao.java" ,
						"C:/Program Files/Apache Software Foundation/Tomcat 7.0/webapps/" + eventManager+ "/WEB-INF/classes/com/nisum/" + eventManager	+ "/model/Model.java" 
						};
				// files to be compiled

				Iterable fileObjects = fileManager.getJavaFileObjectsFromStrings(Arrays
						.asList(fileToCompile)); // Line 5

				CompilationTask task = compiler.getTask(null, fileManager, listener,
						optionList, null, fileObjects); // adding list to the task which has to be compiled

				Boolean result = task.call(); // calling the task to compile the total files


		if (result == true) {

			System.out.println("Compilation has succeeded");

		}

	}

}

class MyDiagnosticListener implements DiagnosticListener {

	public void report(Diagnostic diagnostic) {

		System.out.println("Code->" + diagnostic.getCode());

		System.out.println("Column Number->" + diagnostic.getColumnNumber());

		System.out.println("End Position->" + diagnostic.getEndPosition());

		System.out.println("Kind->" + diagnostic.getKind());

		System.out.println("Line Number->" + diagnostic.getLineNumber());

		System.out.println("Message->" + diagnostic.getMessage(Locale.ENGLISH));

		System.out.println("Position->" + diagnostic.getPosition());

		System.out.println("Source" + diagnostic.getSource());

		System.out.println("Start Position->" + diagnostic.getStartPosition());

		System.out.println("\n");

	}

}
