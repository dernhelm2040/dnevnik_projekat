package com.iktpreobuka.dnevnikProjekat.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@JsonIgnoreProperties("{hibernateLazyInitializer, handler}")
@JsonSerialize
public class StudentEntity extends UserEntity{
	
	@Column(nullable = false)
	protected String firstName;
	
	@Column(nullable = false)
	protected String lastName;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "parent")
	protected ParentEntity parent;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "classroom")
	protected ClassEntity classroom;
	
	

	public StudentEntity(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		}

	public ParentEntity getParent() {
		return parent;
	}

	public void setParent(ParentEntity parent) {
		this.parent = parent;
	}

	public ClassEntity getClassroom() {
		return classroom;
	}

	public void setClassroom(ClassEntity classroom) {
		this.classroom = classroom;
	}

	public StudentEntity() {
		super();
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

}
