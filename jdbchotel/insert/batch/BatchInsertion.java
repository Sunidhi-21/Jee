 package com.xworkz.jdbchotel.insert.batch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.xworkz.jdbchotel.resources.Hotel;
import com.xworkz.jdbchotel.resources.JDBCConnectivity;

public class BatchInsertion {

	public static void main(String[] args) {
		
		ArrayList<Hotel> hotels = new ArrayList<Hotel>();
		hotels.add(new Hotel(8,"mtr",0,4,true));
		hotels.add(new Hotel(9,"leela",60,5,true));
		hotels.add(new Hotel(10,"Heritage",45,3,false));
		
		JDBCConnectivity connectivity = new JDBCConnectivity();
		String insertQuery = "insert into hotels values(?,?,?,?,?)";
		
		try(Connection conn = connectivity.connect();
				PreparedStatement prepStmt = conn.prepareStatement(insertQuery);) {
				
			for(Hotel hotel:hotels) {
				
				prepStmt.setInt(1,hotel.getIdHotels());
				prepStmt.setString(2,hotel.getHotelName());
				prepStmt.setInt(3,hotel.getNoOfRooms());
				prepStmt.setDouble(4, hotel.getRating());
				prepStmt.setBoolean(5, hotel.isRestaurant());
				
				prepStmt.addBatch();
			} 
			
			prepStmt.addBatch("update hotels set hotelName = 'Heritage1' where idHotels=4");
			
			int[] results =prepStmt.executeBatch();
			
			for(int i : results) {
				System.out.println(i);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} 

	}

}
