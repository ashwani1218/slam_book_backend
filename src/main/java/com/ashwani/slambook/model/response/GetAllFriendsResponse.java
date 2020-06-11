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
 * createdAt 03-Jun-2020
 *
*/
public class GetAllFriendsResponse extends BaseResponse{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6824811579443433571L;

	
	private List<User> friends;


	public List<User> getFriends() {
		return friends;
	}


	public void setFriends(List<User> friends) {
		this.friends = friends;
	}
	
}
