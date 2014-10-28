package edu.gaed.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class BaseDao {

	public static String DRIVER, URL, USER, PASSWORD;

	protected Connection getConnection() throws SQLException {
		Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
    	return conn;
	}

}
