package com.ashwani.slambook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ashwani.slambook.implementer.LoginImplementer;
import com.ashwani.slambook.model.request.LoginRequest;
import com.ashwani.slambook.model.request.RegistrationRequest;
import com.ashwani.slambook.model.response.LoginResponse;
import com.ashwani.slambook.model.response.RegistrationResponse;

@CrossOrigin(origins = "*")
@RestController
public class IndexController {

	@Autowired
	private LoginImplementer loginImplementer;
	
	@PostMapping("/login")
	public LoginResponse login(@RequestBody LoginRequest userRequest){
		LoginResponse resp = loginImplementer.authenticateUser(userRequest);
		return resp;
	}
	
	@PostMapping("/register")
	public RegistrationResponse register(@RequestBody RegistrationRequest userRequest) {
		RegistrationResponse resp = loginImplementer.registerUser(userRequest);
		return resp;
	}
}
