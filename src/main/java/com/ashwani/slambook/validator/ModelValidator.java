/**
 * 
 */
package com.ashwani.slambook.validator;

import org.springframework.stereotype.Component;

import com.ashwani.slambook.model.request.CreateSlamRequest;
import com.ashwani.slambook.model.request.GetUserRequest;
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
	
	public boolean isValidGetUserRequest(GetUserRequest request) {
		if(SlamUtils.isNullOrEmpty(request.getUsername())
				|| SlamUtils.isNullOrEmpty(request.getToken())
				|| SlamUtils.isNullOrEmpty(request)){
			return false;
		}
		else {
			return true;
		}
	}

	/**
	 * @param req
	 * @return
	 */
	public boolean isValidCreateSlamRequest(CreateSlamRequest req) {
		
		if(SlamUtils.isNullOrEmpty(req)
				|| SlamUtils.isNullOrEmpty(req.getDescription())
				||SlamUtils.isNullOrEmpty(req.getTitle())
				|| SlamUtils.isNullOrEmpty(req.getOwner())
				|| SlamUtils.isNullOrEmpty(req.getWriter())
				||SlamUtils.isNullOrEmpty(req.getToken())
				) {
			
			return false;
		}
		return true;
	}
}

















