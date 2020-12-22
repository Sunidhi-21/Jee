package com.xworkz.jdbcbank.update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateTableCustomer {

	public static void main(String[] args) {
		
	String sqlQuery = "update customer set city = 'Jaipur' where cId=8";
		
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank",
						"root", "root");
			Statement stmt = conn.createStatement();
			){
			
			int result = stmt.executeUpdate(sqlQuery);  //Updating rows
			System.out.println("The no of rows updated is : "+ result);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
