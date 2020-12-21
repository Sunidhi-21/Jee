package com.xworkz.jdbchotel.transaction;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.xworkz.jdbchotel.resources.Hotel;
import com.xworkz.jdbchotel.resources.JDBCConnectivity;

public class TransactionExample {

	public static void main(String[] args) {
		
		JDBCConnectivity connectivity = new JDBCConnectivity();
		
		Connection conn=null;
		PreparedStatement prepStmt=null;

		ArrayList<Hotel> hotels = new ArrayList<Hotel>();
		hotels.add(new Hotel(11,"ctr",0,4.5,true));
		hotels.add(new Hotel(12,"zone",30,5,true));
		
		String insertIntoHotel = "insert into hotels values(?,?,?,?,?)";
		
		try {
			conn = connectivity.connect();
			prepStmt = conn.prepareStatement(insertIntoHotel);
			
			conn.setAutoCommit(false);
			
			for(Hotel hotel:hotels) {
				
				prepStmt.setInt(1,hotel.getIdHotels());
				prepStmt.setString(2,hotel.getHotelName());
				prepStmt.setInt(3,hotel.getNoOfRooms());
				prepStmt.setDouble(4, hotel.getRating());
				prepStmt.setBoolean(5, hotel.isRestaurant());
				
				boolean result = prepStmt.execute();
				System.out.println("Result: "+result);
				
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
						prepStmt.close();
						conn.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			
	}

  }
	
}
