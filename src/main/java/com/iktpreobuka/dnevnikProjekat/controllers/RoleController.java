package com.iktpreobuka.dnevnikProjekat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.dnevnikProjekat.entities.RoleEntity;
import com.iktpreobuka.dnevnikProjekat.repositories.RoleRepository;

@RestController
@RequestMapping("/api/v1/roles")
public class RoleController {
	
	@Autowired
	private RoleRepository roleRepo;
	
	@RequestMapping(method = RequestMethod.POST, path = "/addRole")
	public RoleEntity addRole(@RequestParam String rolename) {
		RoleEntity role = new RoleEntity();
		role.setName(rolename);
		return roleRepo.save(role);
		
	}

}
