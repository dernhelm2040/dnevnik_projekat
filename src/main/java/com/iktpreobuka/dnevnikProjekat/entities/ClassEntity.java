package com.iktpreobuka.dnevnikProjekat.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ClassEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Integer classId;
	
	protected String className;

	//protected List<StudentEntity> students = new ArrayList<StudentEntity>();
	
	
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
