package com.iktpreobuka.dnevnikProjekat.entities;

import java.util.ArrayList;
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
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class TeacherSubjectClassStudent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "studentClass")
	private StudentEntity studentClass;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "teacherSubjectClass")
	private TeacherSubjectClass teacherSubjectClass;
	
	
	@OneToMany(mappedBy = "studentGrade", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<GradeEntity> studentsGrades = new ArrayList<GradeEntity>();

	public TeacherSubjectClassStudent() {
		super();
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

	public StudentEntity getStudentClass() {
		return studentClass;
	}

	public void setStudentClass(StudentEntity studentClass) {
		this.studentClass = studentClass;
	}

	public TeacherSubjectClass getTeacherSubjectClass() {
		return teacherSubjectClass;
	}

	public void setTeacherSubjectClass(TeacherSubjectClass teacherSubjectClass) {
		this.teacherSubjectClass = teacherSubjectClass;
	}

	public List<GradeEntity> getStudentsGrades() {
		return studentsGrades;
	}

	public void setStudentsGrades(List<GradeEntity> studentsGrades) {
		this.studentsGrades = studentsGrades;
	}


	
	
	
	

}
