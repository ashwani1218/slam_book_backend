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
import com.ashwani.slambook.model.response.GetUsersResponse;
import com.ashwani.slambook.model.response.IsUserResponse;
import com.ashwani.slambook.response_builder.SuccessConfigBuilder;
import com.ashwani.slambook.response_builder.ValidationConfigBuilder;
import com.ashwani.slambook.util.JWTUtil;
import com.ashwani.slambook.util.SlamUtils;

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
	
	@Autowired
	private JWTUtil jwtUtil;
	
	
	
	public  boolean isAuthenticUser(String token) {
		if(jwtUtil.validateToken(token)) {
			return true;
		}
		return false;
	}
	
	/**
	 * @param username
	 * @return
	 */
	public GetAllFriendsResponse getAllFriends(String username,String token ) {
		GetAllFriendsResponse response = new GetAllFriendsResponse();
		
		if(isAuthenticUser(token)) {
			Optional<User> u = userService.findByUsername(username);
			User user;
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
		}
		else {
			response = validationConfigBuilder.invalidGetFriends();
		}
		return response;
	}

	/**
	 * @param username
	 * @return
	 */
	public GetUsersResponse getUsers(String searchString, String token) {
		GetUsersResponse response = new GetUsersResponse();
		if(isAuthenticUser(token)) {
			if(!SlamUtils.isNullOrEmpty(searchString)) {
				List<User> userList = userService.getUsers(searchString);
				if(userList.size()==0) {
					response = successConfigBuilder.getUsersEmptyList();
				}
				else {
					response = successConfigBuilder.getUsersResponseConfig(userList);
					
				}
			}else {
				response = validationConfigBuilder.emptySearchString();
			}
		}
		else {
			response = validationConfigBuilder.invalidGetUser();
		}
		return response;
	}

	/**
	 * @param username
	 * @param token
	 * @return
	 */
	public IsUserResponse isUser(String username, String token) {
		IsUserResponse resp = new IsUserResponse();
		if(isAuthenticUser(token)) {
			
		}else {
			resp = validationConfigBuilder.invalidUser(resp);
		}
		return resp;
	}

}
