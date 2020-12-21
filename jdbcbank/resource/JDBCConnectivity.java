package com.xworkz.jdbcbank.resource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnectivity {

	public Connection connect() throws SQLException {
		
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/bank",
				"root","root");
		
		return conn;
	}
}
