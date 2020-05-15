package com.ashwani.slambook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashwani.slambook.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
