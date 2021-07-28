package com.iktpreobuka.dnevnikProjekat.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.dnevnikProjekat.entities.ClassEntity;
import com.iktpreobuka.dnevnikProjekat.entities.ParentEntity;
import com.iktpreobuka.dnevnikProjekat.entities.StudentEntity;
import com.iktpreobuka.dnevnikProjekat.repositories.ClassRepository;
import com.iktpreobuka.dnevnikProjekat.repositories.ParentRepository;
import com.iktpreobuka.dnevnikProjekat.repositories.StudentRepository;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
	
	@Autowired
	private StudentRepository studentRepo;
	
	@Autowired
	private ParentRepository parentRepo;
	
	@Autowired
	private ClassRepository classRepo;
	
	@RequestMapping(method = RequestMethod.PUT, path = "/{studentId}/parent")
	public StudentEntity addParent(@PathVariable Integer studentId, @RequestParam Integer ParentId) {
		StudentEntity student = studentRepo.findById(studentId).get();
		ParentEntity parent = parentRepo.findById(ParentId).get();
		student.setParent(parent);
		return studentRepo.save(student);
		}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/{studentId}/classroom")
	public StudentEntity addClassroom(@PathVariable Integer studentId, @RequestParam Integer ClassId) {
		StudentEntity student = studentRepo.findById(studentId).get();
		ClassEntity classroom = classRepo.findById(ClassId).get();
		student.setClassroom(classroom);
		return studentRepo.save(student);
		}
	
	
	@RequestMapping(method = RequestMethod.GET, path = "/findByClassId/{classId}")
	public List<StudentEntity> getAllStudents(@PathVariable Integer classId){
		List<StudentEntity> result = new ArrayList<StudentEntity>();
		if(classRepo.existsById(classId)) {
			result.add(studentRepo.findById(classId).get());
			return result;
		}
			return null;
	}
	

}
