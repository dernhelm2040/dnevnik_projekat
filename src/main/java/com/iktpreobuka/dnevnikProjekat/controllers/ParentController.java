package com.iktpreobuka.dnevnikProjekat.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.dnevnikProjekat.entities.StudentEntity;
import com.iktpreobuka.dnevnikProjekat.repositories.ParentRepository;
import com.iktpreobuka.dnevnikProjekat.repositories.StudentRepository;

@RestController("/api/v1/parents")
public class ParentController {
	
	@Autowired
	private ParentRepository parentRepo;
	
	@Autowired 
	private StudentRepository studentRepo;
	
	

}
