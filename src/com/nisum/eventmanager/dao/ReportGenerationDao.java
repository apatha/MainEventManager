package com.nisum.eventmanager.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import com.nisum.eventmanager.interfaces.ReportGenerationInterface;
import com.nisum.eventmanager.model.EventNameModel;

public class ReportGenerationDao implements ReportGenerationInterface{
	
	private JdbcTemplate jdbcTemplateObject;
	String sql;
	public JdbcTemplate getJdbcTemplateObject() {
		return jdbcTemplateObject;
	}

	public void setJdbcTemplateObject(JdbcTemplate jdbcTemplateObject) {
		this.jdbcTemplateObject = jdbcTemplateObject;
	}

public List<Map<String, Object>> retrievingEventReport(String eventName) {
	
	    sql="select * from "+eventName+"";
		List<Map<String, Object>> rows =jdbcTemplateObject.queryForList(sql);		
		
    	return rows;
		
		//System.out.println(rows);
		
	}

public void deleteRow(String empid,String eventName){
	
	sql="delete from "+eventName+" where id='"+empid+"'";
	jdbcTemplateObject.update(sql);
}
public List<Map<String, Object>> retrieveSingleRow(String empid,String eventName){
	
	sql="select * from "+eventName+" where id='"+empid+"'";
	List<Map<String, Object>> rows =jdbcTemplateObject.queryForList(sql);
	return rows;
}

public void updateRow(Map<String, String> allRequestParams){
	
	String eventName=allRequestParams.get("eventName");
	allRequestParams.remove("eventName");
	sql = "SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_SCHEMA = 'project' AND TABLE_NAME =?";

	List<EventNameModel> columnList = jdbcTemplateObject.query(sql,
			new Object[] { eventName }, new EventRowMapper());
	int length=columnList.size();
	
	sql="update "+eventName+" set";
	for(int i=0;i<length;i++){
		System.out.println("column name"+columnList.get(i).getEventName());
		sql+=" "+columnList.get(i).getEventName()+"='"+allRequestParams.get("name"+i+"")+"',";		
	}
	sql+=") where id='"+allRequestParams.get("name0")+"'";
	sql=sql.replace(",)","");
	System.out.println(sql);
	jdbcTemplateObject.update(sql);
}

}
