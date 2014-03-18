package com.nisum.eventmanager.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.nisum.eventmanager.interfaces.DynamicTableCreationInterface;
import com.nisum.eventmanager.model.EventNameModel;

/*
 * used for generating the tables &
 * checking the table already exist or not and modifying according to it 
 * for the dynamically created event 
 */
public class DynamicTableCreation implements DynamicTableCreationInterface {

	private JdbcTemplate jdbcTemplateObject;
	String sql;

	public JdbcTemplate getJdbcTemplateObject() {
		return jdbcTemplateObject;
	}

	public void setJdbcTemplateObject(JdbcTemplate jdbcTemplateObject) {
		this.jdbcTemplateObject = jdbcTemplateObject;
	}

	/* checks whether the table aleady exist */
	public boolean checkTable(String eventName, Map<String, String> fields) throws Exception {

		sql = "show tables where tables_in_project=?";

		List<EventNameModel> adminList = jdbcTemplateObject.query(sql,
				new Object[] { eventName }, new EventRowMapper());
		if (adminList.isEmpty())
			return true;

		compareColumn(eventName, fields);
		return false;

	}

	/* creates a new table if the table does not exist in the db */
	public void createTable(String eventName, Map<String, String> fields) throws Exception{

		sql = "create table " + eventName
				+ "(id varchar(10) Primary Key, date varchar(20))";

		jdbcTemplateObject.update(sql);

		
			
			
			for (Entry<String, String> entry : fields.entrySet()) {

				sql = "alter table " + eventName + " add "
						+ entry.getValue().replaceAll("\\s", "_") + " varchar(20)";
				jdbcTemplateObject.update(sql);
				
			}
			
		
		}

	

	/*
	 * compares the existing table and the updated table and does the operation
	 * as needed
	 */
	public void compareColumn(String eventName, Map<String, String> fields) throws Exception {

		int j = 0, i = 0, k = 0;
		List<String> fildNamesList = new ArrayList<String>();

		sql = "SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_SCHEMA = 'project' AND TABLE_NAME =?";

		List<EventNameModel> columnList = jdbcTemplateObject.query(sql,
				new Object[] { eventName }, new EventRowMapper());
		int nc = columnList.size();
		System.out.println(nc);
		int nf = fields.size();
		for (Entry<String, String> entry : fields.entrySet()) {
			String feildName = entry.getValue().replaceAll("\\s", "_");
			fildNamesList.add(feildName);

		}

		for (i = 0; i < nf; i++) {
			k = 0;
			for (j = 0; j < nc - 2; j++) {
				System.out.println("in inside");
				if (columnList.get(j + 2).getEventName()
						.equals(fildNamesList.get(i))) {
					k++;
				}
			}
			if (k == 0) {
				addColumn(eventName, fildNamesList.get(i));
			}
		}

		for (i = 0; i < nc - 2; i++) {
			k = 0;
			for (j = 0; j < nf; j++) {
				if (columnList.get(i + 2).getEventName()
						.equals(fildNamesList.get(j))) {
					k++;
				}
			}
			if (k == 0) {
				deleteColumn(eventName, columnList.get(i + 2).getEventName());
			}

		}

	}

	/* row mapper for getting the event name */
	public class EventRowMapper implements RowMapper<EventNameModel> {

		public EventNameModel mapRow(ResultSet rs, int rowNum)
				throws SQLException {
			EventNameModel eventnameModel = new EventNameModel();
			eventnameModel.setEventName(rs.getString(1));
			return eventnameModel;
		}

	}

	@Override
	public void addColumn(String eventName, String fieldname) throws Exception {

		sql = "alter table " + eventName + " add " + fieldname + " varchar(20)";

		jdbcTemplateObject.update(sql);
	}

	/*
	 * used for deleting the column if the exist table is having more column
	 * after updation
	 */
	public void deleteColumn(String eventName, String columnname) throws Exception {

		sql = "alter table " + eventName + " drop " + columnname + "";
		jdbcTemplateObject.update(sql);
	}
}
