package com.ashwani.slambook.dataservice;

import java.util.List;
import java.util.Optional;

import com.ashwani.slambook.entity.User;

public interface UserService {


	public Optional<User> findByUsername(String username);
	
	public void saveUser(User user);
	
	public List<User> getUsers(String searchString);
}
