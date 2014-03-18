package com.nisum.eventmanager.interfaces;

 
import java.util.List; 
import java.util.Map;

import org.springframework.jdbc.BadSqlGrammarException;

import com.nisum.eventmanager.model.EventNameModel;



/*
 *  interface for dynamic table creation 
 */
public interface DynamicTableCreationInterface {

	
	public boolean checkTable(String eventName,Map<String,String> fields) throws Exception; //for checking whether table exist or not
	public void createTable(String eventName,Map<String,String> fields)throws Exception; //for creating  table 
	public void compareColumn(String eventName,Map<String,String> fields) throws Exception;//for comparing the columns of the already exist table  with modified  
	public void deleteColumn(String eventName,String columnname) throws Exception ;// for deletion of column
	public void addColumn(String eventName,String fieldname) throws Exception;
	
}
