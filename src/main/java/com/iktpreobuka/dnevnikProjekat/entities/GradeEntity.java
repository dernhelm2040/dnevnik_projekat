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
	
	
	@Column
	protected Integer grade;
	
	@Column
	protected eGradeTerm gradeTermFinal;
	
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

	public eGradeTerm getGradeTermFinal() {
		return gradeTermFinal;
	}

	public void setGradeTermFinal(eGradeTerm gradeTermFinal) {
		this.gradeTermFinal = gradeTermFinal;
	}

	public GradeMonth getGradeMonth() {
		return gradeMonth;
	}

	public void setGradeMonth(GradeMonth gradeMonth) {
		this.gradeMonth = gradeMonth;
	}
	
	
}
