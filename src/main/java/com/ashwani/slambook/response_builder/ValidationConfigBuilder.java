package com.ashwani.slambook.response_builder;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.ashwani.slambook.constants.ResponseConstants;
import com.ashwani.slambook.model.response.GetAllFriendsResponse;
import com.ashwani.slambook.model.response.LoginResponse;
import com.ashwani.slambook.model.response.RegistrationResponse;

@Component
public class ValidationConfigBuilder {

	/**
	 * @return LoginResponse
	 */
	public LoginResponse emptyLoginRequest() {
		LoginResponse resp = new LoginResponse();
		resp.setHttpStatus(HttpStatus.BAD_REQUEST);
		resp.setResponseCode(ResponseConstants.NOT_FOUND_CODE);
		resp.setResponseDescription(ResponseConstants.EMPTY_LOGIN_REQUEST);
		resp.setStatus(ResponseConstants.FAILED_STATUS);
		return resp;
		
	}

	/**
	 * @return LoginResponse
	 */
	public LoginResponse unauthenticUser() {
		LoginResponse resp = new LoginResponse();
		resp.setHttpStatus(HttpStatus.UNAUTHORIZED);
		resp.setResponseCode(ResponseConstants.UNAUTHENTIC_CODE);
		resp.setResponseDescription(ResponseConstants.UNAUTHENTIC_USER);
		resp.setStatus(ResponseConstants.FAILED_STATUS);
		return resp;
	}

	/**
	 * @return RegistrationResponse
	 */
	public RegistrationResponse alreadyAnUser() {
		RegistrationResponse resp = new RegistrationResponse();
		resp.setHttpStatus(HttpStatus.FORBIDDEN);
		resp.setStatus(ResponseConstants.FAILED_STATUS);
		resp.setResponseCode(ResponseConstants.ALREADY_USER_CODE);
		resp.setResponseDescription(ResponseConstants.ALREADY_USER);
		resp.setUsername(null);
		return resp;
	}

	/**
	 * @return RegistrationResponse
	 */
	public RegistrationResponse invalidRegistrationRequest() {
		RegistrationResponse resp = new RegistrationResponse();
		resp.setHttpStatus(HttpStatus.BAD_REQUEST);
		resp.setStatus(ResponseConstants.FAILED_STATUS);
		resp.setResponseCode(ResponseConstants.FAILURE_CODE);
		resp.setResponseDescription(ResponseConstants.EMPTY_REGISTRATION_REQUEST);
		resp.setUsername(null);
		return resp;
	}

	/**
	 * @return GetAllFriendsResponse
	 */
	public GetAllFriendsResponse getAllFriendsSuccessResponseBuilder() {
		GetAllFriendsResponse resp = new GetAllFriendsResponse();
		
		resp.setHttpStatus(HttpStatus.BAD_REQUEST);
		resp.setResponseCode(ResponseConstants.FAILURE_CODE);
		resp.setResponseDescription(ResponseConstants.INVALID_USER);
		resp.setStatus(ResponseConstants.FAILED_STATUS);
		resp.setFriends(null);
		
		return resp;
	}

	
	
}
