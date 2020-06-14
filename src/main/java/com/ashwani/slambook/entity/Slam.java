/**
 * 
 */
package com.ashwani.slambook.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

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
	@JoinColumn(name= "slam_owner_id")
	private User owner;
	
	@ManyToOne
	@JoinColumn(name= "slam_writer_id")
	private User writer;
	
	@NotNull(message = "Title cannot be null")
	@Column(name="slam_title")
	private String title;
	
	@NotNull(message = "Description cannot be null")
	@Column(name="slam_description")
	private String description;
	
	@Column(name = "slam_created_at")
	private Timestamp createdAt;

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

	public User getWriter() {
		return writer;
	}

	public void setWriter(User writer) {
		this.writer = writer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((owner == null) ? 0 : owner.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((writer == null) ? 0 : writer.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Slam other = (Slam) obj;
		if (createdAt == null) {
			if (other.createdAt != null)
				return false;
		} else if (!createdAt.equals(other.createdAt))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (owner == null) {
			if (other.owner != null)
				return false;
		} else if (!owner.equals(other.owner))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (writer == null) {
			if (other.writer != null)
				return false;
		} else if (!writer.equals(other.writer))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Slam [id=" + id + ", owner=" + owner + ", writer=" + writer + ", title=" + title + ", description="
				+ description + ", createdAt=" + createdAt + "]";
	}

	public Slam() {
		super();
		
	}

	public Slam(Long id, User owner, User writer, @NotNull(message = "Title cannot be null") String title,
			@NotNull(message = "Description cannot be null") String description, Timestamp createdAt) {
		super();
		this.id = id;
		this.owner = owner;
		this.writer = writer;
		this.title = title;
		this.description = description;
		this.createdAt = createdAt;
	}
	
}
