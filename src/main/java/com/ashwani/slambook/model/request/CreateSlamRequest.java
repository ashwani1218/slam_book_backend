/**
 * 
 */
package com.ashwani.slambook.model.request;

/**
 *
 * @author Ashwani Pandey
 *
 * createdAt 26-Jun-2020
 *
*/
public class CreateSlamRequest {
	
	private String title;
	
	private String description;
	
	private String writer;
	
	private String owner;

	private String token;
	
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	

}
