/**
 * 
 */
package com.ashwani.slambook.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}
}
