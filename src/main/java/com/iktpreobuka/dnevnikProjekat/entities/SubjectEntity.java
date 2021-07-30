package com.iktpreobuka.dnevnikProjekat.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class SubjectEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Integer SubjectId;
	
	@NotBlank(message = "Please enter subject name.")
	@Size(min = 3, max = 20, message = "Subject name must be between {min} and {max} characters." )
	protected String subjectName;
	
	@NotBlank(message = "Please enter subjects hours per week.")
	@Min(value = 1)
	protected Integer hoursPerWeek;
	
	@OneToMany(mappedBy = "subject", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JsonIgnore
	protected List<TeacherSubject> subjects = new ArrayList<>();
	
	

	public List<TeacherSubject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<TeacherSubject> subjects) {
		this.subjects = subjects;
	}

	

	public SubjectEntity() {
		super();
		}

	public Integer getSubjectId() {
		return SubjectId;
	}

	public void setSubjectId(Integer subjectId) {
		SubjectId = subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public Integer getHoursPerWeek() {
		return hoursPerWeek;
	}

	public void setHoursPerWeek(Integer hoursPerWeek) {
		this.hoursPerWeek = hoursPerWeek;
	}
	
	
	
	


}
