package com.zup.testeTecnico.dal;

import java.sql.*;

public abstract class MySqlConnection {

	private static final String SERVER = "jdbc:mysql://localhost/zup";
	
	private static final String USER = "root";
	
	private static final String PASSWORD = "admin";
	
	public static Connection connect() throws ClassNotFoundException, SQLException
	{
		Connection conn = null;
		
		Class.forName("com.mysql.jdbc.Driver");

		conn = DriverManager.getConnection(SERVER,USER,PASSWORD);
		
		return conn;
	}
	
}
