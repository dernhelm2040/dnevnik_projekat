package com.iktpreobuka.dnevnikProjekat.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import com.iktpreobuka.dnevnikProjekat.entities.GradeEntity;

@Service
public class GradeDAOImpl implements GradeDAO{

	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<GradeEntity> findGradesByUserName(String name) {
		String sql = "SELECT g FROM GradeEntity g LEFT JOIN FETCH g.studentGrade s WHERE s.name == :name";
		Query query = em.createQuery(sql);
		query.setParameter("name", name);
		
		List<GradeEntity> retVals = query.getResultList();
		return retVals;
	}



}
