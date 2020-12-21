package com.xworkz.jdbcbank.insert.batch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.xworkz.jdbcbank.resource.Customer;
import com.xworkz.jdbcbank.resource.JDBCConnectivity;

public class BatchInsertion {

	public static void main(String[] args) {
		
		ArrayList<Customer> customers = new ArrayList<Customer>();
		customers.add(new Customer(6,"Hema","Mahesh","Gulbargah",8098273543l,"1994-05-08"));
		customers.add(new Customer(7,"Swetha","Ravi","Tiptur",2146367468l,"1989-02-03"));
		
		JDBCConnectivity connectivity = new JDBCConnectivity();
		
		String insertIntoCustomer = "insert into customer values(?,?,?,?,?,?)";
		
		try (
				Connection conn = connectivity.connect();
			PreparedStatement customerPStmt = conn.prepareStatement(insertIntoCustomer);){
			
			for(Customer customer:customers) {
				customerPStmt.setInt(1,customer.getcId());
				customerPStmt.setString(2, customer.getFname());
				customerPStmt.setString(3,customer.getLname());
				customerPStmt.setString(4,customer.getCity());
				customerPStmt.setLong(5, customer.getPhone());
				customerPStmt.setString(6,customer.getDob());
			
				customerPStmt.addBatch();
			}
			
			customerPStmt.addBatch("update customer set fName = 'Ankitha' where cId=5");
			int[] results =customerPStmt.executeBatch();
			
			for(int i : results) {
				System.out.println(i);
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
				
			
		}
	}

