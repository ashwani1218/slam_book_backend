/**
 * 
 */
package com.ashwani.slambook.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Ashwani Pandey
 *
 * createdAt 16-May-2020
 *
*/
@Entity
@Table(name="SLAM")
public class Slam {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="slam_id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name= "user_id")
	private User owner;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}
	
	
}
