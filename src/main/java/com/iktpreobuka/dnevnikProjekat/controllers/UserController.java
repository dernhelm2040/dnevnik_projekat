package com.iktpreobuka.dnevnikProjekat.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.iktpreobuka.dnevnikProjekat.entities.AdminEntity;
import com.iktpreobuka.dnevnikProjekat.entities.ClassEntity;
import com.iktpreobuka.dnevnikProjekat.entities.ParentEntity;
import com.iktpreobuka.dnevnikProjekat.entities.RoleEntity;
import com.iktpreobuka.dnevnikProjekat.entities.StudentEntity;
import com.iktpreobuka.dnevnikProjekat.entities.SubjectEntity;
import com.iktpreobuka.dnevnikProjekat.entities.TeacherEntity;
import com.iktpreobuka.dnevnikProjekat.entities.UserEntity;
import com.iktpreobuka.dnevnikProjekat.repositories.AdminRepository;
import com.iktpreobuka.dnevnikProjekat.repositories.ClassRepository;
import com.iktpreobuka.dnevnikProjekat.repositories.ParentRepository;
import com.iktpreobuka.dnevnikProjekat.repositories.RoleRepository;
import com.iktpreobuka.dnevnikProjekat.repositories.StudentRepository;
import com.iktpreobuka.dnevnikProjekat.repositories.SubjectRepository;
import com.iktpreobuka.dnevnikProjekat.repositories.TeacherRepository;
import com.iktpreobuka.dnevnikProjekat.repositories.UserRepository;
import com.iktpreobuka.dnevnikProjekat.security.Views;


@RestController
@RequestMapping("/api/v1/users")
public class UserController {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private RoleRepository roleRepo;
	
	@Autowired
	private AdminRepository adminRepo;
	
	
	
	
	// Napravi nalog za admina - testirano, radi
	@RequestMapping(method = RequestMethod.POST, path = "/createAdmin")
	public AdminEntity createAdmin(@RequestParam String userName, @RequestParam String password,
			@RequestParam String email) {
		AdminEntity admin = new AdminEntity();
		admin.setUserName(userName);
		admin.setPassword(password);
		admin.setEmail(email);
		return adminRepo.save(admin);		
	}
	
	
	
	// Postavi rolu za korisnika - testirano, radi
	@RequestMapping(method = RequestMethod.PUT, path = "setRole/{id}")
	public UserEntity setRole(@PathVariable Integer id, @RequestParam Integer roleId) {
		UserEntity user = userRepo.findById(id).get();
		RoleEntity role = roleRepo.findById(roleId).get();
		user.setRole(role);
		return userRepo.save(user);
		
	}
	
	
	// Nadji korisnika po IDu
	@RequestMapping(method = RequestMethod.GET, path = "/getUserById/{id}")
	public ResponseEntity<?> getUserById(@PathVariable Integer id) {
			  UserEntity user = new UserEntity();	
			  if(userRepo.existsById(id)) {
				  	user = userRepo.findById(id).get();
					return new ResponseEntity<UserEntity>(user, HttpStatus.OK);
				}else
					return new ResponseEntity<String>("User not found.", HttpStatus.NOT_FOUND);
			}
		
	}
