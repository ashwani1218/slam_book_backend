/**
 * 
 */
package com.ashwani.slambook.response_builder;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.ashwani.slambook.constants.ResponseConstants;
import com.ashwani.slambook.entity.Slam;
import com.ashwani.slambook.entity.User;
import com.ashwani.slambook.model.response.CreateSlamResponse;
import com.ashwani.slambook.model.response.GetAllFriendsResponse;
import com.ashwani.slambook.model.response.GetUserDetailsResponse;
import com.ashwani.slambook.model.response.GetUsersResponse;
import com.ashwani.slambook.model.response.IsUserResponse;
import com.ashwani.slambook.model.response.LoginResponse;
import com.ashwani.slambook.model.response.RegistrationResponse;

/**
 *
 * @author Ashwani Pandey
 *
 *         createdAt 16-May-2020
 *
 */
@Component
public class SuccessConfigBuilder {

	/**
	 * @return LoginResponse
	 */
	public LoginResponse createJwt(String token, User u) {

		LoginResponse resp = new LoginResponse();
		resp.setHttpStatus(HttpStatus.OK);
		resp.setResponseCode(ResponseConstants.SUCCESS_CODE);
		resp.setResponseDescription(ResponseConstants.SUCCESS_LOGIN_DESCRIPTION);
		resp.setStatus(ResponseConstants.SUCCESS_LOGIN_STATUS);
		resp.setFirstname(u.getFirstname());
		resp.setLastname(u.getLastname());
		resp.setUsername(u.getUsername());
		resp.setToken(token);
		return resp;

	}

	/**
	 * @param user
	 * @return
	 */
	public RegistrationResponse registrationSuccess(User user) {

		RegistrationResponse resp = new RegistrationResponse();

		resp.setHttpStatus(HttpStatus.CREATED);
		resp.setStatus(ResponseConstants.SUCCESS_REGISTRATION_STATUS);
		resp.setResponseCode(ResponseConstants.SUCCESS_REGISTRATION_CODE);
		resp.setResponseDescription(ResponseConstants.SUCCESS_REGISTRATION);
		resp.setUsername(user.getUsername());

		return resp;
	}

	/**
	 * @param friends
	 * @return
	 */
	public GetAllFriendsResponse getAllFriendsSuccessResponseBuilder(List<User> friends) {
		GetAllFriendsResponse resp = new GetAllFriendsResponse();

		resp.setHttpStatus(HttpStatus.OK);
		resp.setStatus(ResponseConstants.SUCCESS_STATUS);
		resp.setResponseCode(ResponseConstants.SUCCESS_CODE);
		resp.setResponseDescription(ResponseConstants.SUCCESS_REQUEST);
		resp.setFriends(friends);

		return resp;
	}

	/**
	 * @return
	 */
	public GetAllFriendsResponse getAllFriendsSuccessNoFriendsResponseBuilder() {
		GetAllFriendsResponse resp = new GetAllFriendsResponse();

		resp.setHttpStatus(HttpStatus.OK);
		resp.setStatus(ResponseConstants.SUCCESS_STATUS);
		resp.setResponseCode(ResponseConstants.SUCCESS_CODE);
		resp.setResponseDescription(ResponseConstants.NO_FRIENDS);
		resp.setFriends(null);

		return resp;
	}

	/**
	 * @return
	 */
	public GetUsersResponse getUsersEmptyList() {
		GetUsersResponse resp = new GetUsersResponse();
		
		resp.setHttpStatus(HttpStatus.OK);
		resp.setStatus(ResponseConstants.SUCCESS_STATUS);
		resp.setResponseCode(ResponseConstants.SUCCESS_CODE_EMPTY_RESPONSE);
		resp.setUserList(null);
		resp.setResponseDescription(ResponseConstants.NO_USERS_FOUND);
		
		return resp;
	}

	/**
	 * @param userList
	 * @return
	 */
	public GetUsersResponse getUsersResponseConfig(List<User> userList) {
GetUsersResponse resp = new GetUsersResponse();
		
		resp.setHttpStatus(HttpStatus.OK);
		resp.setStatus(ResponseConstants.SUCCESS_STATUS);
		resp.setResponseCode(ResponseConstants.SUCCESS_CODE);
		resp.setUserList(userList);
		resp.setResponseDescription(ResponseConstants.SUCCESS_DESCRIPTION);
		
		return resp;
	}

	/**
	 * @return
	 */
	public IsUserResponse isUserSuccessresponse() {
		IsUserResponse resp = new IsUserResponse();
		
		resp.setHttpStatus(HttpStatus.OK);
		resp.setStatus(ResponseConstants.SUCCESS_STATUS);
		resp.setResponseCode(ResponseConstants.SUCCESS_CODE);
		resp.setUser(true);
		resp.setResponseDescription(ResponseConstants.SUCCESS_DESCRIPTION);
		return resp;
	}

	/**
	 * @return
	 */
	public IsUserResponse isNotUserSuccessResponse() {
		IsUserResponse resp = new IsUserResponse();
		
		resp.setHttpStatus(HttpStatus.OK);
		resp.setStatus(ResponseConstants.SUCCESS_STATUS);
		resp.setResponseCode(ResponseConstants.SUCCESS_CODE);
		resp.setUser(false);
		resp.setResponseDescription(ResponseConstants.SUCCESS_DESCRIPTION);
		return resp;
	}

	/**
	 * @param user
	 * @return
	 */
	public GetUserDetailsResponse getUserDetailsSuccessResponseBuilder(User user) {
		
		GetUserDetailsResponse resp = new GetUserDetailsResponse();
		
		resp.setFirstname(user.getFirstname());
		resp.setLastname(user.getLastname());
		resp.setHttpStatus(HttpStatus.OK);
		resp.setResponseCode(ResponseConstants.SUCCESS_CODE);
		resp.setSlams(user.getSlams());
		resp.setResponseDescription(ResponseConstants.SUCCESS_DESCRIPTION);
		resp.setStatus(ResponseConstants.SUCCESS_STATUS);
		
		return resp;
	}

	/**
	 * @param slam
	 * @return
	 */
	public CreateSlamResponse createSlamSuccessResponse(Slam slam) {
		CreateSlamResponse resp = new CreateSlamResponse();
		
		resp.setHttpStatus(HttpStatus.OK);
		resp.setResponseCode(ResponseConstants.SUCCESS_CODE);
		resp.setResponseDescription(ResponseConstants.SUCCESS_DESCRIPTION);
		resp.setStatus(ResponseConstants.SUCCESS_STATUS);
		resp.setSlamTitle(slam.getTitle());
		
		
		return resp;
	}

	


}
