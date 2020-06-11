/**
 * 
 */
package com.ashwani.slambook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashwani.slambook.implementer.UserServiceImplementer;
import com.ashwani.slambook.model.response.GetAllFriendsResponse;

/**
 *
 * @author Ashwani Pandey
 *
 * createdAt 16-May-2020
 *
*/
@RestController
@RequestMapping(value = "/v1/api")
public class HomeController {

	
	@Autowired
	private UserServiceImplementer userServiceImplementer;
	
	
	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}
	
	@GetMapping("/getfriends")
	public GetAllFriendsResponse getAllFriends(String username) {
		return userServiceImplementer.getAllFriends(username);
	}
}
