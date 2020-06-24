/**
 * 
 */
package com.ashwani.slambook.model.response;

import com.ashwani.slambook.model.BaseResponse;

/**
 *
 * @author Ashwani Pandey
 *
 * createdAt 25-Jun-2020
 *
*/
public class IsUserResponse extends BaseResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 638429563942670601L;

	private boolean isUser;

	public boolean isUser() {
		return isUser;
	}

	public void setUser(boolean isUser) {
		this.isUser = isUser;
	}
	
	 
}
