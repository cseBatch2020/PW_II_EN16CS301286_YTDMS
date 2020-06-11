package com.yash.ytdms.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
/**
 * This JNDIUtil class is used to get the common functionalities. 
 * like :  getting DataSource object, Getting the connection object 
 * and PreparedStatement object for performing transaction
 * Note: You will be just retreiving the PreparedStatement object 
 * by providing your intended sql and performing the transaction in your respective DAOImpl.
 * Never change the code here in this class.  
 * @author samay.jain
 *
 */
public class JNDIUtil {
	
	private  DataSource dataSource;
	private  Connection con;
	private  PreparedStatement pstmt;
	
	// @Resource(name = "jdbc/ytdmsdb")
	
	private   DataSource getDataSource () {
		
		try {
			Context context = new InitialContext();
			Context envContext=(Context)context.lookup("java:comp/env");
			dataSource =(DataSource)envContext.lookup("jdbc/ytdmsdb");
			
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
		return dataSource;
	}


	/**
	 * this method is used to make connection with database 
	 * @return connection establish between database
	 */
	public  Connection connect() {
		try {
			dataSource = getDataSource();
			con = dataSource.getConnection();
			System.out.println(con);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return con;
	}
	
	/**
	 * this method is used to create a prepared Statement for data manipulation
	 * @param sql query to be executed 
	 * @return prepared Statement
	 */
	public  PreparedStatement preparedStatement(String sql) {
		try {
			pstmt = connect().prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pstmt;
		
	}
	public void closeConnection() {
		try {
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
