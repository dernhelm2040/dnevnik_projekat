package com.iktpreobuka.dnevnikProjekat.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.iktpreobuka.dnevnikProjekat.entities.ParentEntity;
import com.iktpreobuka.dnevnikProjekat.entities.StudentEntity;

public interface ParentRepository extends CrudRepository<ParentEntity, Integer> {
	


}
