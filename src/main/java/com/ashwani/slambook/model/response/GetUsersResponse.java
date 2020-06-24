/**
 * 
 */
package com.ashwani.slambook.model.response;

import java.util.List;

import com.ashwani.slambook.entity.User;
import com.ashwani.slambook.model.BaseResponse;

/**
 *
 * @author Ashwani Pandey
 *
 * createdAt 14-Jun-2020
 *
*/
public class GetUsersResponse extends BaseResponse{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2216351862382606147L;
	
	

	private List<User> userList;



	public List<User> getUserList() {
		return userList;
	}



	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	
	
}
