/**
 * 
 */
package com.ashwani.slambook.implementer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ashwani.slambook.dataservice.SlamService;
import com.ashwani.slambook.dataservice.UserService;
import com.ashwani.slambook.entity.Slam;
import com.ashwani.slambook.entity.User;
import com.ashwani.slambook.model.request.CreateSlamRequest;
import com.ashwani.slambook.model.request.GetUserRequest;
import com.ashwani.slambook.model.response.CreateSlamResponse;
import com.ashwani.slambook.model.response.GetAllFriendsResponse;
import com.ashwani.slambook.model.response.GetUserDetailsResponse;
import com.ashwani.slambook.model.response.GetUsersResponse;
import com.ashwani.slambook.model.response.IsUserResponse;
import com.ashwani.slambook.response_builder.SuccessConfigBuilder;
import com.ashwani.slambook.response_builder.ValidationConfigBuilder;
import com.ashwani.slambook.translator.SlamTranslator;
import com.ashwani.slambook.util.JWTUtil;
import com.ashwani.slambook.util.SlamUtils;
import com.ashwani.slambook.validator.ModelValidator;

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
	
	@Autowired
	private ModelValidator modelValidator;
	
	@Autowired
	private SlamService slamService;
	
	@Autowired
	private SlamTranslator slamTranslator;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImplementer.class);
	
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
			Optional<User> userFetched = userService.findByUsername(username);
			if(userFetched.isPresent()) {
				resp = successConfigBuilder.isUserSuccessresponse();
			}else {
				resp = successConfigBuilder.isNotUserSuccessResponse();
			}
		}else {
			resp = validationConfigBuilder.invalidUser(resp);
		}
		return resp;
	}

	
	/**
	 * @param request
	 * @return
	 */
	public GetUserDetailsResponse getUserDetails(GetUserRequest request) {
		GetUserDetailsResponse resp = new GetUserDetailsResponse();
		if(modelValidator.isValidGetUserRequest(request)) {
			if(isAuthenticUser(request.getToken())) {
				Optional<User> user = userService.findByUsername(request.getUsername());
				LOGGER.info("User fetched in GetUserDetails , {}",user.get());
				if(user.isPresent()) {
					resp = successConfigBuilder.getUserDetailsSuccessResponseBuilder(user.get());
				}
				else {
					resp = validationConfigBuilder.getUserDetailsNoSuchUser();
				}
			}
			else {
				resp = validationConfigBuilder.invalidUser(resp);
			}
		}else {
			resp = validationConfigBuilder.invalidGetUserDetailsRequest();
		}
		return resp;
	}

	/**
	 * @param req
	 * @return
	 */
	public CreateSlamResponse createSlam(CreateSlamRequest req) {
		CreateSlamResponse resp = new CreateSlamResponse();
		if(modelValidator.isValidCreateSlamRequest(req)) {
			if(isAuthenticUser(req.getToken())) {
				
				Slam slam = slamTranslator.translateCreateSlamRequest(req);
				try {
					slamService.save(slam);
					resp = successConfigBuilder.createSlamSuccessResponse(slam);
				}
				catch(Exception e) {
					resp = validationConfigBuilder.createSlamErrorResponse();
				}
				
			}
			else {
				resp = validationConfigBuilder.invalidUser(resp);
			}
			
		}else {
			resp = validationConfigBuilder.emptyCreateSlamRequest();
		}
		return resp;
	}
	

}
