package com.xworkz.jdbchotel.resources;

public class Hotel {

	private int idHotels;
	private String hotelName ;
	private int noOfRooms ;
	private double rating ;
	private boolean isRestaurant ;
	
	public Hotel(int idHotels, String hotelName, int noOfRooms, double rating, boolean isRestaurant) {
		super();
		this.idHotels = idHotels;
		this.hotelName = hotelName;
		this.noOfRooms = noOfRooms;
		this.rating = rating;
		this.isRestaurant = isRestaurant;
	}

	public int getIdHotels() {
		return idHotels;
	}

	public void setIdHotels(int idHotels) {
		this.idHotels = idHotels;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public int getNoOfRooms() {
		return noOfRooms;
	}

	public void setNoOfRooms(int noOfRooms) {
		this.noOfRooms = noOfRooms;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public boolean isRestaurant() {
		return isRestaurant;
	}

	public void setRestaurant(boolean isRestaurant) {
		this.isRestaurant = isRestaurant;
	}

	@Override
	public String toString() {
		return "Hotel [idHotels=" + idHotels + ", hotelName=" + hotelName + ", noOfRooms=" + noOfRooms + ", rating="
				+ rating + ", isRestaurant=" + isRestaurant + "]";
	}
	
	
	
	
}
