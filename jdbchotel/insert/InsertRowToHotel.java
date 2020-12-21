package com.xworkz.jdbchotel.insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.xworkz.jdbchotel.resources.Hotel;

public class InsertRowToHotel {

	public static void main(String[] args) {

		ArrayList<Hotel> hotels = new ArrayList<Hotel>();
		hotels.add(new Hotel(2,"m t r",0,4,true));
		hotels.add(new Hotel(3,"Leela palace",60,5,true));
		hotels.add(new Hotel(4,"Heritage",45,3,false));
		
		for(Hotel hotel : hotels) {
			insertRow(hotel);
		}
		
	}

	private static void insertRow(Hotel hotel) {
		
		int id = hotel.getIdHotels();
		String hotelname = hotel.getHotelName();
		int noOfRooms = hotel.getNoOfRooms();
		double rating = hotel.getRating();
		boolean isRestaurant = hotel.isRestaurant();
		
		String sqlQuery = "insert into hotels values("+id+",'"+hotelname+"',"+noOfRooms+","+rating+","+isRestaurant+")";
		
		try(Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/20transowd08",
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
