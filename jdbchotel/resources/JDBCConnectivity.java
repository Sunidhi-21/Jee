package com.xworkz.jdbchotel.resources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnectivity  {

	public Connection connect() throws SQLException {
	
	Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/20transowd08",
			"root","root");
	
	return conn;
}
}