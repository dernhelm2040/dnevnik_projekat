package com.iktpreobuka.dnevnikProjekat.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.iktpreobuka.dnevnikProjekat.entities.StudentEntity;

public interface StudentRepository extends CrudRepository<StudentEntity, Integer> {
	
	public List<StudentEntity> findByParentId(Integer parentId);
	
	public List<StudentEntity> findByClassroom(Integer classroom);

}
