package com.xworkz.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomePage extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("In homepage POST method of servlet");
		
//		String userSelect = req.getParameter("selection");
//		
//		if(userSelect.equals("login")) {
//			RequestDispatcher dispatcher = req.getRequestDispatcher("Login.html");
//			dispatcher.forward(req, resp);
//			
//		}else if(userSelect.equals("CreateAccount")) {
//			  RequestDispatcher dispatcher = req.getRequestDispatcher("CreateAccount.html");
//			  dispatcher.forward(req, resp);
//				 
//		} 
	}
}