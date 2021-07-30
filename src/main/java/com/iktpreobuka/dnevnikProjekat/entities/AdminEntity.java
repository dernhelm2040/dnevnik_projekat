package com.iktpreobuka.dnevnikProjekat.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class AdminEntity extends UserEntity{
	
	@Column
	protected String email;

	public AdminEntity() {
		super();
		}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public AdminEntity(String userName, String password, RoleEntity role, String email) {
		super();
		this.email = email;
	
	}
	
	
	
	

}
