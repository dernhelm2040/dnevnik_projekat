package com.iktpreobuka.dnevnikProjekat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
	
	@Autowired
	private TeacherRepository teacherRepo;
	
	//@RequestMapping(method = RequestMethod.POST, path = "/addUser")
	//public UserEntity addUser(@RequestParam String userName, @RequestParam String password, @RequestParam eUserRole role) {
		//UserEntity user = new UserEntity();
		//user.setUserName(userName);
		//user.setPassword(password);
		//user.setRole(role);
		//return userRepo.save(user);		
	//}
	

}
