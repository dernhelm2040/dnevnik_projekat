package com.iktpreobuka.dnevnikProjekat.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GradeEntity {
		
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Integer id;
	
	
	@Column (nullable = false)
	protected Integer grade;
	
	@Column
	protected GradeMonth gradeMonth;

	


	public GradeEntity() {
		super();
		}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public GradeMonth getGradeMonth() {
		return gradeMonth;
	}

	public void setGradeMonth(GradeMonth gradeMonth) {
		this.gradeMonth = gradeMonth;
	}
	
	
}
