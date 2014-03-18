package com.nisum.eventmanager.dao;

import java.sql.ResultSet; 
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.nisum.eventmanager.model.EventNameModel;



public class EventRowMapper implements RowMapper<EventNameModel>{

	public EventNameModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		EventNameModel eventnameModel= new EventNameModel();
		eventnameModel.setEventName(rs.getString(1));
		return eventnameModel;
	}

}
