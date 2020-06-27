/**
 * 
 */
package com.ashwani.slambook.model.response;

import com.ashwani.slambook.model.BaseResponse;

/**
 *
 * @author Ashwani Pandey
 *
 * createdAt 26-Jun-2020
 *
*/
public class CreateSlamResponse extends BaseResponse{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3363617653221011110L;

	
	private String slamTitle;


	public String getSlamTitle() {
		return slamTitle;
	}


	public void setSlamTitle(String slamTitle) {
		this.slamTitle = slamTitle;
	}
	
	
}
