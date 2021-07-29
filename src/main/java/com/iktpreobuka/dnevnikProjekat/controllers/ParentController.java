package com.iktpreobuka.dnevnikProjekat.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.dnevnikProjekat.entities.ParentEntity;
import com.iktpreobuka.dnevnikProjekat.entities.StudentEntity;
import com.iktpreobuka.dnevnikProjekat.repositories.ParentRepository;
import com.iktpreobuka.dnevnikProjekat.repositories.StudentRepository;

@RestController
@RequestMapping("/api/v1/parents")
public class ParentController {
	
	@Autowired
	private ParentRepository parentRepo;
	
	@Autowired 
	private StudentRepository studentRepo;
	
	// Dodaj novog roditelja - testirano, radi 
		@RequestMapping(method = RequestMethod.POST, path = "/addParent")
		public ParentEntity addParent(@RequestParam String userName, @RequestParam String password,
				@RequestParam String firstName, @RequestParam String lastName,
				@RequestParam String email) {
			ParentEntity parent = new ParentEntity();
			parent.setUserName(userName);
			parent.setPassword(password);
			parent.setFirstName(firstName);
			parent.setLastName(lastName);
			parent.setEmail(email);
			return parentRepo.save(parent);		
		}
		
		
		
		
		// Nadji ucenike po ID roditelja - testirano, radi
		@RequestMapping(method = RequestMethod.GET, path = "/{parentId}/findByParent")
		public List<StudentEntity> findByParent(@PathVariable Integer parentId){
			return studentRepo.findByParentId(parentId);
		}
		
		
		// Prikazi sve roditelje - testirano, radi
		@RequestMapping(method = RequestMethod.GET, path = "/allParents")
		public Iterable<ParentEntity> allParents() {
			return (List<ParentEntity>) parentRepo.findAll();
		}
		
		// TO DO soft delete
		// TO DO prikazi ocene izabranog deteta
	
	

}
