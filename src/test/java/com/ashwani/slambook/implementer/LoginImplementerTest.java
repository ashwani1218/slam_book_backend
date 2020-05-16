/**
 * 
 */
package com.ashwani.slambook.implementer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ashwani.slambook.model.request.LoginRequest;
import com.ashwani.slambook.model.response.LoginResponse;
import com.ashwani.slambook.response_builder.ValidationConfigBuilder;

/**
 *
 * @author Ashwani Pandey
 *
 * createdAt 16-May-2020
 *
*/
@SpringBootTest
public class LoginImplementerTest {

	
	@Autowired 
	private LoginImplementer loginImplementer;
	
	@Mock
	private ValidationConfigBuilder validationConfigBuilder;
	
	
	@Test
	public void authenticateUser_shouldReturnInvalidResponse() {
		LoginRequest req = new LoginRequest();
		LoginResponse resp = loginImplementer.authenticateUser(req);
		assertEquals("Empty User Request", resp.getResponseDescription());
		
	}
	
	@Test
	public void authenticateUser_shouldReturnUnAuthenticUser() {
		LoginRequest req = new LoginRequest();
		req.setUsername("norbite");
		req.setPassword("test");
		LoginResponse resp = loginImplementer.authenticateUser(req);
		assertEquals("Wrong Credentials", resp.getResponseDescription());
	}
	
	@Test
	public void authenticateUser_shouldReturnCorrectResponse() {
		LoginRequest req = new LoginRequest();
		req.setUsername("norbite");
		req.setPassword("Ashwani@1");
		LoginResponse resp = loginImplementer.authenticateUser(req);
		assertEquals("SUCCESS", resp.getStatus());
	}
}
