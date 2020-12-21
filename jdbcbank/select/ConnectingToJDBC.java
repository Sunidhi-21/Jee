package com.xworkz.jdbcbank.select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectingToJDBC {

public static void main(String[] args) {
		
		String sqlQuery= "Select * from customer";
		
		try(Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/bank",
					"root","root");
			Statement stmt=conn.createStatement();
			ResultSet results = stmt.executeQuery(sqlQuery);)
			{
				System.out.println(conn);
				
				while(results.next()) {
					int id=results.getInt("cId");
					String fname= results.getString("fName");
					String lname = results.getString(3);
					String city = results.getString(4);
					String phone = results.getString(5);
					String dob = results.getString(6);
					
					System.out.println("id: "+id);
					System.out.println("fname: "+fname);
					System.out.println("lname: "+lname);
					System.out.println("city: "+city);
					System.out.println("phone: "+phone);
					System.out.println("dob: "+dob);
					System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}