package com.xworkz.servlets.resources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SendToDb {
	
	String jdbcurl;
	String jdbcusername;
	String jdbcpassword;

    public void sendToDb(CreateAccountDTO createAccountDTO) throws ClassNotFoundException{
	
    Connection conn=null;
	String sqlQuery = "insert into user_details values(?,?,?,?)";
	
	try{
		Class.forName("com.mysql.jdbc.Driver");
		conn= DriverManager.getConnection(jdbcurl,
			jdbcusername,jdbcpassword);
		PreparedStatement prepStmt = conn.prepareStatement(sqlQuery);
	
		prepStmt.setString(1, createAccountDTO.getEmail());
		prepStmt.setString(2, createAccountDTO.getUsername());
		prepStmt.setString(3, createAccountDTO.getDob());
		prepStmt.setString(4, createAccountDTO.getPassword());
		
		boolean result = prepStmt.execute();
		System.out.println("Result: "+result);
		
	}catch (Exception e) {
		e.printStackTrace();
	}finally{
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
	
	
}
