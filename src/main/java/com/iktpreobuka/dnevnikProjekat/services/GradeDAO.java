package com.iktpreobuka.dnevnikProjekat.services;

import java.util.List;

import com.iktpreobuka.dnevnikProjekat.entities.GradeEntity;

public interface GradeDAO {
	
	public List<GradeEntity> findGradesByUserName(String name);

}
