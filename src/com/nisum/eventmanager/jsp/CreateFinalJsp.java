package com.nisum.eventmanager.jsp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class CreateFinalJsp {

	public void createFile(String data, String eventName,
			Map<String, String> submitData,String path) throws IOException {

		HashMap<String,String>  radio = new HashMap<String, String>(submitData);
		HashMap<String,String>  count = new HashMap<String, String>(submitData);
		
		int lCount = 0,rTCount = 0;
		try
		{
		//fetches the no of labels in d page.
		lCount=Integer.parseInt(count.get("hidden6"));
		//gets the number of radioText in d page.
		rTCount=Integer.parseInt(count.get("hidden7"));
		}
		catch(Exception e)
		{
			System.out.println("There are no labels/radio in the page");
		}
		System.out.println(radio);
		String sCurrentLine = null;
		String fileContent = null;
		File dir = new File(path);
		String files = null;
		FilenameFilter filter = new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return name.startsWith("Final");
			}
		};

		String[] children = dir.list(filter);
		if (children == null) {
			System.out
					.println("Either dir does not exist or is not a directory");
		} else {
			for (int i = 0; i < children.length; i++) {
				files = children[i];
			}
		}

		BufferedReader br = null;
		try {

			br = new BufferedReader(new FileReader(
					path+"/"
							+ files));
			while ((sCurrentLine = br.readLine()) != null) {
				fileContent += sCurrentLine;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		Iterator<Entry<String, String>> itr = radio.entrySet().iterator();
		while (itr.hasNext()) {
			Entry<String, String> entry = itr.next();
			if (!(entry.getKey().contains("radioText"))) {
				itr.remove(); // avoids a ConcurrentModificationException
			}
		}
		
		try
		{
		for (int i = 1; i <= rTCount; i++) {
			data = data.replace("radioText" + i, "radioText" + i + "\" readonly=\"true\" value=\""
					+ radio.get("radioText" + i));
		}

		Iterator<Entry<String, String>> it = submitData.entrySet().iterator();
		while (it.hasNext()) {
			Entry<String, String> entry = it.next();
			if (!(entry.getKey().contains("Label"))) {
				it.remove(); // avoids a ConcurrentModificationException
			}
		}
		
		for (int i = 1; i <= lCount; i++) {
			data = data.replace("Label" + i, "Label" + i + "\" readonly=\"true\" value=\""
					+ submitData.get("Label" + i));
		}
		}
		catch(Exception e)
		{
			System.out.println("there are no labels/radio in the page");
		}
		int a = data.indexOf("<tbody><tr>") + 7;
		int b = data.indexOf("id=\"eventName\"></td> </tr>") + 26;
		try
		{
		String some = data.substring(a, b);
		
		data = data.replaceAll(some, "");
		// above 4 lines are used to remove event name and text box
		
		data = data
				.replaceAll(
						"<a href=\"#\" id=\"remScnt\"> <img src=\"../images/close.gif\" class=\"hidden\" alt=\"Close\" width=\"15\" height=\"15\"></a>",
						"");
		data = data
				.replaceAll(
						"<a href=\"#\" id=\"remcnt\"> <img src=\"../images/close.gif\" class=\"hidden\" alt=\"Close\" width=\"15\" height=\"15\"></a>",
						"");
		//above code is used to remove all close symbols
		
		
		fileContent = fileContent.replace("null", "");
		fileContent = fileContent.replace("eventNames", eventName);
		fileContent = fileContent.replace("ft\">", "ft\">" + data);
		fileContent = fileContent.replaceFirst("/MainEventManager/controller2/afterSubmit", "/"+eventName+"/controller/login");
		fileContent = fileContent.replaceAll("<tr> <td class=\"drop droppable\"></td> </tr>", "");

		System.out.println(data);
		File file = new File(path+"\\Final\\"+eventName+".jsp");
		file.createNewFile();
		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(fileContent);
		bw.close();
		}
		catch(Exception e)
		{
			System.out.println("exception");
		}
	}
}
