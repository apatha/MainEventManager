package com.nisum.eventmanager.reportGeneration;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.springframework.web.servlet.view.document.AbstractExcelView;



public class ExcelGeneration extends AbstractExcelView {
	
	@Override
	public void buildExcelDocument(Map<String, Object> dataIntoExcel,
			HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println(dataIntoExcel);
		List<Map<String, Object>> excelData =(List<Map<String, Object>>) dataIntoExcel.get("dataIntoExcel");
		System.out.println("table values"+excelData);
		HSSFSheet sheet = workbook.createSheet("Evnet Report");
		sheet.setDefaultColumnWidth(10);
		HSSFRow header = sheet.createRow(0);
		ArrayList<String> columnNames=new ArrayList<String>();
		columnNames.addAll(excelData.get(0).keySet());
		
		CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setFontName("Arial");
        //style.setFillForegroundColor(HSSFColor.BLUE.index);
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        font.setColor(HSSFColor.WHITE.index);
        style.setFont(font);
        
		for (int i = 0; i < columnNames.size(); i++) {
			header.createCell(i).setCellValue(columnNames.get(i));
			header.getCell(i).setCellStyle(style);
		}

		ArrayList<Object> columnValues=new ArrayList<Object>();
		for(int i=0;i<excelData.size();i++){
			System.out.println(excelData.get(i));
			Map<String, Object> map =excelData.get(i);
			System.out.println(map);
			Iterator<Entry<String, Object>> it = map.entrySet().iterator();
			 while (it.hasNext()) {
			    Entry<String, Object> entry = it.next(); 
			    columnValues.add(entry.getValue());
			 }
		}
		System.out.println(columnValues);
		int rowNum = 2,i=0;
		HSSFRow row = sheet.createRow(1);
		for(Object listValue:columnValues){
			if(i== columnNames.size()){
				
				row = sheet.createRow(rowNum++);
				i=0;
			}
			String value=listValue.toString();
			row.createCell(i).setCellValue(value);
			i++;
		}
	
	}

}