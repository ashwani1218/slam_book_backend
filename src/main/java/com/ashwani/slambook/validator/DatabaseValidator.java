package com.ashwani.slambook.validator;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ashwani.slambook.dataservice.UserService;
import com.ashwani.slambook.entity.User;
import com.ashwani.slambook.model.request.RegistrationRequest;
import com.ashwani.slambook.util.SlamUtils;

@Component
public class DatabaseValidator {

	
	@Autowired
	private UserService userService;
	
	/**
	 * @param userRequest
	 * @return
	 */
	public boolean isNotAUser(RegistrationRequest userRequest) {
		Optional<User> user = userService.findByUsername(userRequest.getUsername());
		if(!user.isPresent() || SlamUtils.isNullOrEmpty(user)) {
			return true;
		}
		return false;
	}

}
