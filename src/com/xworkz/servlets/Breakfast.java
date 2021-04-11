package com.xworkz.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xworkz.servlets.resources.JDBCConnectivity;

@WebServlet("/Breakfast")
public class Breakfast extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("in post method of breakfast servlet");
		
		String selection = request.getParameter("select1");
		
		String sqlQuery = "insert into cart values('"+selection+"')";
		
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

//Connection conn;
//
//try {
//	Class.forName("com.mysql.jdbc.Driver");
//	conn = DriverManager.getConnection(jdbcurl,jdbcusername,jdbcpassword);
//	System.out.println(conn);
//}catch (SQLException e) {
//	e.printStackTrace();
//}catch (ClassNotFoundException e) {
//	e.printStackTrace();
//} 

//System.out.println("in post method of breakfast servlet");
//
//String jdbcurl = (String) request.getAttribute("jdbcurl");
//String jdbcusername = (String) request.getAttribute("jdbcusername");
//String jdbcpassword = (String) request.getAttribute("jdbcpassword");
//
//HttpSession session = request.getSession();
//System.out.println("Session get attribute");
//System.out.println(session.getAttribute("usernameInSession"));
//
//Cookie[] cookies = request.getCookies();
//
//for(Cookie coo : cookies) {
//	System.out.println("Cookie get");
//	System.out.println(coo.getName()+" "+coo.getValue());
//}
//
//System.out.println(jdbcurl);
//System.out.println(jdbcusername);
//System.out.println(jdbcpassword);
//
//ServletContext context = request.getServletContext();
//	String c = (String) context.getAttribute("jdbcurl");
//System.out.println(c);