package com.nisum.eventmanager.datacopying;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;




public class DataCopying {

	File srcFolder,destFolder  ;

	String eventMainJsp="ReDirectingToController.jsp";
	String[] eventRootStructure = { "WEB-INF", "META-INF" };
	String[] subWebInfStructure = { "classes", "jsp", "lib" };
	String[] subWebInfjsps = { "Success.jsp","End.jsp" };
	String[] subClassesStructure = { "controller", "aop", "dozer", "interfaces", "mail", "validator", "model" ,"dao"};
	String[] classes = { "MainController", "Aop", "Dozer", "Interfaces", "Mail", "Validator", "Model","Dao" };
	
	/* used for copying the libraries into the target event*/
	public void copyingLibraries(String eventManager,String path) {

		srcFolder = new File(path); // ****
		destFolder = new File(
				"C:/Program Files/Apache Software Foundation/Tomcat 7.0/webapps/"
						+ eventManager + "/WEB-INF/lib");

		// make sure source exists
		if (!srcFolder.exists()) {

			System.out.println("Directory does not exist.");

		} else {

			try {
				copyFolder(srcFolder, destFolder);
			} catch (IOException e) {
				e.printStackTrace();

			}
		}
	
	}
	
	
	/* copying the  jsp from eventmanager into target success jsp project*/
	public void copyingSuccessJsp(String eventManager,String path) throws IOException{

   		 srcFolder = new File(path);
		destFolder = new File("C:/Program Files/Apache Software Foundation/Tomcat 7.0/webapps/"
				+ eventManager + "/WEB-INF/"
				+ subWebInfStructure[1] +"/"+subWebInfjsps[0] );

		copyFolder(srcFolder, destFolder);
	}
	
	
	/* copying the end jsp from eventmanager into target  end jsp project*/
	public void copyingEndJsp(String eventManager,String path) throws IOException{

   		 srcFolder = new File(path);/*****/
		destFolder = new File("C:/Program Files/Apache Software Foundation/Tomcat 7.0/webapps/"
				+ eventManager + "/WEB-INF/"
				+ subWebInfStructure[1] +"/"+subWebInfjsps[1] );

		copyFolder(srcFolder, destFolder);
	}
	

	
	/* method for copying the files ,jars  etc.....*/
	public static void copyFolder(File src, File dest) throws IOException {

		if (src.isDirectory()) {

			// if directory not exists, create it
			if (!dest.exists()) {
				dest.mkdir();
				System.out.println("Directory copied from " + src + "  to "
						+ dest);
			}

			// list all the directory contents
			String files[] = src.list();

			for (String file : files) {
				// construct the src and dest file structure
				File srcFile = new File(src, file);
				File destFile = new File(dest, file);
				// recursive copy
				copyFolder(srcFile, destFile);
			}

		} else {
			// if file, then copy it
			// Use bytes stream to support all file types
			InputStream in = new FileInputStream(src);
			OutputStream out = new FileOutputStream(dest);

			byte[] buffer = new byte[1024];

			int length;
			// copy the file content in bytes
			while ((length = in.read(buffer)) > 0) {
				out.write(buffer, 0, length);
			}

			in.close();
			out.close();
			System.out.println("File copied from " + src + " to " + dest);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
