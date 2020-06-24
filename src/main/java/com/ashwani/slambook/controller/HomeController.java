/**
 * 
 */
package com.ashwani.slambook.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ashwani.slambook.implementer.UserServiceImplementer;
import com.ashwani.slambook.model.request.GetUserRequest;
import com.ashwani.slambook.model.response.GetAllFriendsResponse;
import com.ashwani.slambook.model.response.GetUsersResponse;
import com.ashwani.slambook.model.response.IsUserResponse;

/**
 *
 * @author Ashwani Pandey
 *
 * createdAt 16-May-2020
 *
*/
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class HomeController {

	private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private UserServiceImplementer userServiceImplementer;
	
	
	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}
	
	@PostMapping("/getfriends")
	public GetAllFriendsResponse getAllFriends(@RequestBody GetUserRequest req) {
		LOGGER.info("Token  {}",req.getToken() );
		return userServiceImplementer.getAllFriends(req.getUsername(),req.getToken());
	}
	
	@GetMapping("/isuser")
	public IsUserResponse isUser(@RequestBody GetUserRequest req) {
		return userServiceImplementer.isUser(req.getUsername(),req.getToken());
	}
	
	@PostMapping("/getusers")
	public GetUsersResponse getUsers( @RequestBody GetUserRequest req) {
		LOGGER.info("Token  {}",req.getToken() );
		return userServiceImplementer.getUsers(req.getUsername(),req.getToken());
	}
}
