package com.ashwani.slambook.dataservice.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashwani.slambook.dataservice.UserService;
import com.ashwani.slambook.entity.User;
import com.ashwani.slambook.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	
	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public User findByUsername(String username) {
	
		return userRepository.findByUsername(username);
	}


	@Override
	public void saveUser(User user) {
		userRepository.save(user);
		
	}


	
	
}
