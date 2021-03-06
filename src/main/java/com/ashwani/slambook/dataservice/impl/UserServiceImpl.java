package com.ashwani.slambook.dataservice.impl;

import java.util.List;
import java.util.Optional;

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
	public Optional<User> findByUsername(String username) {
	
		return userRepository.findByUsername(username);
	}


	@Override
	public void saveUser(User user) {
		userRepository.save(user);
		
	}


	@Override
	public List<User> getUsers(String searchString) {
		
		return userRepository.findByFirstnameContainingIgnoreCase(searchString);
	}


	
	
}
