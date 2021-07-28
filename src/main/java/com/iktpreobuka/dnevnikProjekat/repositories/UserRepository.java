package com.iktpreobuka.dnevnikProjekat.repositories;

import org.springframework.data.repository.CrudRepository;

import com.iktpreobuka.dnevnikProjekat.entities.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {

}
