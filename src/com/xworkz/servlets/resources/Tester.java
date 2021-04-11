package com.xworkz.servlets.resources;

import java.sql.SQLException;

public class Tester {

	public static void main(String[] args) {
		JDBCConnectivity connectivity = new JDBCConnectivity();
		System.out.println(connectivity.connect());
	}

}
