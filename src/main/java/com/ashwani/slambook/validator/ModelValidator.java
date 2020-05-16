/**
 * 
 */
package com.ashwani.slambook.validator;

import org.springframework.stereotype.Component;

import com.ashwani.slambook.model.request.RegistrationRequest;
import com.ashwani.slambook.util.SlamUtils;

/**
 * 
 * @author Ashwani Pandey
 * 
 * createdAt 15-May-2020
 *
*/

@Component
public class ModelValidator {

	public boolean isValidRegistrationRequest(RegistrationRequest user) {
		if(SlamUtils.isNullOrEmpty(user)
				||SlamUtils.isNullOrEmpty(user.getFirstname())
				||SlamUtils.isNullOrEmpty(user.getLastname())
				||SlamUtils.isNullOrEmpty(user.getPassword())
				||SlamUtils.isNullOrEmpty(user.getUsername())) {
			return false;
		}else {
			return true;
		}
	}
}
