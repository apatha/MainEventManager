package com.nisum.eventmanager.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.nisum.eventmanager.interfaces.AdminLoginInterface;
import com.nisum.eventmanager.model.AdminLoginModel;
import com.nisum.eventmanager.model.ExistingEventModel;

/*
 * used for getting the login credentials from the db and 
 * checks the credentials
 */

public class AdminLoginDao implements AdminLoginInterface {

	private JdbcTemplate jdbcTemplateObject;

	public JdbcTemplate getJdbcTemplateObject() {
		return jdbcTemplateObject;
	}

	public void setJdbcTemplateObject(JdbcTemplate jdbcTemplateObject) {
		this.jdbcTemplateObject = jdbcTemplateObject;
	}

	/* used for checking the login credentials of the admin */
	@Override
	public boolean checkUser(AdminLoginModel adminLoginModel) {

		String SQL = "select * from AdminLoginCredentials where username=? and password=?";

		System.out.println(jdbcTemplateObject);

		List<AdminLoginModel> adminList = jdbcTemplateObject.query(
				SQL,
				new Object[] { adminLoginModel.getUserName(),
						adminLoginModel.getPassword() }, new AdminMapper());

		if (adminList.isEmpty())
			return false;

		return true;
	}

	/* row mapper inner class for getting the userName and Password from db */
	public class AdminMapper implements RowMapper<AdminLoginModel> {

		public AdminLoginModel mapRow(ResultSet rs, int rowNum)
				throws SQLException {
			AdminLoginModel admin = new AdminLoginModel();
			admin.setUserName(rs.getString("userName"));
			admin.setPassword(rs.getString("password"));
			return admin;

		}
	}

	public void insertEvents(ExistingEventModel ExistingEventModel)
			throws SQLException {
		// TODO Auto-generated method stub

		boolean flag = false;
		String SQL;

		if(ExistingEventModel==null){
			System.out.println("im here");
			SQL="Delete from event";
			jdbcTemplateObject.update(SQL);
		}
		else
		{
			SQL = "select * from event";

			List<ExistingEventModel> adminList = jdbcTemplateObject.query(SQL,
					new ExistingEventMapper());

			if (!ExistingEventModel.getEventName().equalsIgnoreCase(
					"NoExistingEvents")) {

				System.out.println("this is d event" + ExistingEventModel);

				if (adminList.size() == 0) {
					SQL = "insert into event values(?,?,?)";
					jdbcTemplateObject.update(SQL,
							new Object[] { ExistingEventModel.getEventNumber(),
									ExistingEventModel.getEventName(),
									ExistingEventModel.getExpression() });
				} else {
					if (ExistingEventModel != null) 
					{

						for (int i = 0; i < adminList.size(); i++) 
						{
							if (ExistingEventModel.getEventName().equals(
									adminList.get(i).getEventName())) 
							{
								flag = true;
							} else 
							{

							}
						}
						if (flag == true) 
						{
							SQL = "update event set expression=? where eventName=?";
							jdbcTemplateObject.update(SQL, new Object[] {
									ExistingEventModel.getExpression(),
									ExistingEventModel.getEventName() });
						} else 
						{

							SQL = "insert into event values(?,?,?)";
							jdbcTemplateObject.update(SQL, new Object[] {
									ExistingEventModel.getEventNumber(),
									ExistingEventModel.getEventName(),
									ExistingEventModel.getExpression() });
						}

					}
		}
		
		
				

			}
		}
	}

	public class ExistingEventMapper implements RowMapper<ExistingEventModel> {

		public ExistingEventModel mapRow(ResultSet rs, int rowNum)
				throws SQLException {
			ExistingEventModel existEvent = new ExistingEventModel();
			existEvent.setEventName(rs.getString("eventName"));
			existEvent.setEventNumber(rs.getInt("eventNumber"));
			existEvent.setExpression(rs.getString("expression"));
			return existEvent;

		}
	}

}
