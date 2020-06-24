package com.ashwani.slambook.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashwani.slambook.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

	
	public Optional<User> findByUsername(String username);
	
	
	
	public List<User> findByFirstnameContainingIgnoreCase(String searchString);
}
