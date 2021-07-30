package com.iktpreobuka.dnevnikProjekat.entities;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;
import com.iktpreobuka.dnevnikProjekat.security.Views;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@JsonIgnoreProperties("{hibernateLazyInitializer, handler}")
public class ParentEntity extends UserEntity{
	
	@JsonView(Views.Parent.class)
	@Column(nullable = false)
	@NotBlank(message = "First name must not be blank or null")
	@Size(min = 2, max = 15, message = "First name length must be between {min} and {max} characters." )
	private String firstName;
	
	@JsonView(Views.Parent.class)
	@Column(nullable = false)
	@NotBlank(message = "Last name must not be blank or null")
	@Size(min = 2, max = 15, message = "Last name length must be between {min} and {max} characters." )
	private String lastName;
	
	@JsonView(Views.Parent.class)
	@Column(nullable = false)
	@NotBlank(message = "Email must not be blank or null")
	@Email(message = "Email is not valid.")
	private String email;
	
	@JsonView(Views.Parent.class)
	@OneToMany(mappedBy = "parent", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<StudentEntity> children = new ArrayList<StudentEntity>();
	

	public ParentEntity() {
		super();
		}
	
	
	public ParentEntity(String userName, String password, RoleEntity role, String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		}





	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

	public List<StudentEntity> getChildren() {
		return children;
	}



	public void setChildren(List<StudentEntity> children) {
		this.children = children;
	}

}
