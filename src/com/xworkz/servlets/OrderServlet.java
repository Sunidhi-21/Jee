package com.xworkz.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("in order servlet");
		
		String selection = request.getParameter("select");
		System.out.println(selection);
		if(selection.equals("Breakfast")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("Breakfast.html");
			dispatcher.forward(request, response);
		}
		//to-do : lunch , chats

	}

}


//private String jdbcurl;
//private String jdbcusername;
//private String jdbcpassword;
//
//@Override
//public void init() throws ServletException {
//	System.out.println("in init method of orderservlet");
//	
//	 jdbcurl="jdbc:mysql://localhost:3306/bengaluru_eats";
//  	 jdbcusername="root";
//  	 jdbcpassword="root";
//  	 
//  	 System.out.println(jdbcurl);
//  	 System.out.println(jdbcusername);
//  	 System.out.println(jdbcpassword);
//	
//}

//HttpSession session=request.getSession();
//session.setAttribute("usernameInSession",jdbcusername);
//session.setMaxInactiveInterval(12);
//
//Cookie cookie = new Cookie("username",jdbcusername);
//Cookie cookie1 = new Cookie("password",jdbcpassword);
//cookie.setMaxAge(12);
//cookie1.setMaxAge(12);
//response.addCookie(cookie);
//response.addCookie(cookie1);
//
//RequestDispatcher dispatcher = request.getRequestDispatcher("Breakfast");
//
// request.setAttribute("jdbcurl", jdbcurl);
// request.setAttribute("jdbcusername", jdbcusername);
// request.setAttribute("jdbcpassword", jdbcpassword);
//
//ServletContext context = getServletContext();
//context.setAttribute("jdbcurl", jdbcurl);
//dispatcher.forward(request, response);
