package com.iktpreobuka.dnevnikProjekat.repositories;



import org.springframework.data.repository.CrudRepository;

import com.iktpreobuka.dnevnikProjekat.entities.SubjectEntity;
import com.iktpreobuka.dnevnikProjekat.entities.TeacherSubject;

public interface SubjectRepository extends CrudRepository<SubjectEntity, Integer> {
	


}
