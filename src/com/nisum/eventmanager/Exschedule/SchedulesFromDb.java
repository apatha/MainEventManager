package com.nisum.eventmanager.Exschedule;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.DataSource;

public class SchedulesFromDb {
private DataSource dataSource;

public DataSource getDataSource() {
	return dataSource;
}

public void setDataSource(DataSource dataSource) {
	this.dataSource = dataSource;
}
public ArrayList exExpressions() throws SQLException
{
	ArrayList arrayList=new ArrayList();
	Connection connection=dataSource.getConnection();
	Statement statement=connection.createStatement();
	ResultSet resultSet=statement.executeQuery("select expression from event");
	while(resultSet.next())
	{
		String expression=resultSet.getString(3);
		arrayList.add(expression);
	}
	return arrayList;
	
}
}
