package com.iktpreobuka.dnevnikProjekat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.dnevnikProjekat.entities.SubjectEntity;
import com.iktpreobuka.dnevnikProjekat.repositories.SubjectRepository;

@RestController
@RequestMapping("/api/v1/subjects")
public class SubjectController {
	
	@Autowired
	private SubjectRepository subjectRepo;
	
	// Dodaj novi predmet - testirano, radi
		@RequestMapping(method = RequestMethod.POST, path = "/addSubject")
		public SubjectEntity addSubject(@RequestParam String subjectName, @RequestParam Integer hoursPerWeek) {
			SubjectEntity subject = new SubjectEntity();
			subject.setSubjectName(subjectName);
			subject.setHoursPerWeek(hoursPerWeek);
			return subjectRepo.save(subject);		
		}
		

}
