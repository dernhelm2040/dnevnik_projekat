package com.iktpreobuka.dnevnikProjekat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.dnevnikProjekat.entities.ParentEntity;
import com.iktpreobuka.dnevnikProjekat.entities.RoleEntity;
import com.iktpreobuka.dnevnikProjekat.entities.StudentEntity;
import com.iktpreobuka.dnevnikProjekat.entities.UserEntity;
import com.iktpreobuka.dnevnikProjekat.repositories.ParentRepository;
import com.iktpreobuka.dnevnikProjekat.repositories.StudentRepository;
import com.iktpreobuka.dnevnikProjekat.repositories.TeacherRepository;
import com.iktpreobuka.dnevnikProjekat.repositories.UserRepository;


@RestController
@RequestMapping("/api/v1/users")
public class UserController {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private ParentRepository parentRepo;
	
	@Autowired
	private StudentRepository studentRepo;
	
	
	
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
	
	@RequestMapping(method = RequestMethod.POST, path = "/addStudent")
	public StudentEntity addParent(@RequestParam String userName, @RequestParam String password,
			@RequestParam String firstName, @RequestParam String lastName) {
		StudentEntity student = new StudentEntity();
		student.setUserName(userName);
		student.setPassword(password);
		student.setFirstName(firstName);
		student.setLastName(lastName);
		return studentRepo.save(student);		
	}
	

}
