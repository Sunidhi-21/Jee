package com.xworkz.jdbcbank.resource;

public class Customer {

	private int cId;
	private String fname;
	private String lname;
	private String city;
	private long phone;
	private String dob;

	public Customer(int cId, String fname, String lname, String city, long phone, String dob) {
		super();
		this.cId = cId;
		this.fname = fname;
		this.lname = lname;
		this.city = city;
		this.phone = phone;
		this.dob = dob;
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	
	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "Customer [cId=" + cId + ", fname=" + fname + ", lname=" + lname + ", city=" + city + ", phone=" + phone+",dob="+dob
				+ "]";
	}
	
	
	
}
