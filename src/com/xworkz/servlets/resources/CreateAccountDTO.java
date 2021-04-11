package com.xworkz.servlets.resources;

public class CreateAccountDTO {

	private String email;
	private String username;
	private String dob;
	private String password;
	
	public CreateAccountDTO(String email, String username, String dob, String password) {
		super();
		this.email = email;
		this.username = username;
		this.dob = dob;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public String getUsername() {
		return username;
	}

	public String getDob() {
		return dob;
	}

	public String getPassword() {
		return password;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "CreateAccountDTO [email=" + email + ", username=" + username + ", dob=" + dob + ", password=" + password
				+ "]";
	}

}
