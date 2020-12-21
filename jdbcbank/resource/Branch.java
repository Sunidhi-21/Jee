package com.xworkz.jdbcbank.resource;

public class Branch {

	private int bId;
	private String bName;
	private String city;
	
	public Branch(int bId, String bName, String city) {
		super();
		this.bId = bId;
		this.bName = bName;
		this.city = city;
	}
	
	public int getbId() {
		return bId;
	}
	public void setbId(int bId) {
		this.bId = bId;
	}
	public String getbName() {
		return bName;
	}
	public void setbName(String bName) {
		this.bName = bName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	@Override
	public String toString() {
		return "Branch [bId=" + bId + ", bName=" + bName + ", city=" + city + "]";
	}
	
	
}
