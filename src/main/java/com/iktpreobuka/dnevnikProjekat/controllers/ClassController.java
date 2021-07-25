package com.iktpreobuka.dnevnikProjekat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.dnevnikProjekat.entities.ClassEntity;
import com.iktpreobuka.dnevnikProjekat.repositories.ClassRepository;

@RestController
@RequestMapping("/api/v1/classes")
public class ClassController {
	
	@Autowired
	private ClassRepository classRepo; 
	
	@RequestMapping(method = RequestMethod.POST)
	public ClassEntity createClass(@RequestParam String className) {
		ClassEntity classroom = new ClassEntity();
		classroom.setClassName(className);
		classRepo.save(classroom);
		
		return classroom;
		
	}

}
