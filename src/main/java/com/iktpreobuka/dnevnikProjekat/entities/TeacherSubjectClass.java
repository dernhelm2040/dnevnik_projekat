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
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@JsonIgnoreProperties("{hibernateLazyInitializer, handler}")
@JsonSerialize
public class TeacherSubjectClass {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Integer id;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "teacherSubject")
	protected TeacherSubject teacherSubject;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "classNo")
	protected ClassEntity classNo;
	
	@OneToMany(mappedBy = "teacherSubjectClass", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JsonIgnore
	protected List<TeacherSubjectClassStudent> studentsInClass;

	public TeacherSubjectClass() {
		super();
		}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TeacherSubject getTeacherSubject() {
		return teacherSubject;
	}

	public void setTeacherSubject(TeacherSubject teacherSubject) {
		this.teacherSubject = teacherSubject;
	}

	public ClassEntity getClassNo() {
		return classNo;
	}

	public void setClassNo(ClassEntity classNo) {
		this.classNo = classNo;
	}
	
	
	public List<TeacherSubjectClassStudent> getStudentsInClass() {
		return studentsInClass;
	}

	public void setStudentsInClass(List<TeacherSubjectClassStudent> studentsInClass) {
		this.studentsInClass = studentsInClass;
	}
	
	
	

}
