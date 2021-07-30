package com.iktpreobuka.dnevnikProjekat.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;
import com.iktpreobuka.dnevnikProjekat.security.Views;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class TeacherEntity extends UserEntity{
	
	@JsonView(Views.Teacher.class)
	@NotBlank(message = "First name must not be blank or null")
	@Size(min = 2, max = 15, message = "First name length must be between {min} and {max} characters." )
	protected String firstName;
	
	@JsonView(Views.Teacher.class)
	@NotBlank(message = "Last name must not be blank or null")
	@Size(min = 2, max = 15, message = "Last name length must be between {min} and {max} characters." )
	protected String lastName;
	
	@JsonView(Views.Teacher.class)
	@OneToMany(mappedBy = "teacher", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JsonIgnore
	protected List<TeacherSubject> teacherSubject = new ArrayList<>();

	
	
	
	public List<TeacherSubject> getTeacherSubject() {
		return teacherSubject;
	}

	public void setTeacherSubject(List<TeacherSubject> teacherSubject) {
		this.teacherSubject = teacherSubject;
	}

	public TeacherEntity() {
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
