/**
 * 
 */
package com.ashwani.slambook.implementer;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ashwani.slambook.dataservice.UserService;
import com.ashwani.slambook.entity.User;
import com.ashwani.slambook.model.request.LoginRequest;
import com.ashwani.slambook.model.request.RegistrationRequest;
import com.ashwani.slambook.model.response.LoginResponse;
import com.ashwani.slambook.model.response.RegistrationResponse;
import com.ashwani.slambook.response_builder.SuccessConfigBuilder;
import com.ashwani.slambook.response_builder.ValidationConfigBuilder;
import com.ashwani.slambook.translator.UserTranslator;
import com.ashwani.slambook.util.JWTUtil;
import com.ashwani.slambook.util.SlamUtils;
import com.ashwani.slambook.validator.DatabaseValidator;
import com.ashwani.slambook.validator.ModelValidator;

/**
 *
 * @author Ashwani Pandey
 *
 * createdAt 16-May-2020
 *
*/

@Component
public class LoginImplementer {

	
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginImplementer.class);
	
	@Autowired
	private ValidationConfigBuilder validationConfigBuilder;
	
	@Autowired 
	private SuccessConfigBuilder sucessConfigBuilder;
	
	@Autowired
	private ModelValidator modelValidator;
	
	@Autowired
	private DatabaseValidator dbValidator;
	
	@Autowired 
	private UserService userService;
	
	@Autowired
	private UserTranslator UserTranslator;
	
	
	@Autowired 
	private JWTUtil jwtUtil;
	
	/**
	 * @param userRequest
	 * @return
	 */
	public LoginResponse authenticateUser(LoginRequest user) {
		LoginResponse response = new LoginResponse();
		
		if(SlamUtils.isNullOrEmpty(user) || SlamUtils.isNullOrEmpty(user.getUsername()) || SlamUtils.isNullOrEmpty(user.getPassword())) {
			response = validationConfigBuilder.emptyLoginRequest();
		}
		else if(!isAuthenticUser(user)) {
			response = validationConfigBuilder.unauthenticUser();
		}
		else {
			Optional<User> u = userService.findByUsername(user.getUsername());
			String token = jwtUtil.generateToken(u.get());
			response = sucessConfigBuilder.createJwt(token,u.get());
		}
		return response;
	}

	public  Boolean isAuthenticUser(LoginRequest user) {
		Optional<User> u = userService.findByUsername(user.getUsername());
		
		if(!u.isPresent()) {
			return false;
		}
		if(u.get().getPassword().equals(user.getPassword())) {
			return true;
		}
		return false;
	}

	/**
	 * @param userRequest
	 * @return
	 */
	public RegistrationResponse registerUser(RegistrationRequest userRequest) {
	
		RegistrationResponse response = new RegistrationResponse();	
		
		if(modelValidator.isValidRegistrationRequest(userRequest)) {
			if(dbValidator.isNotAUser(userRequest)) {
				User user = UserTranslator.translateRegistrationmodelToUser(userRequest);
				userService.saveUser(user);
				response = sucessConfigBuilder.registrationSuccess(user);
				
			}
			else {
				response = validationConfigBuilder.alreadyAnUser();
			}
		}
		else {
			response = validationConfigBuilder.invalidRegistrationRequest();
		}
		return response;
	}
}



















