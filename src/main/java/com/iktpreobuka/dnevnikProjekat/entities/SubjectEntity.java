package com.iktpreobuka.dnevnikProjekat.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SubjectEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Integer SubjectId;
	
	protected String subjectName;
	
	protected Integer hoursPerWeek;

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
