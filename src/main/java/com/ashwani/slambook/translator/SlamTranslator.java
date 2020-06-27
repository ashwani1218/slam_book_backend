/**
 * 
 */
package com.ashwani.slambook.translator;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ashwani.slambook.dataservice.UserService;
import com.ashwani.slambook.entity.Slam;
import com.ashwani.slambook.entity.User;
import com.ashwani.slambook.model.request.CreateSlamRequest;

/**
 *
 * @author Ashwani Pandey
 *
 * createdAt 26-Jun-2020
 *
*/
@Component
public class SlamTranslator {
	
	@Autowired
	private UserService userService;

	/**
	 * @param req
	 * @return
	 */
	public Slam translateCreateSlamRequest(CreateSlamRequest req) {

		Slam slam = new Slam();
		
		Optional<User> owner = userService.findByUsername(req.getOwner());
		Optional<User> writer = userService.findByUsername(req.getWriter());
		User o = owner.get();
		User w = writer.get();
		
		
		slam.setCreatedAt(new Timestamp(new Date().getTime()));
		slam.setDescription(req.getDescription());
		slam.setOwner(o);
		slam.setWriter(w);
		slam.setTitle(req.getTitle());
		
		
		
		return slam;
	}

}
