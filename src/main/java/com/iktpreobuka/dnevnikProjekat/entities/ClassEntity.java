package com.iktpreobuka.dnevnikProjekat.entities;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.iktpreobuka.dnevnikProjekat.security.Views;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties("{hibernateLazyInitializer, handler}")
@JsonSerialize
public class ClassEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Integer classId;
	
	@JsonView(Views.Student.class)
	@Column
	protected String className;
	
	@JsonView(Views.Student.class)
	@OneToMany(mappedBy = "classroom", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JsonIgnore
	protected List<StudentEntity> students = new ArrayList<StudentEntity>();
	
	@JsonView(Views.Student.class)
	@OneToMany(mappedBy = "classNo", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JsonIgnore
	protected List<TeacherSubjectClass> classesTaught;
	
	
	

	public List<TeacherSubjectClass> getClassesTaught() {
		return classesTaught;
	}

	public void setClassesTaught(List<TeacherSubjectClass> classesTaught) {
		this.classesTaught = classesTaught;
	}

	public List<StudentEntity> getStudents() {
		return students;
	}

	public void setStudents(List<StudentEntity> students) {
		this.students = students;
	}
	
	
	

	public ClassEntity(Integer classId, String className, List<StudentEntity> students,
			List<TeacherSubjectClass> classNo) {
		super();
		this.classId = classId;
		this.className = className;
		
	}

	public ClassEntity() {
		super();
		}

	public Integer getClassId() {
		return classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
	
	
	
	

}
