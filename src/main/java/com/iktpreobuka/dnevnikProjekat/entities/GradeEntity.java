package com.iktpreobuka.dnevnikProjekat.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class GradeEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Integer id;		
	

	protected Integer grade;
	
	protected GradeMonth month;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "studentGrade")
	protected TeacherSubjectClassStudent studentGrade;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	protected GradeMonth gradeMonth;

	
	public GradeEntity() {
		super();
		// TODO Auto-generated constructor stub
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
	
	public GradeMonth getMonth() {
		return month;
	}

	public void setMonth(GradeMonth month) {
		this.month = month;
	}

	public TeacherSubjectClassStudent getStudentGrade() {
		return studentGrade;
	}

	public void setStudentGrade(TeacherSubjectClassStudent studentGrade) {
		this.studentGrade = studentGrade;
	}


	
}
