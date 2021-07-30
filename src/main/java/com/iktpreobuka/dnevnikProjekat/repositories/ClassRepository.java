package com.iktpreobuka.dnevnikProjekat.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.iktpreobuka.dnevnikProjekat.entities.ClassEntity;
import com.iktpreobuka.dnevnikProjekat.entities.StudentEntity;

public interface ClassRepository extends CrudRepository<ClassEntity, Integer> {
	


}
