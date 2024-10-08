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
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class TeacherSubject {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Integer id;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "teacher")
	protected TeacherEntity teacher;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "subject")
	protected SubjectEntity subject;
	
	@OneToMany(mappedBy = "teacherSubject", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JsonIgnore
	protected List<TeacherSubjectClass> teacherSubjectClass;

	public TeacherSubject() {
		super();
		}
	
	

	public List<TeacherSubjectClass> getTeacherSubjectClass() {
		return teacherSubjectClass;
	}



	public void setTeacherSubjectClass(List<TeacherSubjectClass> teacherSubjectClass) {
		this.teacherSubjectClass = teacherSubjectClass;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TeacherEntity getTeacher() {
		return teacher;
	}

	public void setTeacher(TeacherEntity teacher) {
		this.teacher = teacher;
	}

	public SubjectEntity getSubject() {
		return subject;
	}

	public void setSubject(SubjectEntity subject) {
		this.subject = subject;
	}
	
	
	
	

}
