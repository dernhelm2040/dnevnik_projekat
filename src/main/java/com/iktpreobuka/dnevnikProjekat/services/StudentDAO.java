package com.iktpreobuka.dnevnikProjekat.services;

import java.util.List;

import com.iktpreobuka.dnevnikProjekat.entities.StudentEntity;

public interface StudentDAO {
	
	public List<StudentEntity> findByClassroom(String clName);

}
