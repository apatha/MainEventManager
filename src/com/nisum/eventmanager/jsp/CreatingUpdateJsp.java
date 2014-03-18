package com.nisum.eventmanager.jsp;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;


public class CreatingUpdateJsp {
	CreateFinalJsp cj=new CreateFinalJsp();
	
	public void Submit(String data,
			String eventName,
			 Map<String, String> submitData,String path) throws IOException {
		
		HashMap<String,String>  count = new HashMap<String, String>(submitData);
		HashMap<String,String>  radio = new HashMap<String, String>(submitData);
		
		System.out.println(count+""+radio);
		
data = data.replaceAll("\\s+", " ");
		
		cj.createFile(data,eventName,submitData, path); //for final jsp creation
		
		Iterator<Entry<String, String>> ite = count.entrySet().iterator();
		while (ite.hasNext()) {
			Entry<String, String> entry = ite.next();
			if (!(entry.getKey().contains("hidden"))) {
				ite.remove(); // avoids a ConcurrentModificationException
			}
		}
		
		try
		{
		//fetches the no of labels in d page.
		int lCount=Integer.parseInt(count.get("hidden6"));
		//gets the number of radioText in d page.
		int rTCount=Integer.parseInt(count.get("hidden7"));
		
		for (int i = 1; i <= 7; i++) {
			data = data.replace("hidden" + i, "hidden" + i + "\"  value=\""
					+ count.get("hidden" + i));
		}
		
		data = data.replace("eventName","eventName\" value=\""+eventName);
		
		Iterator<Entry<String, String>> it = submitData.entrySet().iterator();
		while (it.hasNext()) {
			Entry<String, String> entry = it.next();
			if (!(entry.getKey().contains("Label"))) {
				it.remove(); // avoids a ConcurrentModificationException
			}
		}
		
		
		for (int i = 1; i <= lCount; i++) {
			data = data.replace("Label" + i, "Label" + i + "\"  value=\""
					+ submitData.get("Label" + i));
		}
		
		Iterator<Entry<String, String>> itr = radio.entrySet().iterator();
		while (itr.hasNext()) {
			Entry<String, String> entry = itr.next();
			if (!(entry.getKey().contains("radioText"))) {
				itr.remove(); // avoids a ConcurrentModificationException
			}
		}
		
		for (int i = 1; i <= rTCount; i++) {
			data = data.replace("radioText" + i, "radioText" + i + "\"  value=\""
					+ radio.get("radioText" + i));
		}
		}
		catch(Exception e)
		{
			System.out.println("there may be no lables/radio in the page");
		}
		path=path+"/Events/";
		File file = new File(path+eventName + ".jsp");
		// if file doesnt exists, then create it
		if (!file.exists()) {
			file.createNewFile();
		} else {
			file.createNewFile();
			/* file=new File(rf.getFile(eventName)); */
		}
		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(data);
		bw.close();
		System.out.println(data);
		
	}
}
