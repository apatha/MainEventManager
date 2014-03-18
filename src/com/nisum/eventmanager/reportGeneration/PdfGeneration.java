package com.nisum.eventmanager.reportGeneration;


import java.awt.Color; 
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

	public class PdfGeneration extends AbstractPdfView{
		
		@Override
		protected void buildPdfDocument(Map<String, Object> dataIntoPdf,
				Document document, PdfWriter pdfWriter, HttpServletRequest request,
				HttpServletResponse response) throws Exception {
			
			document.open();
			Chunk chunk=new Chunk("Welecome To Nisum's Event Managment Systm ...");
			chunk.setUnderline(+1f,-2f);
			//Image image = Image.getInstance ("D:\\practice\\EventManager\\WebContent\\images\\nisum.jpeg");
	        //image.scaleAbsolute(120f, 60f);//image width,height    
	        document.add(new Paragraph("Document Generated On - "+new Date().toString()));  
			
			
			
			System.out.println(dataIntoPdf);
			List<Map<String, Object>> pdfData =(List<Map<String, Object>>) dataIntoPdf.get("dataIntoPdf");
			System.out.println("table values"+pdfData);
			ArrayList<String> columnNames=new ArrayList<String>();
			columnNames.addAll(pdfData.get(0).keySet());
			int columnCount = columnNames.size();
			PdfPTable table=new PdfPTable(columnCount);
			 
			PdfPCell headCell = new PdfPCell(new Phrase("Nisum Technologies Event Managment Report "));
				headCell.setColspan(columnCount);
				headCell.setHorizontalAlignment(Table.ALIGN_CENTER);
				headCell.setBackgroundColor(new Color(199,21,133));
				table.addCell(headCell);
				Font font = FontFactory.getFont(FontFactory.TIMES_BOLD);
		       
			for (int i = 0; i < columnNames.size(); i++) {
				  PdfPCell cell = new PdfPCell();
			        cell.setPadding(5);
			         
			        // write table header
			        cell.setPhrase(new Phrase(columnNames.get(i), font));
			        table.addCell(cell);
				//table.addCell(columnNames.get(i));
			}
			
			ArrayList<Object> columnValues=new ArrayList<Object>();
			for(int i=0;i<pdfData.size();i++){
				System.out.println(pdfData.get(i));
				Map<String, Object> map =pdfData.get(i);
				System.out.println(map);
				Iterator<Entry<String, Object>> it = map.entrySet().iterator();
				 while (it.hasNext()) {
				    Entry<String, Object> entry = it.next(); 
				    columnValues.add(entry.getValue());
				 }
			}
			System.out.println(columnValues);
			
			int k=0;
			 for(int i=0;i<columnValues.size()/columnCount;i++){
				 
		               for (int j=0;j<columnCount; j++,k++){
	                
		                   table.addCell((String)columnValues.get(k));
		                   
		               }
	            } 
			// document.add(image);
			 document.add(chunk);
			 document.add(table);
		}
}

	

