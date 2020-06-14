/**
 * 
 */
package com.ashwani.slambook.translator;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ashwani.slambook.entity.User;
import com.ashwani.slambook.model.request.RegistrationRequest;
import com.ashwani.slambook.repository.RoleRepository;

/**
 *
 * @author Ashwani Pandey
 *
 * createdAt 16-May-2020
 *
*/
@Component
public class UserTranslator {

	@Autowired
	private RoleRepository roleRepository;
	
	public User translateRegistrationmodelToUser(RegistrationRequest userRequest) {
		User user = new User();
		
		user.setFirstname(userRequest.getFirstname());
		user.setLastname(userRequest.getLastname());
		user.setUsername(userRequest.getUsername());
		user.setEmail(userRequest.getEmail());
		user.setPassword(userRequest.getPassword());
		user.setCreatedAt(new Timestamp(new Date().getTime()));
		user.setRoles(Collections.singletonList(roleRepository.findByRole("user")));
		user.setIsActive(1);
		
		return user;
	}
}
