package com.iktpreobuka.dnevnikProjekat.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.dnevnikProjekat.entities.TeacherEntity;
import com.iktpreobuka.dnevnikProjekat.repositories.TeacherRepository;

@RestController
@RequestMapping("/api/v1/teachers")
public class TeacherController {
	
	
	@Autowired
	private TeacherRepository teacherRepo;
	
	
	// Dodaj novog nastavnika - testirano, radi 
		@RequestMapping(method = RequestMethod.POST, path = "/addTeacher")
		public TeacherEntity addTeacher(@RequestParam String userName, @RequestParam String password,
				@RequestParam String firstName, @RequestParam String lastName) {
			TeacherEntity teacher = new TeacherEntity();
			teacher.setUserName(userName);
			teacher.setPassword(password);
			teacher.setFirstName(firstName);
			teacher.setLastName(lastName);
			return teacherRepo.save(teacher);		
		}
		
		
		// Prikazi sve nastavnike - testirano, radi
		@RequestMapping(method = RequestMethod.GET, path = "/allTeachers")
		public Iterable<TeacherEntity> allTeachers() {
			return (List<TeacherEntity>) teacherRepo.findAll();
		}

}
