package com.xworkz.jdbcbank.transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.xworkz.jdbcbank.resource.Branch;
import com.xworkz.jdbcbank.resource.Customer;
import com.xworkz.jdbcbank.resource.JDBCConnectivity;


public class TransactionExample {

	public static void main(String[] args) {
		JDBCConnectivity connectivity = new JDBCConnectivity();
		
		Connection conn=null;
		PreparedStatement customerPStmt=null;
		PreparedStatement branchPStmt=null;
		
		ArrayList<Customer> customers = new ArrayList<Customer>();
		customers.add(new Customer(4,"Radhe","Shyam","Kolkata",6478273543l,"1996-12-18"));
		customers.add(new Customer(5,"Swetha","Hari","Mysore",5646410468l,"2004-10-06"));
		
		ArrayList<Branch> branches = new ArrayList<Branch>();
		branches.add(new Branch(1,"Agb layout","Bangalore"));
		branches.add(new Branch(2,"Vijaynagar","Tumkur"));
		
		String insertIntoCustomer = "insert into customer values(?,?,?,?,?,?)";
		String insertIntoBranch = "insert into branch values(?,?,?)";
		
		try {
			conn = connectivity.connect();
			conn.setAutoCommit(false);
			
			customerPStmt = conn.prepareStatement(insertIntoCustomer);
			
			for(Customer customer:customers) {
				customerPStmt.setInt(1,customer.getcId());
				customerPStmt.setString(2, customer.getFname());
				customerPStmt.setString(3,customer.getLname());
				customerPStmt.setString(4,customer.getCity());
				customerPStmt.setLong(5, customer.getPhone());
				customerPStmt.setString(6,customer.getDob());
				
				boolean result = customerPStmt.execute();
				System.out.println("Result1: "+result);
			}
		
			branchPStmt = conn.prepareStatement(insertIntoBranch);
			
			for(Branch branch:branches) {
				branchPStmt.setInt(1,branch.getbId());
				branchPStmt.setString(2,branch.getbName());
				branchPStmt.setString(3,branch.getCity());
				
				boolean result = branchPStmt.execute();
				System.out.println("Result2: "+result);
			}
			
			conn.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
				System.out.println("rolled back");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally {
			
				try {
					if(conn!=null){
						customerPStmt.close();
						branchPStmt.close();
						conn.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			
	}

	
	
	
	
	}

}
//customers.add(new Customer(6,"Kavitha","Kalpesh","Kashi",3234781974l,"2001-09-01"));