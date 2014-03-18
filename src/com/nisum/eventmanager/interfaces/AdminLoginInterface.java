package com.nisum.eventmanager.interfaces;

import java.sql.SQLException;

import com.nisum.eventmanager.model.AdminLoginModel;
import com.nisum.eventmanager.model.ExistingEventModel;

/* 
 * interface for adminlogin and contains method for login
 *  credentials
 */
public interface AdminLoginInterface {
	public boolean checkUser(AdminLoginModel adminLoginModel);// for admin login credentials
	public void insertEvents(ExistingEventModel ExistingEventModel) throws SQLException;// for admin login credentials
}
	

