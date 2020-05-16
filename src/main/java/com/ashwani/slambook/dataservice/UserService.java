package com.ashwani.slambook.dataservice;

import com.ashwani.slambook.entity.User;

public interface UserService {


	public User findByUsername(String username);
	
	public void saveUser(User user);
}
