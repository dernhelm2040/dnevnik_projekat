package com.iktpreobuka.dnevnikProjekat.repositories;

import org.springframework.data.repository.CrudRepository;

import com.iktpreobuka.dnevnikProjekat.entities.StudentEntity;

public interface StudentRepository extends CrudRepository<StudentEntity, Integer> {

}
