package com.iktpreobuka.dnevnikProjekat.controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.dnevnikProjekat.entities.ClassEntity;
import com.iktpreobuka.dnevnikProjekat.entities.StudentEntity;
import com.iktpreobuka.dnevnikProjekat.repositories.ClassRepository;
import com.iktpreobuka.dnevnikProjekat.repositories.StudentRepository;

@RestController
@RequestMapping("/api/v1/classes")
public class ClassController {
	
	@Autowired
	private ClassRepository classRepo; 
	
	@Autowired
	private StudentRepository studentRepo;
	
	// Dodaj odeljenje - testirano, radi
	@RequestMapping(method = RequestMethod.POST)
	public ClassEntity createClass(@RequestParam String className) {
		ClassEntity classroom = new ClassEntity();
		classroom.setClassName(className);
		return classRepo.save(classroom);
		}

	// Prikazi sve ucenike u odeljenju po ID odeljenja - ne radi
	//@RequestMapping(method = RequestMethod.GET, path = "/{classroom}/findByClassroom")
	//public List<StudentEntity> findByClassroom(@PathVariable Integer classroom){
		//return studentRepo.findByClassroom(classroom);
	//}

}
