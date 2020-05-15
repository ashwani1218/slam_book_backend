package com.ashwani.slambook.entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "role")
public class Role {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "role_id")
	private Long id;
	
	
	@Column(name = "role", nullable = false, unique =true)
	private String role;
	
	
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "roles")
	private Collection<User> users;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public Collection<User> getUsers() {
		return users;
	}


	public void setUsers(Collection<User> users) {
		this.users = users;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + ((users == null) ? 0 : users.hashCode());
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
		Role other = (Role) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (users == null) {
			if (other.users != null)
				return false;
		} else if (!users.equals(other.users))
			return false;
		return true;
	}


	public Role(Long id, String role, Collection<User> users) {
		super();
		this.id = id;
		this.role = role;
		this.users = users;
	}


	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "Role [id=" + id + ", role=" + role + ", users=" + users + "]";
	}
	
	
}
