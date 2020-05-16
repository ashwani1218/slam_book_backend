/**
 * 
 */
package com.ashwani.slambook.response_builder;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.ashwani.slambook.constants.ResponseConstants;
import com.ashwani.slambook.entity.User;
import com.ashwani.slambook.model.response.LoginResponse;
import com.ashwani.slambook.model.response.RegistrationResponse;

/**
 *
 * @author Ashwani Pandey
 *
 * createdAt 16-May-2020
 *
*/
@Component
public class SuccesConfigBuilder {

	/**
	 * @return LoginResponse
	 */
	public LoginResponse createJwt(String token) {
		
		LoginResponse resp = new LoginResponse();
		resp.setHttpStatus(HttpStatus.OK);
		resp.setResponseCode(ResponseConstants.SUCCESS_CODE);
		resp.setResponseDescription(token);
		resp.setStatus(ResponseConstants.SUCCESS_LOGIN_STATUS);
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

}
