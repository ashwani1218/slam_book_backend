/**
 * 
 */
package com.ashwani.slambook.dataservice.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashwani.slambook.dataservice.SlamService;
import com.ashwani.slambook.entity.Slam;
import com.ashwani.slambook.repository.SlamRepository;

/**
 *
 * @author Ashwani Pandey
 *
 * createdAt 26-Jun-2020
 *
*/
@Service
public class SlamServiceImpl implements SlamService{

	@Autowired
	private SlamRepository slamRepository;
	
	@Override
	public void save(Slam slam) {
		slamRepository.save(slam);
		
	}

}
