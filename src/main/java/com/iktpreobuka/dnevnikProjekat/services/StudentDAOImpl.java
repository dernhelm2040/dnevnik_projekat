package com.iktpreobuka.dnevnikProjekat.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import com.iktpreobuka.dnevnikProjekat.entities.StudentEntity;
import com.mysql.cj.Query;

@Service
public class StudentDAOImpl implements StudentDAO{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<StudentEntity> findByClassroom(String clName) {
		
		// sql
		//SELECT * from StudentEntity se LEFT JOIN ClassEntity ce ON cs.class_id == se.classroom WHERE ce.class_name == clName
		
		String sql = "SELECT se FROM StudentEntity AS se INNER JOIN FETCH ClassEntity.students cs WHERE cs.className = :clName";
		javax.persistence.Query query = em.createQuery(sql);
		((javax.persistence.Query) query).setParameter("clName", clName);
		
		List<StudentEntity> retVals = ((javax.persistence.Query) query).getResultList();
		
		
		
		return retVals;
	}


	
	

}
