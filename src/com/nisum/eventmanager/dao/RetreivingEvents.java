package com.nisum.eventmanager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import com.nisum.eventmanager.schedular.CreateSchudule;

public class RetreivingEvents {
	@Autowired
	private DataSource dataSource;
	@Autowired
	private CreateSchudule createSchudule;



	public CreateSchudule getCreateSchudule() {
		return createSchudule;
	}

	public void setCreateSchudule(CreateSchudule createSchudule) {
		this.createSchudule = createSchudule;
	}



public DataSource getDataSource() {
	return dataSource;
}

public void setDataSource(DataSource dataSource) {
	this.dataSource = dataSource;
}
public List retrive() throws Exception
{
	Connection con=dataSource.getConnection();
	PreparedStatement ps=con.prepareStatement("select eventname from event");
	//ps.setInt(1, no);
	ResultSet rs=ps.executeQuery();
	
	List ll=new ArrayList();
	int i=1;
	//Bike b=new Bike();
	while(rs.next())
	{
		String eventName=rs.getString(1);
		System.out.println(eventName);
		if(i==1)
		{
			System.out.println("this is not adding"+eventName);
			i++;
		}
		else
		{
			ll.add(eventName);
		}
		
		//System.out.println(ll);
	}
	return ll;
	
}

/* public void insertExpression(String dailyExpression,String events) throws SQLException {
	// TODO Auto-generated method stub
	Connection connection=dataSource.getConnection();
	//Statement statement=connection.createStatement();
	//String sql="update event set expression="+dailyExpression+"where eventName="+eventName;
	
	System.out.println("The Event name is:"+events);
	PreparedStatement preparedStatement=connection.prepareStatement("update event set expression=? where eventName=?");
	preparedStatement.setString(1, dailyExpression);
	preparedStatement.setString(2, events);
	int resultSet=preparedStatement.executeUpdate();
	System.out.println("Records are updated:"+resultSet);
}*/


public void insertExpression(String[] toMail,String subject,String body,String eventName,String dailyExpression) throws SQLException {
	// TODO Auto-generated method stub
	
	Connection connection=dataSource.getConnection();
		int n=0;
	PreparedStatement preparedStatement=connection.prepareStatement("insert into eventDetails(too,subject,body,eventname,expression) values(?,?,?,?,?)");
	for (String string : toMail) {
		preparedStatement.setString(1,string);
		preparedStatement.setString(2,subject);
		preparedStatement.setString(3, body);
		preparedStatement.setString(4, eventName);
		preparedStatement.setString(5,dailyExpression);
		n=preparedStatement.executeUpdate();
	}
	
	System.out.println("Records are updated:"+n);
	
}

/*public ArrayList retrivingAll() throws SQLException {
	ArrayList arrayList=new ArrayList();
	
	Connection connection=dataSource.getConnection();
	Statement statement=connection.createStatement();
	String sql="select eventName,expression  from event";
	ResultSet resultSet=statement.executeQuery(sql);
	while(resultSet.next())
	{
		String eventNameFromDB=resultSet.getString(2);
		String expressionFromDB=resultSet.getString(3);
	}
	return null;
	// TODO Auto-generated method stub
	
}
*/

public void retriveExpression() throws Exception
{
	
	Connection con=dataSource.getConnection();
	System.out.println("The connection is:"+con);
	PreparedStatement ps=con.prepareStatement("select too,subject,body,expression,eventname from eventdetails ");
	//PreparedStatement ps=con.prepareStatement("select too,subject,body,eventname,expression from eventdetails ");
	ResultSet rs=ps.executeQuery();
	int i = 1;
	while(rs.next())
	{

		System.out.println(rs.getString(1));
		System.out.println(rs.getString(2));
		System.out.println(rs.getString(3));
		System.out.println(rs.getString(4));
		System.out.println(rs.getString(5));
		
		System.out.println(createSchudule+"checking");
		createSchudule.getMailSenders().createMethod(new String[]{rs.getString(1)}, rs.getString(2), rs.getString(3), rs.getString(5));
		//createSchudule.getMailSenders().createMethod(rs.getString(1), rs.getString(2), rs.getString(3));
		String expre=rs.getString(4);
		
		createSchudule.mailDeta(expre, rs.getString(2) + i++, rs.getString(3) + i++);
		System.out.println("from dao"+expre);
			
	}
	
	
}


}
