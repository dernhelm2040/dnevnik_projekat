package com.iktpreobuka.dnevnikProjekat.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
public class AdminEntity extends UserEntity{
	
	@Column
	@NotBlank(message = "Email must not be blank or null")
	@Email(message = "Email is not valid.")
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
