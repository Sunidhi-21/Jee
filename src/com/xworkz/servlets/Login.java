package com.xworkz.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xworkz.servlets.resources.JDBCConnectivity;

public class Login extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("Login servlet credentials");
		
		String username =req.getParameter("username");
		String password = req.getParameter("password");
		
		System.out.println("Username:"+username);
		System.out.println("Password:"+password);
		
		String sqlQuery= "Select * from user_details";
		JDBCConnectivity connectivity = new JDBCConnectivity();
		
		String usernameAcc=null;
		String passwordAcc=null;
		
		try(Connection conn = connectivity.connect();
				Statement stmt=conn.createStatement();
				ResultSet results = stmt.executeQuery(sqlQuery);)
				{
					System.out.println(conn);
					
					while(results.next()) 
					{
						usernameAcc = results.getString(2); 
						passwordAcc = results.getString(4);
						
						if((username.equals(usernameAcc))&&(password.equals(passwordAcc))){
							System.out.println("Login successfull");
							RequestDispatcher dispatcher = req.getRequestDispatcher("MenuPage.html");
								
							dispatcher.forward(req, resp);
						}
					}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
	}
}
