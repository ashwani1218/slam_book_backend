package com.ashwani.slambook.service.impl;

import org.springframework.stereotype.Service;

import com.ashwani.slambook.model.request.LoginRequest;
import com.ashwani.slambook.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	public Boolean isAuthenticUser(LoginRequest user) {
		return false;
	}
}
