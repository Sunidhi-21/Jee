package com.xworkz.jdbcbank.insert.preparedstatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.xworkz.jdbcbank.resource.Customer;
import com.xworkz.jdbcbank.resource.JDBCConnectivity;

public class InsertUsingPreparedStatement {

	public static void main(String[] args) {
		
		JDBCConnectivity connectivity = new JDBCConnectivity();
		
		ArrayList<Customer> customers = new ArrayList<Customer>();
		customers.add(new Customer(8, "Suma", "Dixit", "Mumbai",4683829928l , "1988-09-12"));
		customers.add(new Customer(9, "Sanya", "Trivedi", "Lucknow",398739928l , "1997-10-01"));
	
		String sqlQuery = "insert into customer values(?,?,?,?,?,?)";
		try (Connection conn = connectivity.connect();
				PreparedStatement prepStmt = conn.prepareStatement(sqlQuery) ){
			
			for(Customer customer:customers) {
				prepStmt.setInt(1, customer.getcId());
				prepStmt.setString(2, customer.getFname());
				prepStmt.setString(3, customer.getLname());
				prepStmt.setString(4, customer.getCity());
				prepStmt.setLong(5, customer.getPhone());
				prepStmt.setString(6, customer.getDob());
				
				boolean result = prepStmt.execute();
				System.out.println("Result: "+result);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	
	
	
	}

}
