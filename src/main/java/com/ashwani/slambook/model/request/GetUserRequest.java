/**
 * 
 */
package com.ashwani.slambook.model.request;

/**
 *
 * @author Ashwani Pandey
 *
 * createdAt 14-Jun-2020
 *
*/
public class GetUserRequest {

	private String username;
	
	private String token;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	
	
}
