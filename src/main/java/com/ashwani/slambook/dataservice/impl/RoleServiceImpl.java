package com.ashwani.slambook.dataservice.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashwani.slambook.dataservice.RoleService;
import com.ashwani.slambook.entity.Role;
import com.ashwani.slambook.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public Role findByRole(String role) {
		return roleRepository.findByRole(role);
	}

	
}
