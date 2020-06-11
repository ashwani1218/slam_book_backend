/**
 * 
 */
package com.ashwani.slambook.implementer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ashwani.slambook.dataservice.UserService;
import com.ashwani.slambook.entity.User;
import com.ashwani.slambook.model.response.GetAllFriendsResponse;
import com.ashwani.slambook.response_builder.SuccessConfigBuilder;
import com.ashwani.slambook.response_builder.ValidationConfigBuilder;

/**
 *
 * @author Ashwani Pandey
 *
 * createdAt 03-Jun-2020
 *
*/
@Component
public class UserServiceImplementer {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private SuccessConfigBuilder successConfigBuilder;

	@Autowired
	private ValidationConfigBuilder validationConfigBuilder;
	
	/**
	 * @param username
	 * @return
	 */
	public GetAllFriendsResponse getAllFriends(String username) {
		GetAllFriendsResponse response = new GetAllFriendsResponse();
		Optional<User> u = userService.findByUsername(username);
		User user = null;
		if(u.isPresent()) {
			user = u.get();
			List<User> friends = new ArrayList<>(user.getFriends());
			if(friends.size()>0) {
				response = successConfigBuilder.getAllFriendsSuccessResponseBuilder(friends); 
			}
			else {
				response = successConfigBuilder.getAllFriendsSuccessNoFriendsResponseBuilder();
			}
		}
		else {
			response = validationConfigBuilder.getAllFriendsSuccessResponseBuilder();
		}
		return response;
	}

}
