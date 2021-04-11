package com.xworkz.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xworkz.servlets.resources.JDBCConnectivity;

public class CreateAccount extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("User account details");
		    
		//String uId = req.getParameter("userId");
		String email = req.getParameter("email");
		String username = req.getParameter("username");
		String dob = req.getParameter("dob");
		String password = req.getParameter("password");
	
		System.out.println("E-mail:"+email);
		System.out.println("Username:"+username);
		System.out.println("Date of birth:"+dob);
		System.out.println("Password:"+password);
		
		String sqlQuery = "insert into user_details values('"+email+"','"+username+"','"+dob+"','"+password+"')";
		
		JDBCConnectivity connectivity = new JDBCConnectivity();
		
		try(Connection conn = connectivity.connect();
				Statement stmt=conn.createStatement();) {
			
			int result = stmt.executeUpdate(sqlQuery);
			System.out.println("the no of rows inserted is: "+result);
		
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
		}
}
