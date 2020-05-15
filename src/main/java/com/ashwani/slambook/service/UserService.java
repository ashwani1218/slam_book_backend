package com.ashwani.slambook.service;

import com.ashwani.slambook.model.request.LoginRequest;

public interface UserService {

	public Boolean isAuthenticUser(LoginRequest user);
}
