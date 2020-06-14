package com.ashwani.slambook.model.response;

import com.ashwani.slambook.model.BaseResponse;

public class LoginResponse extends BaseResponse{

	/**
	 * 
	 */
	private static final long serialVersionUID = 732326084166649221L;

	
	private String token;
	
	private String username;
	
	private String firstname;
	
	private String lastname;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	
}
