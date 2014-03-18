package com.nisum.eventmanager.interfaces;

import java.util.List;
import java.util.Map;

public interface ReportGenerationInterface {

	public List<Map<String, Object>> retrievingEventReport(String eventName);
	public void deleteRow(String empid,String eventName);
	public List<Map<String, Object>> retrieveSingleRow(String empid,String eventName);
	public void updateRow(Map<String, String> allRequestParams);
}
