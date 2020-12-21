package com.xworkz.jdbchotel.insert.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.xworkz.jdbchotel.resources.Hotel;

public class InsertUsingPreparedStatement {

public static void main(String[] args) {
		
		ArrayList<Hotel> hotels = new ArrayList<Hotel>();
		hotels.add(new Hotel(5,"maiyas",0,4,true));
		hotels.add(new Hotel(6,"Raj Mahal",30,4.5,true));
		hotels.add(new Hotel(7,"Rajadhani",0,5,true));
		
		String insertQuery = "insert into hotels values(?,?,?,?,?)";
		
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/20transowd08",
					"root","root");
			PreparedStatement prepStmt = conn.prepareStatement(insertQuery);)
		{
			for(Hotel hotel:hotels) {
				
				prepStmt.setInt(1,hotel.getIdHotels());
				prepStmt.setString(2,hotel.getHotelName());
				prepStmt.setInt(3,hotel.getNoOfRooms());
				prepStmt.setDouble(4, hotel.getRating());
				prepStmt.setBoolean(5, hotel.isRestaurant());
				
				boolean result = prepStmt.execute();
				System.out.println("Result: "+result);
				
				}	
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
}
}
