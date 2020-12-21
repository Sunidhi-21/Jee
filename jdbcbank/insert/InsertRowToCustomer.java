package com.xworkz.jdbcbank.insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.xworkz.jdbcbank.resource.Customer;

public class InsertRowToCustomer {

	public static void main(String[] args) {

		ArrayList<Customer> customers = new ArrayList<Customer>();
		customers.add(new Customer(1,"Rajesh","Ravi","Delhi",6478276573l,"1976-12-06"));
		customers.add(new Customer(2,"Sathya","Shyam","Dehradun",7326410468l,"1974-10-16"));
		customers.add(new Customer(3,"Sunitha","Suraj","Bangalore",3984781974l,"2000-12-11"));
		
		for(Customer customer : customers) {
			insertRow(customer);
		}
		
	}

	private static void insertRow(Customer customer) {
		
		int id = customer.getcId();
		String fname = customer.getFname();
		String lname = customer.getLname();
		String city = customer.getCity();
		long Phone = customer.getPhone();
		String dob = customer.getDob();
		
		String sqlQuery = "insert into customer values("+id+",'"+fname+"','"+lname+"','"+city+"','"+Phone+"','"+dob+"')";
		
		try(Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/bank",
				"root","root");
		Statement stmt=conn.createStatement();)
		{
			
			int result = stmt.executeUpdate(sqlQuery);
			System.out.println("the no of rows inserted is: "+result);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}

}


