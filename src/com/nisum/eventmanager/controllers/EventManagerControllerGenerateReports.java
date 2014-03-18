package com.nisum.eventmanager.controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nisum.eventmanager.dao.ReportGenerationDao;
import com.nisum.eventmanager.model.SchedulingModel;


@Controller
@RequestMapping("/generateReportController")
public class EventManagerControllerGenerateReports {
	
	
	
	@Autowired
	ReportGenerationDao reportGenerationDao;
	
	@RequestMapping("/generateReports")
	public ModelAndView generateReports(@RequestParam String file,HttpSession session){
		
		 file = file.replaceAll(".jsp","");
			System.out.println(file);
		ArrayList<String> columnNames=new ArrayList<String>();
	
		ModelAndView mv=new ModelAndView();
		List<Map<String, Object>> rows=reportGenerationDao.retrievingEventReport(file);
		System.out.println("rowsssss"+rows);
		try
		{
		columnNames.addAll(rows.get(0).keySet());
		ArrayList<Object> columnValues=new ArrayList<Object>();
		for(int i=0;i<rows.size();i++){
			System.out.println(rows.get(i));
			Map<String, Object> map =rows.get(i);
			System.out.println(map);
			Iterator<Entry<String, Object>> it = map.entrySet().iterator();
			 while (it.hasNext()) {
			    Entry<String, Object> entry = it.next(); 
			    columnValues.add(entry.getValue());
			 }}
			mv.addObject("columnNames", columnNames);
			mv.addObject("columnValues",columnValues);
			session.setAttribute("length", columnNames.size());
			System.out.println(session.getAttribute("length"));
			session.setAttribute("file", file);
			System.out.println(session.getAttribute("file"));
			System.out.println(columnValues);
			mv.setViewName("Reports");
		
			return mv;
		}
		catch (Exception e) {
			return new ModelAndView("error","ErrorMessage","No one Selected their choice");// TODO: handle exception
		}
		
}
	@RequestMapping("/pdfGeneration")
	public ModelAndView PdfGenerator(@RequestParam String file){
		
		 file = file.replaceAll(".jsp","");
		System.out.println(file);
		List<Map<String, Object>> rows=reportGenerationDao.retrievingEventReport(file);
		
		return new ModelAndView("pdfView","dataIntoPdf",rows);	
	}
	
	@RequestMapping("/excelGeneration")
	public ModelAndView excelGenerator(@RequestParam String file){
		
		 file = file.replaceAll(".jsp","");
			System.out.println(file);
			 List<Map<String, Object>> rows=reportGenerationDao.retrievingEventReport(file);

		return new ModelAndView("excelView","dataIntoExcel",rows);
		
	}
	
	@RequestMapping("/deleteEntry")
	public ModelAndView deleteEntry(@RequestParam String empid,String file){
		
		System.out.println(empid);
		System.out.println(file);
		
		reportGenerationDao.deleteRow(empid, file);
		ArrayList<String> columnNames=new ArrayList<String>();
		ModelAndView mv=new ModelAndView();
		List<Map<String, Object>> rows=reportGenerationDao.retrievingEventReport(file);
		System.out.println("rows in event"+rows);
		columnNames.addAll(rows.get(0).keySet());
		ArrayList<Object> columnValues=retrievingValuesFromMap(rows);
			mv.addObject("columnNames", columnNames);
			mv.addObject("columnValues",columnValues);
			mv.setViewName("Reports");
			return mv;
	}
	
	public ArrayList<Object> retrievingValuesFromMap(List<Map<String, Object>> rows){
		
		ArrayList<Object> columnValues=new ArrayList<Object>();
		for(int i=0;i<rows.size();i++){
			System.out.println(rows.get(i));
			Map<String, Object> map =rows.get(i);
			System.out.println(map);
			Iterator<Entry<String, Object>> it = map.entrySet().iterator();
			 while (it.hasNext()) {
			    Entry<String, Object> entry = it.next(); 
			    columnValues.add(entry.getValue());
			 }}
		return columnValues;
	}
	@RequestMapping("/getEntry")
	public ModelAndView updateEntry(@RequestParam String empid,String file){
		
		
		ArrayList<String> columnNames=new ArrayList<String>();
		ModelAndView mv=new ModelAndView();
		List<Map<String, Object>> rows=reportGenerationDao.retrieveSingleRow(empid, file);
		if(rows==null)
		{
			System.out.println("no value in rows");
		}
		else
		{
		columnNames.addAll(rows.get(0).keySet());
		ArrayList<Object> columnValues=retrievingValuesFromMap(rows);
		System.out.println(columnValues);
			mv.addObject("columnNames", columnNames);
			mv.addObject("columnValues",columnValues);
			mv.setViewName("updatePage");
		}
			return mv;
	}
	
	@RequestMapping("/updateEntry")
	public ModelAndView updateEntry(@RequestParam Map<String, String> allRequestParams){
		
		
		System.out.println("values in map in update"+allRequestParams);
		String eventName=allRequestParams.get("eventName");
		reportGenerationDao.updateRow(allRequestParams);
		ArrayList<String> columnNames=new ArrayList<String>();
		ModelAndView mv=new ModelAndView();
		List<Map<String, Object>> rows=reportGenerationDao.retrievingEventReport(eventName);
		columnNames.addAll(rows.get(0).keySet());
		ArrayList<Object> columnValues=retrievingValuesFromMap(rows);
			mv.addObject("columnNames", columnNames);
			mv.addObject("columnValues",columnValues);
			mv.setViewName("Reports");
			return mv;
		
	}
	
}


